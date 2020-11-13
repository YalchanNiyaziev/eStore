package com.yalco.estore.entity.enums;

public enum OrderStatus {
    PENDING("pending"),
    APPROVED("approved"),
    CANCELLED("cancelled"),
    SHIPMENT("shipment"),
    DELIVERED("delivered"),
    COMPLETED("completed");

    private final String value;

    OrderStatus(String value) {
        this.value = value;
    }
    public String getValue(){
        return value;
    }
}
