package com.yalco.estore.web.controller;


import com.yalco.estore.exception.NoSuchResultBySearchingCriteriaException;
import com.yalco.estore.exception.IdNotFoundException;
import com.yalco.estore.model.binding.product.ProductBindingModel;
import com.yalco.estore.model.view.product.ProductViewModel;
import com.yalco.estore.service.ProductService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
@Validated
public class ProductController {

    @Value("${products.default.sorting.criteria}")
    private String defaultSortOrderCriteria;

    @Value("${products.default.sorting.direction}")
    private String defaultSortDirection;

    @Value("${products.default.page.number}")
    private Integer defaultPage;

    @Value("${products.default.counts.elements.per.page}")
    private Integer defaultPageSize;

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

    @GetMapping("/categories/{id}")
    public ResponseEntity<List<ProductViewModel>> getAllByCategory(@RequestParam("page") Optional<Integer> page, @RequestParam("size") Optional<Integer> size,
                                                                   @RequestParam("order-by") Optional<String> order, @RequestParam("direction") Optional<String> direction,
                                                                   @PathVariable("id") String categoryId) throws NoSuchResultBySearchingCriteriaException {
        List<ProductViewModel> products = productService.getProductsByCategory(categoryId,
                page.orElse(defaultPage),
                size.orElse(defaultPageSize),
                Sort.by(
                        Sort.Direction.fromString(direction.orElse(defaultSortDirection)),
                        order.orElse(defaultSortOrderCriteria)));

        return ResponseEntity.ok(products);
    }

    @GetMapping("/categories/{categoryId}/brands/{brand}")
    public ResponseEntity<List<ProductViewModel>> getByAllByCategoryAndBrand(@PathVariable String categoryId, @PathVariable String brand,
                                                                             @RequestParam("page") Optional<Integer> page, @RequestParam("size") Optional<Integer> size,
                                                                             @RequestParam("order-by") Optional<String> order, @RequestParam("direction") Optional<String> direction) throws NoSuchResultBySearchingCriteriaException {
        List<ProductViewModel> products = productService.getProductsByCategoryAndBrand(categoryId, brand,
                page.orElse(defaultPage),
                size.orElse(defaultPageSize),
                Sort.by(
                        Sort.Direction.fromString(direction.orElse(defaultSortDirection)),
                        order.orElse(defaultSortOrderCriteria)));
        return ResponseEntity.ok(products);
    }

    @GetMapping("/categories/{categoryId}/price/{priceRangeBegin}-{priceRangeEnd}")
    public ResponseEntity<List<ProductViewModel>> getByAllByCategoryAndPrice(@PathVariable String categoryId, @PathVariable double priceRangeBegin, @PathVariable double priceRangeEnd,
                                                                             @RequestParam("page") Optional<Integer> page, @RequestParam("size") Optional<Integer> size,
                                                                             @RequestParam("order-by") Optional<String> order, @RequestParam("direction") Optional<String> direction) throws NoSuchResultBySearchingCriteriaException {

        List<ProductViewModel> products = productService.getProductsByCategoryAndPrice(categoryId, priceRangeBegin, priceRangeEnd,
                page.orElse(defaultPage),
                size.orElse(defaultPageSize),
                Sort.by(
                        Sort.Direction.fromString(direction.orElse(defaultSortDirection)),
                        order.orElse(defaultSortOrderCriteria)));
        return ResponseEntity.ok(products);
    }

    @GetMapping("/categories/{categoryId}/brands/{brand}/price/{priceRangeBegin}-{priceRangeEnd}")
    public ResponseEntity<List<ProductViewModel>> getByFilters(@PathVariable String categoryId, @PathVariable String brand,
                                                               @PathVariable double priceRangeBegin, @PathVariable double priceRangeEnd,
                                                               @RequestParam("page") Optional<Integer> page, @RequestParam("size") Optional<Integer> size,
                                                               @RequestParam("order-by") Optional<String> order, @RequestParam("direction") Optional<String> direction) throws NoSuchResultBySearchingCriteriaException {

        List<ProductViewModel> products = productService.getProductsByCategoryAndBrandAndPrice(categoryId, brand, priceRangeBegin, priceRangeEnd,
                page.orElse(defaultPage),
                size.orElse(defaultPageSize),
                Sort.by(
                        Sort.Direction.fromString(direction.orElse(defaultSortDirection)),
                        order.orElse(defaultSortOrderCriteria)));
        return ResponseEntity.ok(products);
    }


    @PostMapping
    public ResponseEntity<ProductViewModel> create(@RequestBody @Valid ProductBindingModel productModel, @NotNull UriComponentsBuilder uriBuilder) {
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
