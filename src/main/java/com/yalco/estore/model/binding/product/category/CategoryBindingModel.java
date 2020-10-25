package com.yalco.estore.model.binding.product.category;

import java.util.UUID;

public class CategoryBindingModel {
    private UUID id;
    private String categoryType;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getCategoryType() {
        return categoryType;
    }

    public void setCategoryType(String categoryType) {
        this.categoryType = categoryType;
    }
}
