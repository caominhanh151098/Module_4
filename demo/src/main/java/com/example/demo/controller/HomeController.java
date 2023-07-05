package com.example.demo.controller;

import com.example.demo.model.Category;
import com.example.demo.model.Product;
import com.example.demo.service.CategoryService;
import com.example.demo.service.ProductService;
import com.example.demo.service.form.CreateProductForm;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/product")
public class HomeController {
    private final ProductService productService;
    private final CategoryService categoryService;

    public HomeController(ProductService productService, CategoryService categoryService) {
        this.productService = productService;
        this.categoryService = categoryService;
    }

    @GetMapping
    public String showProducts(Model model) {
        model.addAttribute("products", productService.getProducts());
        return "index";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        CreateProductForm createForm = new CreateProductForm();
        model.addAttribute("createForm", createForm);
        model.addAttribute("categories", categoryService.getAll());
        return "create";
    }

    @PostMapping("/create")
    public String createProduct(@Valid @ModelAttribute("createForm") CreateProductForm createForm, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("createForm", createForm);
            model.addAttribute("categories", categoryService.getAll());
            return "create";
        }
        Product product = new Product(createForm.getName(), createForm.getPrice(), categoryService.getById(createForm.getCategoryId()));

        productService.add(product);
        model.addAttribute("createForm", createForm);
        model.addAttribute("categories", categoryService.getAll());
        model.addAttribute("message", "Created");
        return "create";
    }

    @GetMapping("/edit/{id}")
    public String editForm(Model model, @PathVariable int id) {
        Product product = productService.findById(id);
        CreateProductForm createForm = new CreateProductForm
                (product.getId(), product.getName(), product.getPrice(), product.getCategory().getId());
        model.addAttribute("createForm", createForm);
        model.addAttribute("categories", categoryService.getAll());
        return "edit";
    }

    @PostMapping("/edit")
    public String editProduct(@Valid @ModelAttribute("createForm") CreateProductForm createForm, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("createForm", createForm);
            model.addAttribute("categories", categoryService.getAll());
            return "edit";
        }
        Product product = productService.findById(createForm.getId());
        product.setName(createForm.getName());
        product.setPrice(createForm.getPrice());
        Category category = new Category();
        product.setCategory(categoryService.getById(createForm.getCategoryId()));
        model.addAttribute("message", "Edited");
        model.addAttribute("createForm", createForm);
        model.addAttribute("categories", categoryService.getAll());
        return "edit";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(Model model, @PathVariable int id) {
        productService.deleteProduct(id);
        showProducts(model);
        return "redirect:/product";
    }
}
