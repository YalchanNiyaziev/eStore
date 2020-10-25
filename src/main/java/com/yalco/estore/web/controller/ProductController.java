package com.yalco.estore.web.controller;

import com.sun.istack.NotNull;
import com.yalco.estore.exception.IdNotFoundException;
import com.yalco.estore.model.binding.product.ProductBindingModel;
import com.yalco.estore.model.view.product.ProductViewModel;
import com.yalco.estore.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductViewModel> getById(@PathVariable String id) {
        return ResponseEntity.ok().build();
    }

    @PostMapping
    public ResponseEntity<ProductViewModel> create(@RequestBody ProductBindingModel productModel, @NotNull UriComponentsBuilder uriBuilder) {
        ProductViewModel productViewModel = productService.createProduct(productModel);
        return ResponseEntity
                .created(
                        uriBuilder.path("/api/categories/{id}")
                                .buildAndExpand(productViewModel.getId())
                                .toUri())
                .build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable String id, @RequestBody ProductBindingModel productBindingModel) throws IdNotFoundException {
        productService.updateProduct(id, productBindingModel);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        return ResponseEntity.noContent().build();
    }
}
