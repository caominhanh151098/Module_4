package com.example.billmanagement.repository;

import com.example.billmanagement.model.ProductImport;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductImportRepository extends JpaRepository<ProductImport, Integer> {
    List<ProductImport> findAll();
    Page<ProductImport> findByImportCodeContainingOrCustomer_NameContaining(String importCode, String customer_name, Pageable pageable);
}
