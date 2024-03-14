package ge.shop.shop.repo;

import ge.shop.shop.entity.Product;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface ProductRepo extends JpaRepository<Product,String> {
}
