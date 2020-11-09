package com.yalco.estore.model.binding.product.category;

import javax.validation.constraints.NotNull;
import java.util.UUID;

public class CategoryBindingModel {
    @NotNull
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
