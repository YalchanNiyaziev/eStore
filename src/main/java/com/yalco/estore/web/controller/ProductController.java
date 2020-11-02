package com.yalco.estore.web.controller;

import com.sun.istack.NotNull;
import com.yalco.estore.exception.NoSuchResultBySearchingCriteriaException;
import com.yalco.estore.exception.IdNotFoundException;
import com.yalco.estore.model.binding.product.ProductBindingModel;
import com.yalco.estore.model.view.product.ProductViewModel;
import com.yalco.estore.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

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

    @GetMapping("/brands/categories/{categoryId}")
    public ResponseEntity<List<String>> getAllBrandsInSameCategory(@PathVariable String categoryId) throws NoSuchResultBySearchingCriteriaException {
        List<String> brands = productService.getAllBrandInSameCategory(categoryId);
        return ResponseEntity.ok(brands);
    }

    @GetMapping("/categories/{categoryId}")
    public ResponseEntity<List<ProductViewModel>> getAllByCategory(@PathVariable String categoryId) {
        List<ProductViewModel> products = productService.getProductsByCategory(categoryId);
        return ResponseEntity.ok(products);
    }

    @GetMapping("/categories/{categoryId}/brands/{brand}")
    public ResponseEntity<List<ProductViewModel>> getByAllByCategoryAndBrand(@PathVariable String categoryId, @PathVariable String brand) throws NoSuchResultBySearchingCriteriaException {
        List<ProductViewModel> products = productService.getProductsByCategoryAndBrand(categoryId,brand);
        return ResponseEntity.ok(products);
    }

    @GetMapping("/categories/{categoryId}/price/{priceRangeBegin}-{priceRangeEnd}")
    public ResponseEntity<List<ProductViewModel>> getByAllByCategoryAndPrice(@PathVariable String categoryId, @PathVariable double priceRangeBegin, @PathVariable double priceRangeEnd) throws NoSuchResultBySearchingCriteriaException {
        List<ProductViewModel> products = productService.getProductsByCategoryAndPrice(categoryId,priceRangeBegin,priceRangeEnd);
        return ResponseEntity.ok(products);
    }

    @GetMapping("/categories/{categoryId}/brands/{brand}/price/{priceRangeBegin}-{priceRangeEnd}")
    public ResponseEntity<List<ProductViewModel>> getByFilters(@PathVariable String categoryId, @PathVariable String brand,
                                             @PathVariable double priceRangeBegin, @PathVariable double priceRangeEnd) throws NoSuchResultBySearchingCriteriaException {
       List<ProductViewModel> products = productService.getProductsByCategoryAndBrandAndPrice(categoryId,brand,priceRangeBegin,priceRangeEnd);
        return ResponseEntity.ok(products);
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
