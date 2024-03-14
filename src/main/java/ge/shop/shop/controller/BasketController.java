package ge.shop.shop.controller;

import ge.shop.shop.dto.*;
import ge.shop.shop.service.BasketService;
import ge.shop.shop.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("basket")
public class BasketController {


    @Autowired
    private BasketService basketService;

    @Autowired
    private UserService userService;


    @GetMapping("")
    public ResponseEntity<List<BasketDto>> find(HttpServletRequest request) {
        return new ResponseEntity<>(basketService.find(userService.getUser(request)), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<ResponseDto> create(
            @RequestBody BasketRequest basketRequest, HttpServletRequest request) {
        return new ResponseEntity<>(basketService.addBasket(basketRequest,userService.getUser(request)), HttpStatus.OK);
    }

}
