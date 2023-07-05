package com.example.demo.service;

import com.example.demo.model.Category;
import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    private static List<Product> products;
    private static int curretId;

    static {
        products = new ArrayList<>();
        products.add(new Product(++curretId, "File", 200, new Category(1, "Giày")));
        products.add(new Product(++curretId, "Profile", 500, new Category(2, "Dép")));
        products.add(new Product(++curretId, "SUPERFile", 1000, new Category(3, "Dép tổ ong")));
        products.add(new Product(++curretId, "Limit File", 700, new Category(3, "Dép tổ ong")));
    }

    public List<Product> getProducts() {
        return products;
    }

    public void add(Product product) {
        product.setId(++curretId);
        products.add(product);
    }

    public Product findById(int id) {
        return products.stream().filter(e -> e.getId() == id).findFirst().orElse(null);
    }

    public void deleteProduct(int id) {
        products = products.stream().filter(e -> e.getId() != id).collect(Collectors.toList());
    }

//    public Page<Product> getProducts(Pageable pageable) {
//        return productRepository.findByNameContainingOrCategory_NameContaining(pageable);
//    }
}
