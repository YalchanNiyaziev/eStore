package com.yalco.estore.service.impl;

import com.yalco.estore.entity.product.Category;
import com.yalco.estore.exception.IdNotFoundException;
import com.yalco.estore.model.binding.product.CategoryCreateModel;
import com.yalco.estore.model.view.CategoryDto;
import com.yalco.estore.repository.CategoryRepository;
import com.yalco.estore.service.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final ModelMapper mapper;

    public CategoryServiceImpl(CategoryRepository categoryRepository, ModelMapper mapper) {
        this.categoryRepository = categoryRepository;
        this.mapper = mapper;
    }

    @Override
    public CategoryDto createCategory(CategoryCreateModel categoryCreateModel) {
        Category category = mapper.map(categoryCreateModel, Category.class);
        Category savedCategory = categoryRepository.save(category);
        return mapper.map(savedCategory, CategoryDto.class);
    }

    @Override
    public CategoryDto getCategoryById(String id) throws IdNotFoundException {
        Optional<Category> category = categoryRepository.findByIdAndAccessibleTrue(UUID.fromString(id));
        return category.map(value -> mapper.map(value, CategoryDto.class)).orElseThrow(() -> new IdNotFoundException("Could not found object with id: ", id));
    }

    @Override
    public void deleteCategoryById(String id) throws IdNotFoundException {
        Optional<Category> category = Optional.ofNullable(categoryRepository
                .findByIdAndAccessibleTrue(UUID.fromString(id))
                .orElseThrow(() -> new IdNotFoundException("Could not found object with id: ", id)));
        category.get().setAccessible(false);
        categoryRepository.save(category.get());
    }

}
