package com.yalco.estore.model.binding;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerBindingModel {
    private String id;
    private String name;
    private CustomerContactsBindingModel contacts;
}
