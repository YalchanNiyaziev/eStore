package com.yalco.estore.service;

import com.yalco.estore.model.binding.CategoryPostModel;
import com.yalco.estore.model.dto.CategoryDto;

public interface CategoryService {
    CategoryDto createCategory(CategoryPostModel categoryPostModel);
    CategoryDto getCategoryById(String id);

}
