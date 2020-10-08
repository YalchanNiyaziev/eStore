package com.yalco.estore.model.binding;

import com.yalco.estore.entity.enums.ProductCategoryType;
import com.yalco.estore.entity.product.Category;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryPostModel {
    private String categoryType;
}
