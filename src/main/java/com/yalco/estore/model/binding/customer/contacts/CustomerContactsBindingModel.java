package com.yalco.estore.model.binding.customer.contacts;


import com.yalco.estore.model.binding.customer.address.AddressBindingModel;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

public class CustomerContactsBindingModel {

    @NotBlank
    private String phone;

    @NotBlank
    private String email;

    @Valid
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
