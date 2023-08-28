package com.example.billmanagement.controller.rest;

import com.example.billmanagement.service.product_import.ProductImportService;
import com.example.billmanagement.service.product_import.request.ProductImportRequest;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product_imports")
public class ProductImportRestController {

    private final ProductImportService productImportService;

    public ProductImportRestController(ProductImportService productImportService) {
        this.productImportService = productImportService;
    }


    @GetMapping
    public Page<ProductImportRequest> getAll(@RequestParam(defaultValue = "") String search, @PageableDefault(size = 2) Pageable pageable) {
        return productImportService.getAll(search, pageable);
    }

    @PutMapping
    public ResponseEntity<?> create(@Valid @RequestBody ProductImportRequest productImport, BindingResult result) {
        productImportService.saveProductImport(productImport);
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<?> edit(@Valid @RequestBody ProductImportRequest productImport, BindingResult result) {
        productImportService.saveProductImport(productImport);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        productImportService.deleteProductImport(id);
        return ResponseEntity.noContent().build();
    }
}
