package com.yalco.estore.web.controller;

import com.yalco.estore.exception.ElementNotFoundByIdException;
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

    @GetMapping("/{name}")
    public ResponseEntity<CategoryViewModel> getByName(@PathVariable String name) throws ElementNotFoundByIdException {
        CategoryViewModel categoryViewModel = categoryService.getCategoryByName(name);
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
    public ResponseEntity<String> delete(@PathVariable String id) throws ElementNotFoundByIdException {
        categoryService.deleteCategoryById(id);
        return ResponseEntity.noContent().build();
    }


}
