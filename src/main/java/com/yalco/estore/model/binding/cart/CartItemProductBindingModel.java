package com.yalco.estore.model.binding.cart;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class CartItemProductBindingModel {
    @NotBlank
    private String productId;
    @NotNull
    private Integer quantity;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

}
