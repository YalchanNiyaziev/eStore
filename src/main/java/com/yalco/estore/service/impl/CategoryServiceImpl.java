package com.yalco.estore.service.impl;

import com.yalco.estore.entity.product.Category;
import com.yalco.estore.model.binding.CategoryPostModel;
import com.yalco.estore.model.dto.CategoryDto;
import com.yalco.estore.repository.CategoryRepository;
import com.yalco.estore.service.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final ModelMapper mapper;

    public CategoryServiceImpl(CategoryRepository categoryRepository, ModelMapper mapper) {
        this.categoryRepository = categoryRepository;
        this.mapper = mapper;
    }

    @Override
    public CategoryDto createCategory(CategoryPostModel categoryPostModel) {
        Category category = mapper.map(categoryPostModel,Category.class);
        Category savedCategory= categoryRepository.save(category);
        return mapper.map(savedCategory,CategoryDto.class);
    }

    @Override
    public CategoryDto getCategoryById(String id) {
        return null;
    }
}
