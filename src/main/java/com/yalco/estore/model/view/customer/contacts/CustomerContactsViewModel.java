package com.yalco.estore.model.view.customer.contacts;

import com.yalco.estore.model.view.customer.address.AddressViewModel;

public class CustomerContactsViewModel {
    private String phone;
    private String email;
    private AddressViewModel address;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public AddressViewModel getAddress() {
        return address;
    }

    public void setAddress(AddressViewModel address) {
        this.address = address;
    }
}
