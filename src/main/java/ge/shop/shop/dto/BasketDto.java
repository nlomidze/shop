package ge.shop.shop.dto;

import ge.shop.shop.entity.Basket;
import ge.shop.shop.entity.Product;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BasketDto {
    private String id;

    private ProductDto product;

    private Integer quantity;

    public BasketDto(Basket basket) {
        this.id = basket.getId();
        this.product = new ProductDto(basket.getProduct());
        this.quantity = basket.getQuantity();
    }
}
