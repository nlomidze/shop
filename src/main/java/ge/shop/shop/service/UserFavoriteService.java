package ge.shop.shop.service;

import ge.shop.shop.dto.CustomResponse;
import ge.shop.shop.dto.ProductDto;
import ge.shop.shop.dto.ResponseDto;
import ge.shop.shop.dto.UserFavoriteDto;
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
public class UserFavoriteService {

    private UserFavoriteRepo userFavoriteRepo;

    private ProductRepo productRepo;

    public List<ProductDto> getAllByUser(User user){
        return  userFavoriteRepo.getAllByUser(user.getId()).stream().map(x->new ProductDto(x.getProduct())).toList();
    }

    public ResponseDto create(User user, String productId){
        List<UserFavorite> userFavorites = userFavoriteRepo.getAllByUser(user.getId())
                .stream().filter(x->x.getProduct().getId().equals(productId)).toList();

        if(!userFavorites.isEmpty()){
            userFavoriteRepo.delete(userFavorites.get(0));
        }
        else{
            UserFavorite userFavorite = new UserFavorite();
            userFavorite.setProduct(productRepo.findById(productId).get());
            userFavorite.setUser(user);
            userFavoriteRepo.save(userFavorite);
        }
        return new ResponseDto(HttpStatus.OK,"ok");
    }

}
