package com.yalco.estore.model.view.customer;

public class CustomerViewModel {
    private String id;
    private String name;
    private CustomerContactsViewModel contacts;

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

    public CustomerContactsViewModel getContacts() {
        return contacts;
    }

    public void setContacts(CustomerContactsViewModel contacts) {
        this.contacts = contacts;
    }
}
