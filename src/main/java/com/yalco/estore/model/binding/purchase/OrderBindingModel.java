package com.yalco.estore.model.binding.purchase;

import java.time.LocalDate;


public class OrderBindingModel {
    private String cartId;
    private LocalDate orderDate;


    public String getCartId() {
        return cartId;
    }

    public void setCartId(String cartId) {
        this.cartId = cartId;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

}
