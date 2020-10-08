package com.yalco.estore.model.binding;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressPostModel {
    private String country;
    private String city;
    private String street;
    private String streetNumber;
}
