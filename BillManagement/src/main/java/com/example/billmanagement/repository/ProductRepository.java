package com.example.billmanagement.repository;

import com.example.billmanagement.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    Page<Product> findAllByNameProductContainingOrCategory_NameContaining(String nameProduct, String category_name, Pageable pageable);
    @Query(value = "SELECT p FROM Product p WHERE " +
            "(p.nameProduct like :search OR " +
            "p.category.name LIKE :search) " +
            "AND p.price BETWEEN :min AND :max")
    Page<Product> findWithSearchAndFilter(String search, BigDecimal min, BigDecimal max, Pageable pageable);
    Product findAllById(int id);
    Product findAllByNameProduct(String nameProduct);
}
