package com.yalco.estore.entity;

import com.yalco.estore.entity.enums.PaymentType;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
public class Payment {
    private UUID id;
    private Order order;
    private BigDecimal finalPrice;
    private PaymentType paymentType;
}
