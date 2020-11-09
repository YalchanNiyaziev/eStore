package com.yalco.estore.model.view.cart;

import java.util.List;

public class CartViewModel {
    private String id;
    private List<CartItemViewModel> items;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<CartItemViewModel> getItems() {
        return items;
    }

    public void setItems(List<CartItemViewModel> items) {
        this.items = items;
    }
}
