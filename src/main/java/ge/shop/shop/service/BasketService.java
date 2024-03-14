package ge.shop.shop.service;

import ge.shop.shop.dto.BasketDto;
import ge.shop.shop.dto.BasketRequest;
import ge.shop.shop.dto.ProductRequest;
import ge.shop.shop.dto.ResponseDto;
import ge.shop.shop.entity.Basket;
import ge.shop.shop.entity.Product;
import ge.shop.shop.entity.User;
import ge.shop.shop.repo.BasketRepo;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BasketService {

    private BasketRepo basketRepo;


    public List<BasketDto> find(User user){
        return basketRepo.findAllByUser(user.getId()).stream().map(BasketDto::new).toList();
    }

    public ResponseDto addBasket(BasketRequest request, User user){
        List<Basket> exist = basketRepo.findAllByUser(user.getId()).stream().filter(x->x.getProduct().getId().equals(request.getProductId())).toList();
        Basket basket;
        if(!exist.isEmpty()){
            basket = exist.get(0);
            basket.setQuantity(basket.getQuantity());
        }
        else{
            basket = new Basket();
            basket.setUser(user);
            basket.setProduct(new Product(request.getProductId()));
            basket.setQuantity(1);
        }
        basketRepo.save(basket);
        return new ResponseDto(HttpStatus.OK);
    }
}
