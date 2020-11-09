package com.yalco.estore.model.binding.customer;

import com.yalco.estore.model.binding.customer.contacts.CustomerContactsBindingModel;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

public class CustomerBindingModel {

    @NotBlank
    private String name;

    @Valid
    private CustomerContactsBindingModel contacts;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CustomerContactsBindingModel getContacts() {
        return contacts;
    }

    public void setContacts(CustomerContactsBindingModel contacts) {
        this.contacts = contacts;
    }
}
