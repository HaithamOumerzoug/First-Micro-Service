package com.firstmicro.categoryservice.product;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "product-service")
public interface ProductFeign {
    @GetMapping("/products/category/{categoryId}")
    List<ProductDTO> getProductsByCategory(@PathVariable("categoryId") Long categoryId);
}
