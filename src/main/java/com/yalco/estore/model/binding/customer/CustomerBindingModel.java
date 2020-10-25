package com.yalco.estore.model.binding.customer;

import com.yalco.estore.model.binding.customer.contacts.CustomerContactsBindingModel;

public class CustomerBindingModel {
    private String name;
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
