package com.firstmicro.productservice.controllers;

import com.firstmicro.productservice.models.Product;
import com.firstmicro.productservice.repos.ProductRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author : OUMERZOUG Haitham
 * @version 1.0
 * @since 08/01/2022
 */

@RestController
@RequestMapping("products")
@Data
public class ProductController {
    private final ProductRepository productRepository;

    @Value("${me}")
    private String me;

    @GetMapping("/me")
    public String tellMe(){
        return me;
    }

    @GetMapping("/category/{categoryId}")
    public List<Product> getProductsByCategory(@PathVariable("categoryId") Long categoryId){
        return productRepository.findAllByCategoryId(categoryId);
    }
}
