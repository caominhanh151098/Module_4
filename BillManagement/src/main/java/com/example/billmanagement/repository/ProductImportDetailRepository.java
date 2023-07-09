package com.example.billmanagement.repository;

import com.example.billmanagement.model.ProductImportDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductImportDetailRepository extends JpaRepository<ProductImportDetail, Integer> {
    List<ProductImportDetail> findProductImportDetailByProductImport_Id(int productImport_id);
}
