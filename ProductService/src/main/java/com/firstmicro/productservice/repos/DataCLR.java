package com.firstmicro.productservice.repos;

import com.firstmicro.productservice.models.Product;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.stream.Stream;

@Component
@AllArgsConstructor
class DataCLR implements CommandLineRunner {
    @Override
    public void run(String... strings) throws Exception {
        Stream.of("Laptop", "iPhone", "iPad").forEach(s->productRepository.save(new Product(s)));
        productRepository.findAll().forEach(s->System.out.println(s.getName()));
    }
    private ProductRepository productRepository;
}
