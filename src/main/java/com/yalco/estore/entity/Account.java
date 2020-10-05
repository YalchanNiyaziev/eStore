package com.yalco.estore.entity;

import com.yalco.estore.entity.customer.Customer;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class Account {
    private String id;
    private String iban;
    private BigDecimal balance;
    private Customer accountOwner;
}
