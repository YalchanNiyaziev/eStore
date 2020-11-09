package com.yalco.estore.web.controller;

import com.yalco.estore.exception.IdNotFoundException;
import com.yalco.estore.model.binding.customer.CustomerBindingModel;
import com.yalco.estore.model.view.customer.CustomerViewModel;
import com.yalco.estore.service.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/api/customers")
@Validated
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerViewModel> getById(@PathVariable String id) throws IdNotFoundException {
        CustomerViewModel customerViewModel = customerService.getCustomerById(id);
        return ResponseEntity.ok(customerViewModel);

    }

    @PostMapping
    ResponseEntity<Void> create(@RequestBody @Valid CustomerBindingModel customerBindingModel, @NotNull UriComponentsBuilder uriBuilder) {
        CustomerViewModel customerViewModel = customerService.createCustomer(customerBindingModel);
        return
                ResponseEntity
                        .created(
                                uriBuilder.path("/api/customers/{id}")
                                        .buildAndExpand(customerViewModel.getId())
                                        .toUri()
                        )
                        .build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable String id, @RequestBody @Valid CustomerBindingModel customerBindingModel, @NotNull UriComponentsBuilder uriBuilder) throws IdNotFoundException {
        customerService.updateCustomer(id, customerBindingModel);
        return ResponseEntity
                .noContent()
                .build();
    }
}
