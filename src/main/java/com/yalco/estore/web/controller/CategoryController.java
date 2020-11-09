package com.yalco.estore.web.controller;

import com.yalco.estore.exception.IdNotFoundException;
import com.yalco.estore.model.binding.product.category.CategoryCreateModel;
import com.yalco.estore.model.view.product.category.CategoryViewModel;
import com.yalco.estore.service.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/categories")
@Validated
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryViewModel> getById(@PathVariable String id) throws IdNotFoundException {
        CategoryViewModel categoryViewModel = categoryService.getCategoryById(id);
        if (categoryViewModel != null) {
            return ResponseEntity.ok(categoryViewModel);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody @Valid CategoryCreateModel categoryCreateModel, UriComponentsBuilder uriBuilder) {
        CategoryViewModel categoryViewModel = categoryService.createCategory(categoryCreateModel);
        return

                ResponseEntity
                        .created(
                                uriBuilder.path("/api/categories/{id}")
                                        .buildAndExpand(categoryViewModel.getId())
                                        .toUri()
                        )
                        .build();

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable String id) throws IdNotFoundException {
        categoryService.deleteCategoryById(id);
        return ResponseEntity.noContent().build();
    }


}
