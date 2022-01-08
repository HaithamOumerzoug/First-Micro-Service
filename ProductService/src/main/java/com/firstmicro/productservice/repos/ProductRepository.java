package com.firstmicro.productservice.repos;

import com.firstmicro.productservice.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface ProductRepository extends JpaRepository<Product , Long> {
    List<Product> findAllByCategoryId(Long categoryId);
}
