package ge.shop.shop.repo;

import ge.shop.shop.entity.Basket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BasketRepo extends JpaRepository<Basket,String> {

    @Query("select b from Basket b where b.user.id = :userId")
    List<Basket> findAllByUser(@Param("userId") String userId);
}
