package com.yalco.estore.entity.purchase;

import com.yalco.estore.entity.enums.PaymentType;
import com.yalco.estore.entity.purchase.Order;
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
