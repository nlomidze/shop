package ge.shop.shop.service;

import ge.shop.shop.entity.User;
import ge.shop.shop.repo.UserRepo;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public User getUser(HttpServletRequest request){
        return  userRepo.findAll().get(0);
    }
}
