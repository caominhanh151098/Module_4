package com.example.billmanagement.controller;

import com.example.billmanagement.model.enums.Color;
import com.example.billmanagement.model.enums.Size;
import com.example.billmanagement.repository.ProductRepository;
import com.example.billmanagement.service.customer.CustomerService;
import com.example.billmanagement.service.customer.request.CustomerSaveProductImportRequest;
import com.example.billmanagement.service.product.ProductService;
import com.example.billmanagement.service.product.response.ShowProductsResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/product_imports")
public class ProductImportController {
    private final ProductService productService;
    private final CustomerService customerService;
    private final ProductRepository productRepository;

    public ProductImportController(ProductService productService, CustomerService customerService, ProductRepository productRepository) {
        this.productService = productService;
        this.customerService = customerService;
        this.productRepository = productRepository;
    }

    @GetMapping
    public ModelAndView showProductImports() {
        ModelAndView model = new ModelAndView("/product_import/list_product_detail");
        List<ShowProductsResponse> products = productService.getAll();
        List<CustomerSaveProductImportRequest> customer = customerService.getAll();
        model.addObject("customers", customer);
        model.addObject("products", products);
        model.addObject("sizes", Size.values());
        model.addObject("colors", Color.values());
        return model;
    }
}
