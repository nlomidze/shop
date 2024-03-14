package ge.shop.shop.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "users", schema = "core")
public class User {

    @Id
    @UuidGenerator
    private String id;

    String name;

    public User(String id) {
        this.id = id;
    }
}
