package com.yalco.estore.model.view.cart;

import com.yalco.estore.model.view.product.ProductViewModel;

import java.math.BigDecimal;

public class CartItemViewModel {
    private ProductViewModel product;
    private Integer quantity;
    private BigDecimal total;
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ProductViewModel getProduct() {
        return product;
    }

    public void setProduct(ProductViewModel product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }
}
