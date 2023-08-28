package com.example.billmanagement.controller.rest;

import com.example.billmanagement.service.product.ProductService;
import com.example.billmanagement.service.product.request.ProductSaveRequest;
import com.example.billmanagement.service.product.response.ShowProductsResponse;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
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
    public Page<ShowProductsResponse> showProducts(@RequestParam(defaultValue = "") String search,
                                                   @RequestParam(defaultValue = "0") String minPrice,
                                                   @RequestParam(defaultValue = "100000") String maxPrice,
                                                   @PageableDefault(size = 4) Pageable pageable) {
        return productService.getAllWithSearchAndPage(search, minPrice, maxPrice, pageable);
    }

    @PostMapping
    public ResponseEntity<?> createProduct(@Valid @RequestBody ProductSaveRequest product, BindingResult result) {
        if (result.hasErrors())
            return ResponseEntity.noContent().build();

        productService.createProduct(product);
        return ResponseEntity.noContent().build();
    }

    @PutMapping
    public ResponseEntity<?> editProduct(@Valid @RequestBody ProductSaveRequest product) {
        productService.createProduct(product);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable int id) {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }
}
