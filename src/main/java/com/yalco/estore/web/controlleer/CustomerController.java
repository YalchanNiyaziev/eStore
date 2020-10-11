package com.yalco.estore.web.controlleer;

import com.sun.istack.NotNull;
import com.yalco.estore.model.binding.CustomerBindingModel;
import com.yalco.estore.model.dto.CustomerDto;
import com.yalco.estore.service.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDto> getById(@PathVariable String id){
        CustomerDto customerDto = customerService.getCustomerById(id);
        if (customerDto !=null) {
            return ResponseEntity.ok(customerDto);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    ResponseEntity<Void> create(@RequestBody CustomerBindingModel customerBindingModel, @NotNull UriComponentsBuilder uriBuilder){
        CustomerDto customerDto=  customerService.createCustomer(customerBindingModel);
        return
                ResponseEntity
                .created(
                        uriBuilder.path("/api/customers/{id}")
                                .buildAndExpand(customerDto.getId())
                                .toUri()
                )
                .build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable String id, @RequestBody CustomerBindingModel customerBindingModel,@NotNull UriComponentsBuilder uriBuilder){
       customerService.updateCustomer(id,customerBindingModel);
        return ResponseEntity
                .noContent()
                .build();
    }
}
