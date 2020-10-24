package com.yalco.estore.model.binding.customer;


import com.yalco.estore.model.binding.CustomerContactsBindingModel;

public class CustomerUpdateModel {
    private String id;
    private String name;
    private CustomerContactsBindingModel contacts;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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
