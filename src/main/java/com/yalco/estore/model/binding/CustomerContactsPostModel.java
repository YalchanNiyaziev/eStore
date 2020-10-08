package com.yalco.estore.model.binding;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerContactsPostModel {
    private String phone;
    private String email;
    private AddressPostModel address;
}
