package com.yalco.estore.entity.customer.contacts;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Address {
    private String id;
    private String country;
    private String city;
    private String street;
    private String streetNumber;
}
