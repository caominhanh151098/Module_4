package com.example.billmanagement.controller.rest;

import com.example.billmanagement.service.product.ProductService;
import com.example.billmanagement.service.product.request.ProductSaveRequest;
import com.example.billmanagement.service.product.response.ShowProductsResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductRestController {
    public final ProductService productService;

    public ProductRestController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<ShowProductsResponse> showProducts() {
        return productService.getAll();
    }

    @PostMapping
    public ResponseEntity<?> createProduct (@Valid @RequestBody ProductSaveRequest product) {
        productService.createProduct(product);
        return ResponseEntity.noContent().build();
    }

    @PutMapping
    public ResponseEntity<?> editProduct (@Valid @RequestBody ProductSaveRequest product) {
        productService.createProduct(product);
        return ResponseEntity.noContent().build();
    }
}
