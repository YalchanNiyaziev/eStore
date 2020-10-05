package com.yalco.estore.entity.customer;

import com.yalco.estore.entity.Cart;
import com.yalco.estore.entity.customer.contacts.CustomerContacts;

public class Customer {
    private String id;
    private String name;
    private CustomerContacts contacts;
    private Cart cart;
}
