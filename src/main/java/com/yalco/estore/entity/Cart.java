package com.yalco.estore.entity;

import com.yalco.estore.entity.product.Product;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Cart {
    private String id;
    List<Product> products;
}
