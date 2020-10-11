package com.yalco.estore.service.impl;

import com.yalco.estore.entity.customer.Cart;
import com.yalco.estore.entity.customer.Customer;
import com.yalco.estore.entity.customer.CustomerContacts;
import com.yalco.estore.model.binding.CustomerBindingModel;
import com.yalco.estore.model.binding.CustomerContactsBindingModel;
import com.yalco.estore.model.dto.CustomerDto;
import com.yalco.estore.repository.CustomerRepository;
import com.yalco.estore.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
//@Transactional
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final ModelMapper modelMapper;

    public CustomerServiceImpl(CustomerRepository customerRepository, ModelMapper modelMapper) {
        this.customerRepository = customerRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public CustomerDto getCustomerById(String id) {
        Optional<Customer> customer = customerRepository.findById(UUID.fromString(id));
        return customer.map(value -> modelMapper.map(value, CustomerDto.class)).orElse(null);

    }

    @Override
    public CustomerDto createCustomer(CustomerBindingModel customerBindingModel) {
        Customer customer = modelMapper.map(customerBindingModel, Customer.class);
        customer.setCart(new Cart());
        Customer savedCustomer = customerRepository.save(customer);
        return modelMapper.map(savedCustomer, CustomerDto.class);
    }

    @Override
    public CustomerDto updateCustomer(String id, CustomerBindingModel customerBindingModel) {
        Optional<Customer> optionalCustomer = customerRepository.findById(UUID.fromString(id));
        if (optionalCustomer.isPresent()) {
            Customer customer = optionalCustomer.get();
            customer.setName(customerBindingModel.getName());

            if (isContactsModified(customerBindingModel.getContacts(), customer.getContacts())){
                CustomerContacts newContacts = transformContactsBindingModelToContactsEntity(customerBindingModel.getContacts());
                customer.setContacts(newContacts);
            }
            Customer updatedCustomer = customerRepository.save(customer);
            return modelMapper.map(updatedCustomer,CustomerDto.class);

        }
        return null;
    }

    private boolean isContactsModified(CustomerContactsBindingModel bindingModel, CustomerContacts currentContacts) {
        CustomerContacts newContacts = transformContactsBindingModelToContactsEntity(bindingModel);
        return !newContacts.equals(currentContacts);
    }

    private CustomerContacts transformContactsBindingModelToContactsEntity(
            CustomerContactsBindingModel bindingModel) {
        return modelMapper.map(bindingModel, CustomerContacts.class);
    }
}
