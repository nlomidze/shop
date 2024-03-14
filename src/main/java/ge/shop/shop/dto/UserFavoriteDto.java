package ge.shop.shop.dto;

import ge.shop.shop.entity.UserFavorite;
import lombok.Getter;

@Getter
public class UserFavoriteDto {
    private String id;
    private String productId;
    private String productName;


    public UserFavoriteDto(UserFavorite entity) {
        this.id = entity.getId();
        this.productId = entity.getProduct().getId();
        this.productName = entity.getProduct().getName();
    }
}
