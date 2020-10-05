package com.yalco.estore.entity.customer.contacts;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerContacts {
    private String id;
    private String phone;
    private String email;
    private Address address;
}
