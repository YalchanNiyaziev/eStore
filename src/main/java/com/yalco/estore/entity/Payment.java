package com.yalco.estore.entity;

import com.yalco.estore.entity.enums.PaymentType;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class Payment {
    private String id;
    private Order order;
    private BigDecimal finalPrice;
    private PaymentType paymentType;
}
