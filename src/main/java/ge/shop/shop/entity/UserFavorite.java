package ge.shop.shop.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.UuidGenerator;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "user_favorites", schema = "core")
public class UserFavorite {
    @Id
    @UuidGenerator
    private String id;

    @ManyToOne
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;
}
