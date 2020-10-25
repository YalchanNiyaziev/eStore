package com.yalco.estore.service;

import com.yalco.estore.exception.IdNotFoundException;
import com.yalco.estore.model.binding.product.category.CategoryCreateModel;
import com.yalco.estore.model.view.product.category.CategoryViewModel;

public interface CategoryService {
    CategoryViewModel createCategory(CategoryCreateModel categoryCreateModel);
    CategoryViewModel getCategoryById(String id) throws IdNotFoundException;
    void deleteCategoryById(String id) throws IdNotFoundException;

}
