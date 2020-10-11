package com.yalco.estore.model.binding;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerContactsBindingModel {
    private String phone;
    private String email;
    private AddressBindingModel address;
}
