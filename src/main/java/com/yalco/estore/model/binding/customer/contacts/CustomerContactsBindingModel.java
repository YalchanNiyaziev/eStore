package com.yalco.estore.model.binding.customer.contacts;


import com.yalco.estore.model.binding.customer.address.AddressBindingModel;

public class CustomerContactsBindingModel {
    private String phone;
    private String email;
    private AddressBindingModel address;

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

    public AddressBindingModel getAddress() {
        return address;
    }

    public void setAddress(AddressBindingModel address) {
        this.address = address;
    }
}
