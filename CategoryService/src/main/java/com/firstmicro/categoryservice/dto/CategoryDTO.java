package com.firstmicro.categoryservice.dto;

import com.firstmicro.categoryservice.product.ProductDTO;
import lombok.Data;

import java.util.Set;

@Data
public class CategoryDTO {
    protected Long id;

    protected String name;

    protected Set<ProductDTO> products;
}
