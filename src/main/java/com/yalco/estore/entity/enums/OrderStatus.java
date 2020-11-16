package com.yalco.estore.entity.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum OrderStatus {
    PENDING("pending"),
    APPROVED("approved"),
    CANCELLED("cancelled"),
    SHIPMENT("shipment"),
    DELIVERED("delivered"),
    COMPLETED("completed");

    @JsonValue
    private final String status;

    OrderStatus(String value) {
        this.status = value;
    }
    public String getStatus(){
        return status;
    }

}
