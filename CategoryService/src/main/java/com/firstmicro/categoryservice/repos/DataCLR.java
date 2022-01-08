package com.firstmicro.categoryservice.repos;

import com.firstmicro.categoryservice.models.Category;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.stream.Stream;

@Component
@AllArgsConstructor
class DataCLR implements CommandLineRunner {
    @Override
    public void run(String... strings) throws Exception {
        Stream.of("Phone").forEach(s->categoryRepository.save(new Category(s)));
        categoryRepository.findAll().forEach(s->System.out.println(s.getName()));
    }
    private CategoryRepository categoryRepository;
}
