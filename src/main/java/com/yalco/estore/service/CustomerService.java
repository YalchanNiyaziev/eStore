package com.yalco.estore.service;

import com.yalco.estore.exception.IdNotFoundException;
import com.yalco.estore.model.binding.customer.CustomerBindingModel;
import com.yalco.estore.model.view.customer.CustomerViewModel;

public interface CustomerService {
    CustomerViewModel getCustomerById(String id) throws IdNotFoundException;
    CustomerViewModel createCustomer(CustomerBindingModel customerModel);
    CustomerViewModel updateCustomer(String id, CustomerBindingModel customerModel) throws IdNotFoundException;
}
