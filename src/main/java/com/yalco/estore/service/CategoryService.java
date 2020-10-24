package com.yalco.estore.service;

import com.yalco.estore.exception.IdNotFoundException;
import com.yalco.estore.model.binding.product.CategoryCreateModel;
import com.yalco.estore.model.view.CategoryDto;

public interface CategoryService {
    CategoryDto createCategory(CategoryCreateModel categoryCreateModel);
    CategoryDto getCategoryById(String id) throws IdNotFoundException;
    void deleteCategoryById(String id) throws IdNotFoundException;

}
