package com.example.billmanagement.controller;

import com.example.billmanagement.model.Product;
import com.example.billmanagement.repository.CategoryRepository;
import com.example.billmanagement.repository.ProductRepository;
import com.example.billmanagement.service.product.ProductService;
import com.example.billmanagement.service.product.request.ProductSaveRequest;
import com.example.billmanagement.service.product.response.ProductSaveResponse;
import com.example.billmanagement.util.AppUtils;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;
    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;

    public ProductController(CategoryRepository categoryRepository, ProductRepository productRepository) {
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
    }

    @GetMapping
    public ModelAndView showProducts() {
        ModelAndView model = new ModelAndView("product");
        model.addObject("products", productRepository.findAll());
        return model;
    }

    @GetMapping("/create")
    public ModelAndView formCreateProduct() {
        ModelAndView model = new ModelAndView("create_product");
        var category = productService.getAllCategory();
        model.addObject("product", new ProductSaveRequest());
        model.addObject("categories", category);
        return model;
    }

    @PostMapping("/create")
    public ModelAndView createProduct(@Valid @ModelAttribute("product") ProductSaveRequest product, BindingResult result) {
        ModelAndView model = new ModelAndView("create_product");
        model.addObject("categories", productService.getAllCategory());
        if (result.hasErrors())
            return model;
        productService.createProduct(product);
        return model;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView formEditProduct(@PathVariable int id) {
        ModelAndView model = new ModelAndView("edit_product");
        model.addObject("product", productService.getProductById(id));
        model.addObject("categories", categoryRepository.findAll());
        return model;
    }

    @PostMapping("/edit")
    public ModelAndView editProduct(@Valid @ModelAttribute("product") ProductSaveResponse product, BindingResult result) {
        ModelAndView model = new ModelAndView("edit_product");
        model.addObject("categories", categoryRepository.findAll());
        if (result.hasErrors())
            return model;
        productService.editProduct(product);
        return model;
    }

    @GetMapping("delete/{id}")
    public ModelAndView deleteProduct(@PathVariable int id) {
        ModelAndView model = new ModelAndView("redirect:/products");
        productService.deleteProduct(id);
        return model;
    }
}
