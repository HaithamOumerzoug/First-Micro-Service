package com.firstmicro.productservice.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
    @Value("${me}")
    private String me;

    @GetMapping("/me")
    public String tellMe(){
        return me;
    }
}
