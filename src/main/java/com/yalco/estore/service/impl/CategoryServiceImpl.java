package com.yalco.estore.service.impl;

import com.yalco.estore.entity.product.Category;
import com.yalco.estore.exception.ElementNotFoundByIdException;
import com.yalco.estore.model.binding.product.category.CategoryCreateModel;
import com.yalco.estore.model.view.product.category.CategoryViewModel;
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
    public CategoryViewModel createCategory(CategoryCreateModel categoryCreateModel) {
        Category category = mapper.map(categoryCreateModel, Category.class);
        Category savedCategory = categoryRepository.save(category);
        return mapper.map(savedCategory, CategoryViewModel.class);
    }

    @Override
    public CategoryViewModel getCategoryById(String id) throws ElementNotFoundByIdException {
        Optional<Category> category = categoryRepository.findByIdAndAccessibleTrue(UUID.fromString(id));
        return category.map(value -> mapper.map(value, CategoryViewModel.class)).orElseThrow(() -> new ElementNotFoundByIdException("Could not found object with id: ", id));
    }

    @Override
    public void deleteCategoryById(String id) throws ElementNotFoundByIdException {
        Optional<Category> category = Optional.ofNullable(categoryRepository
                .findByIdAndAccessibleTrue(UUID.fromString(id))
                .orElseThrow(() -> new ElementNotFoundByIdException("Could not found object with id: ", id)));
        category.get().setAccessible(false);
        categoryRepository.save(category.get());
    }

}
