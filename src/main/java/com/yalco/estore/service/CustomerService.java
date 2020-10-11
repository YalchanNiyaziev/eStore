package com.yalco.estore.service;

import com.yalco.estore.model.binding.CustomerBindingModel;
import com.yalco.estore.model.dto.CustomerDto;

public interface CustomerService {
    CustomerDto getCustomerById(String id);
    CustomerDto createCustomer(CustomerBindingModel customerBindingModel);
    CustomerDto updateCustomer(String id,CustomerBindingModel customerBindingModel);
}
