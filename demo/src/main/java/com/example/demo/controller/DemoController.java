package com.example.demo.controller;

import com.example.demo.model.Category;
import com.example.demo.model.Product;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.form.CreateProductForm;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/demo")
public class DemoController {
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ProductRepository productRepository;

    @GetMapping
    public String showProducts(@RequestParam(defaultValue = "") String search, @PageableDefault(size = 3) Pageable pageable, Model model) {
        model.addAttribute("products", productRepository.findByNameContainingOrCategory_NameContaining(search, search, pageable));
        return "index";
    }

    @GetMapping("/create")
    public String createForm(Model model) {
        CreateProductForm createProductForm = new CreateProductForm();
        model.addAttribute("createForm", createProductForm);
        model.addAttribute("categories", categoryRepository.findAll());
        return "create";
    }

    @PostMapping("create")
    public String createProduct(@Valid @ModelAttribute("createForm") CreateProductForm createProductForm, BindingResult result, Model model) {
        model.addAttribute("createForm", createProductForm);
        model.addAttribute("categories", categoryRepository.findAll());
        if (result.hasErrors())
            return "create";
        Category category = categoryRepository.findById(createProductForm.getCategoryId());
        Product product = new Product(createProductForm.getName(), createProductForm.getPrice(), category);
        productRepository.save(product);
        model.addAttribute("message", "Created");
        return "create";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable int id, Model model) {
        Product product = productRepository.findById(id);
        CreateProductForm createProductForm =
                new CreateProductForm(product.getId(), product.getName(), product.getPrice(), product.getCategory().getId());
        model.addAttribute("createForm", createProductForm);
        model.addAttribute("categories", categoryRepository.findAll());
        return "edit";
    }

    @PostMapping("/edit")
    public String editProduct(@Valid @ModelAttribute("createForm") CreateProductForm productForm, BindingResult result, Model model) {
        model.addAttribute("createForm", productForm);
        model.addAttribute("categories", categoryRepository.findAll());
        if (result.hasErrors())
            return "edit";
        Category category = categoryRepository.findById(productForm.getCategoryId());
        Product product = new Product(productForm.getId(), productForm.getName(), productForm.getPrice(), category);
        productRepository.save(product);
        model.addAttribute("message", "Edited");
        return "edit";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable int id, Model model) {
        productRepository.deleteById(id);
        return "redirect:/demo";
    }
}
