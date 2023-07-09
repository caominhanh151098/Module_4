package com.example.billmanagement.service.product;

import com.example.billmanagement.model.Product;
import com.example.billmanagement.repository.CategoryRepository;
import com.example.billmanagement.repository.ProductRepository;
import com.example.billmanagement.service.product.request.ProductSaveRequest;
import com.example.billmanagement.service.product.response.CategorySaveProductResponse;
import com.example.billmanagement.service.product.response.ProductSaveResponse;
import com.example.billmanagement.service.product.response.ShowProductsResponse;
import com.example.billmanagement.util.AppUtils;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ProductRepository productRepository;

    public List<ShowProductsResponse> getAll() {
//        List<ShowProductsResponse> productList = new ArrayList<>();
//        for (Product product : productRepository.findAll()) {
//            ShowProductsResponse productResponse = AppUtils.mapper.map(product, ShowProductsResponse.class);
//            productResponse.setCategory(product.getCategory().getName());
//            productList.add(productResponse);
//
//        }
//        return productList;
        return productRepository.findAll().stream().map(e -> {
            var pImport = AppUtils.mapper.map(e, ShowProductsResponse.class);
            pImport.setCategory(e.getCategory().getName());
            return pImport;
        }).collect(Collectors.toList());
    }

    @Transactional
    public void createProduct(ProductSaveRequest productRequest) {
        Product product = AppUtils.mapper.map(productRequest, Product.class);
        productRepository.save(product);
    }

    public ProductSaveResponse getProductById(int id) {
        Product product = productRepository.findAllById(id);
        return AppUtils.mapper.map(product, ProductSaveResponse.class);
    }

    @Transactional
    public void editProduct(ProductSaveResponse newProduct) {
        Product product = AppUtils.mapper.map(newProduct, Product.class);
        productRepository.save(product);
    }

    public void deleteProduct(int id) {
        productRepository.deleteById(id);
    }

    public List<CategorySaveProductResponse> getAllCategory() {
        return categoryRepository.findAll()
                .stream().map(e -> AppUtils.mapper.map(e, CategorySaveProductResponse.class))
                .collect(Collectors.toList());
    }
}
