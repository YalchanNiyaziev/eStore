package com.yalco.estore.model.binding.purchase;

import com.yalco.estore.entity.enums.OrderStatus;

public class OrderStatusBindingModel {
    private OrderStatus status;

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }
}
