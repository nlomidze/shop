package ge.shop.shop.dto;

import ge.shop.shop.entity.ProductSize;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ProductRequest {
    private String id;

    private String name;

    private String code;

    private Float price;

    private String img;

    private ProductSize size;


}
