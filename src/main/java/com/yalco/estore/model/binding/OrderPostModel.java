package com.yalco.estore.model.binding;

import com.yalco.estore.model.binding.customer.CustomerUpdateModel;

import java.time.LocalDate;
import java.util.Set;

public class OrderPostModel {
    private String id;
    private String orderNumber;
    private LocalDate orderDate;
    private CustomerUpdateModel customer;
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

    public CustomerUpdateModel getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerUpdateModel customer) {
        this.customer = customer;
    }

    public Set<ProductBindingModel> getProducts() {
        return products;
    }

    public void setProducts(Set<ProductBindingModel> products) {
        this.products = products;
    }
}
