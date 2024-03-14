package ge.shop.shop.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "products", schema = "core")
public class Product {

    @Id
    @UuidGenerator
    private String id;

    String name;

    String code;

    Float price;

    String img;

    @Enumerated(EnumType.STRING)
    ProductSize size;

    public Product(String id) {
        this.id = id;
    }
}
