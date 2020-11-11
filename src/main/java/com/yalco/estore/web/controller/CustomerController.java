package com.yalco.estore.web.controller;

import com.yalco.estore.exception.ElementNotFoundByIdException;
import com.yalco.estore.model.binding.customer.CustomerBindingModel;
import com.yalco.estore.model.view.cart.CartViewModel;
import com.yalco.estore.model.view.customer.CustomerViewModel;
import com.yalco.estore.service.CartService;
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
    private final CartService cartService;

    public CustomerController(CustomerService customerService, CartService cartService) {
        this.customerService = customerService;
        this.cartService = cartService;
    }

    @GetMapping("/{id}/cart")
    public ResponseEntity<CartViewModel> getCart(@PathVariable String id) throws ElementNotFoundByIdException {
        CartViewModel cartViewModel = cartService.getCartByCustomerId(id);
        return ResponseEntity.ok(cartViewModel);
    }
    @GetMapping("/{id}")
    public ResponseEntity<CustomerViewModel> getById(@PathVariable String id) throws ElementNotFoundByIdException {
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
    public ResponseEntity<Void> update(@PathVariable String id, @RequestBody @Valid CustomerBindingModel customerBindingModel, @NotNull UriComponentsBuilder uriBuilder) throws ElementNotFoundByIdException {
        customerService.updateCustomer(id, customerBindingModel);
        return ResponseEntity
                .noContent()
                .build();
    }
}
