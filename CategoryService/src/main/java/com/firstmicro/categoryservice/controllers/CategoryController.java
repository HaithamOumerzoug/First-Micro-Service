package com.firstmicro.categoryservice.controllers;

import com.firstmicro.categoryservice.converter.CategoryConverter;
import com.firstmicro.categoryservice.dto.CategoryDTO;
import com.firstmicro.categoryservice.models.Category;
import com.firstmicro.categoryservice.product.ProductDTO;
import com.firstmicro.categoryservice.product.ProductFeign;
import com.firstmicro.categoryservice.repos.CategoryRepository;
import lombok.Data;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author : OUMERZOUG Haitham
 * @version 1.0
 * @since 08/01/2022
 */
@RestController
@RequestMapping("category")
@Data
public class CategoryController {
    private final ProductFeign productFeign;
    private final CategoryRepository categoryRepository;
    private final CategoryConverter categoryConverter;

    // Get all products by category from product service
    @GetMapping("allProducts/{catgoryId}")
    public List<ProductDTO> getAllProductsByCategory(@PathVariable("catgoryId") Long categoryId){
        return productFeign.getProductsByCategory(categoryId);
    }

    // Get all categories with products
    @GetMapping("allCategories")
    public List<CategoryDTO> findAllCategories(){
        List<Category> categories = categoryRepository.findAll();
        List<CategoryDTO> categoryDTOS = new ArrayList<>();
        categories.forEach(category -> {
            categoryDTOS.add(categoryConverter.convertToDTO(category));
        });
        categoryDTOS.forEach(categoryDTO -> {
           categoryDTO.setProducts(Set.copyOf(productFeign.getProductsByCategory(categoryDTO.getId())));
        });
        return categoryDTOS;
    }

}
