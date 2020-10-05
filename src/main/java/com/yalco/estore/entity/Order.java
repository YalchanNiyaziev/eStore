package com.yalco.estore.entity;

import com.yalco.estore.entity.customer.Customer;
import com.yalco.estore.entity.product.Product;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Order {
    private String id;
    private String orderNumber;
    private Customer customer;
    private List<Product> products;
}
