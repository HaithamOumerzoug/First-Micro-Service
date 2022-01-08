package com.firstmicro.productservice.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Product implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private Long categoryId;

    public Product(String s , Long categoryId) {
        this.name = s;
        this.categoryId=categoryId;
    }
}
