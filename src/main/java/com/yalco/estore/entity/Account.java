package com.yalco.estore.entity;

import com.yalco.estore.entity.customer.Customer;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
public class Account {
    private UUID id;
    private String iban;
    private BigDecimal balance;
    private Customer accountOwner;
}
