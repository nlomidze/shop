package ge.shop.shop.controller;

import ge.shop.shop.dto.BaseDto;
import ge.shop.shop.dto.ProductDto;
import ge.shop.shop.dto.ProductRequest;
import ge.shop.shop.dto.ResponseDto;
import ge.shop.shop.entity.ProductSize;
import ge.shop.shop.service.ProductService;
import ge.shop.shop.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("product")
@AllArgsConstructor
public class ProductController {


    private ProductService productService;

    private UserService userService;


    @GetMapping("")
    public ResponseEntity<List<ProductDto>> find(HttpServletRequest request) {
        return new ResponseEntity<>(productService.getProducts(userService.getUser(request)), HttpStatus.OK);
    }

    @GetMapping("sizes")
    public ResponseEntity<List<BaseDto>> getProductSize(HttpServletRequest request) {
        List<BaseDto> dtos = Arrays.stream(ProductSize.values()).map(x-> new BaseDto(x.name(),x.name())).toList();
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<ResponseDto> create(
            @RequestBody ProductRequest productRequest
            ) {
        return new ResponseEntity<>(productService.addProduct(productRequest), HttpStatus.OK);
    }
}
