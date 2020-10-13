package com.yalco.estore.model.binding;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.UUID;

public class OrderPostModel {
    private String id;
    private String orderNumber;
    private LocalDate orderDate;
    private CustomerBindingModel customer;
    private Set<ProductBindingModel> products;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public CustomerBindingModel getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerBindingModel customer) {
        this.customer = customer;
    }

    public Set<ProductBindingModel> getProducts() {
        return products;
    }

    public void setProducts(Set<ProductBindingModel> products) {
        this.products = products;
    }
}
