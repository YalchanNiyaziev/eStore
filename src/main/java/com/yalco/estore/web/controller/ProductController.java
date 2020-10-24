package com.yalco.estore.web.controller;

import com.sun.istack.NotNull;
import com.yalco.estore.model.binding.product.ProductCreateModel;
import com.yalco.estore.model.view.product.ProductViewModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @GetMapping("/{id}")
    public ResponseEntity<ProductViewModel> getById(@PathVariable String id){
        return ResponseEntity.ok().build();
    }
    
    @PostMapping
    public ResponseEntity<Void> create(@RequestBody ProductCreateModel productModel, @NotNull UriComponentsBuilder uriBuilder){
        return ResponseEntity.ok().build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id){
        return ResponseEntity.noContent().build();
    }
}
