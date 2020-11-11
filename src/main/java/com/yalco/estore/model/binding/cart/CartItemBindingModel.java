package com.yalco.estore.model.binding.cart;


import javax.validation.constraints.NotNull;

public class CartItemBindingModel {
    @NotNull
    private Integer quantity;

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
