package ge.shop.shop.controller;

import ge.shop.shop.dto.*;
import ge.shop.shop.service.UserFavoriteService;
import ge.shop.shop.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("favorite")
@AllArgsConstructor
public class FavoriteController {

    private UserFavoriteService userFavoriteService;

    private UserService userService;


    @GetMapping("")
    public ResponseEntity<List<ProductDto>> find(HttpServletRequest request) {
        return new ResponseEntity<>(userFavoriteService.getAllByUser(userService.getUser(request)), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<ResponseDto> create(
            @RequestParam String productId, HttpServletRequest request) {
        return new ResponseEntity<>(userFavoriteService.create(userService.getUser(request),productId), HttpStatus.OK);
    }

}
