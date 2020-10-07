package com.yalco.estore.web.controlleer;

import com.yalco.estore.model.binding.CategoryPostModel;
import com.yalco.estore.model.dto.CategoryDto;
import com.yalco.estore.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<CategoryDto> getById(@PathVariable String id){
        int b =5;
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setId("15");
        return ResponseEntity.ok(categoryDto);
    }
    @PostMapping
    public ResponseEntity<Void> create(@RequestBody CategoryPostModel categoryPostModel, UriComponentsBuilder uriBuilder){
        CategoryDto categoryDto = categoryService.createCategory(categoryPostModel);
        return
                ResponseEntity
                        .created(
                                uriBuilder.path("/api/categories/{id}")
                                          .buildAndExpand(categoryDto.getId())
                                          .toUri()
                        )
                        .build();
    }

}
