package com.firstmicro.categoryservice.converter;

import com.firstmicro.categoryservice.dto.CategoryDTO;
import com.firstmicro.categoryservice.models.Category;
import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;
import org.springframework.stereotype.Component;

@Component
public class CategoryConverter extends AbstractConverter<Category, CategoryDTO> {

    private final ModelMapper modelMapper;

    public CategoryConverter(ModelMapper modelMapper) {
        modelMapper.getConfiguration()
                .setFieldMatchingEnabled(true)
                .setFieldAccessLevel(Configuration.AccessLevel.PRIVATE);
        this.modelMapper = modelMapper;
    }

    @Override
    public Category convertToDM(CategoryDTO movieDTO) {
        return modelMapper.map(movieDTO, Category.class);
    }

    @Override
    public CategoryDTO convertToDTO(Category movie) {
        return modelMapper.map(movie, CategoryDTO.class);
    }
}
