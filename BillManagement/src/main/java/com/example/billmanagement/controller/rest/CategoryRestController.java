package com.example.billmanagement.controller.rest;

import com.example.billmanagement.service.product.CategoryService;
import com.example.billmanagement.service.customer.response.CategorySaveResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryRestController {
    private final CategoryService categoryService;

    public CategoryRestController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public List<CategorySaveResponse> getAllCategory() {
        return categoryService.getAll();
    }
}
