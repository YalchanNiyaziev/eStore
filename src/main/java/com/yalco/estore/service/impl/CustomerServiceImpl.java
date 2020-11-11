package com.yalco.estore.service.impl;

import com.yalco.estore.entity.cart.Cart;
import com.yalco.estore.entity.customer.Customer;
import com.yalco.estore.entity.customer.CustomerContacts;
import com.yalco.estore.exception.ElementNotFoundByIdException;
import com.yalco.estore.model.binding.customer.CustomerBindingModel;
import com.yalco.estore.model.binding.customer.contacts.CustomerContactsBindingModel;
import com.yalco.estore.model.view.customer.CustomerViewModel;
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
    public CustomerViewModel getCustomerById(String id) throws ElementNotFoundByIdException {
        Optional<Customer> customer = customerRepository.findById(UUID.fromString(id));
        return customer.map(value -> modelMapper.map(value, CustomerViewModel.class)).orElseThrow(() -> new ElementNotFoundByIdException("Could not found object with id: ", id));

    }

    @Override
    public CustomerViewModel createCustomer(CustomerBindingModel customerModel) {
        Customer customer = modelMapper.map(customerModel, Customer.class);
        customer.setCart(new Cart());
        Customer savedCustomer = customerRepository.save(customer);
        return modelMapper.map(savedCustomer, CustomerViewModel.class);
    }

    @Override
    public CustomerViewModel updateCustomer(String id, CustomerBindingModel customerBindingModel) throws ElementNotFoundByIdException {
        Optional<Customer> optionalCustomer = customerRepository.findById(UUID.fromString(id));
        if (!optionalCustomer.isPresent()) {
            throw new ElementNotFoundByIdException("Could not found object with id: ", id);
        }

        Customer customer = optionalCustomer.get();
        customer.setName(customerBindingModel.getName());
        if (isContactsModified(customerBindingModel.getContacts(), customer.getContacts())) {
            CustomerContacts newContacts = transformContactsBindingModelToContactsEntity(customerBindingModel.getContacts());
            customer.setContacts(newContacts);
        }
        Customer updatedCustomer = customerRepository.save(customer);
        return modelMapper.map(updatedCustomer, CustomerViewModel.class);
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
