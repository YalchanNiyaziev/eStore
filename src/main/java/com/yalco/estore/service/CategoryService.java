package com.yalco.estore.service;

import com.yalco.estore.exception.ElementNotFoundByIdException;
import com.yalco.estore.model.binding.product.category.CategoryCreateModel;
import com.yalco.estore.model.view.product.category.CategoryViewModel;

public interface CategoryService {
    CategoryViewModel createCategory(CategoryCreateModel categoryCreateModel);
    CategoryViewModel getCategoryById(String id) throws ElementNotFoundByIdException;
    CategoryViewModel getCategoryByName(String name) throws ElementNotFoundByIdException;
    void deleteCategoryById(String id) throws ElementNotFoundByIdException;

}
