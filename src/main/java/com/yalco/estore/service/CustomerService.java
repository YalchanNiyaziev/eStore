package com.yalco.estore.service;

import com.yalco.estore.exception.IdNotFoundException;
import com.yalco.estore.model.binding.customer.CustomerCreateModel;
import com.yalco.estore.model.binding.customer.CustomerUpdateModel;
import com.yalco.estore.model.view.customer.CustomerViewModel;

public interface CustomerService {
    CustomerViewModel getCustomerById(String id) throws IdNotFoundException;
    CustomerViewModel createCustomer(CustomerCreateModel customerModel);
    CustomerViewModel updateCustomer(String id, CustomerUpdateModel customerModel) throws IdNotFoundException;
}
