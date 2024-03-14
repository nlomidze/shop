package ge.shop.shop.repo;

import ge.shop.shop.entity.UserFavorite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserFavoriteRepo extends JpaRepository<UserFavorite,String> {

    @Query("select u from UserFavorite u where u.user.id = :userId")
    List<UserFavorite> getAllByUser(String userId);
}
