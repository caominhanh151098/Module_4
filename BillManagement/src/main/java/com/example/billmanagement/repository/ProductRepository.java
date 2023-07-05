package com.example.billmanagement.repository;

import com.example.billmanagement.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    public Product findAllById(int id);
    public Product findAllByNameProduct(String nameProduct);
}
