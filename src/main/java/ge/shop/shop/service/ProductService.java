package ge.shop.shop.service;

import ge.shop.shop.dto.ProductDto;
import ge.shop.shop.dto.ProductRequest;
import ge.shop.shop.dto.ResponseDto;
import ge.shop.shop.entity.Product;
import ge.shop.shop.entity.User;
import ge.shop.shop.entity.UserFavorite;
import ge.shop.shop.repo.ProductRepo;
import ge.shop.shop.repo.UserFavoriteRepo;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductService {


    private ProductRepo productRepo;

    private UserFavoriteRepo userFavoriteRepo;

    public List<ProductDto> getProducts(User user){
        List<ProductDto> productDtos = productRepo.findAll().stream().map(ProductDto::new).toList();
        List<String> userFavorites = userFavoriteRepo.getAllByUser(user.getId()).stream().map(x->x.getProduct().getId()).toList();
        productDtos.forEach(x->{
            if(userFavorites.contains(x.getId())){
                x.setIsFavorite(true);
            }
            else{
                x.setIsFavorite(false);
            }
        });
        return  productDtos;
    }

    public ResponseDto addProduct(ProductRequest request){
        Product product = new Product();
        product.setCode(request.getCode());
        product.setName(request.getName());
        product.setImg(request.getImg());
        product.setPrice(request.getPrice());
        product.setSize(request.getSize());
        productRepo.save(product);
        return new ResponseDto(HttpStatus.OK);
    }
}
