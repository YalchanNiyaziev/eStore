package com.yalco.estore.web.controller;

import com.yalco.estore.exception.IdNotFoundException;
import com.yalco.estore.model.binding.product.CategoryCreateModel;
import com.yalco.estore.model.view.CategoryDto;
import com.yalco.estore.service.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryDto> getById(@PathVariable String id) throws IdNotFoundException {
        CategoryDto categoryDto = categoryService.getCategoryById(id);
        if (categoryDto != null) {
            return ResponseEntity.ok(categoryDto);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody @NonNull CategoryCreateModel categoryCreateModel, UriComponentsBuilder uriBuilder) {
        CategoryDto categoryDto = categoryService.createCategory(categoryCreateModel);
        return

                ResponseEntity
                        .created(
                                uriBuilder.path("/api/categories/{id}")
                                        .buildAndExpand(categoryDto.getId())
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
