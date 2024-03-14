package ge.shop.shop.dto;

import ge.shop.shop.entity.Product;
import ge.shop.shop.entity.ProductSize;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
@Setter
public class ProductDto {
    private String id;

    private String name;

    private String code;

    private Float price;

    private String img;

    private ProductSize size;

    private Boolean isFavorite;

    public ProductDto(Product product) {
        this.id = product.getId();
        this.name = product.getName();
        this.code = product.getCode();
        this.price = product.getPrice();
        this.img = product.getImg();
        this.size = product.getSize();
    }
}
