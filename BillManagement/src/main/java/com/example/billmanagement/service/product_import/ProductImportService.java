package com.example.billmanagement.service.product_import;

import com.example.billmanagement.model.Product;
import com.example.billmanagement.model.ProductImport;
import com.example.billmanagement.model.ProductImportDetail;
import com.example.billmanagement.repository.CustomerRepository;
import com.example.billmanagement.repository.ProductImportDetailRepository;
import com.example.billmanagement.repository.ProductImportRepository;
import com.example.billmanagement.repository.ProductRepository;
import com.example.billmanagement.service.product_import.request.ProductImportRequest;
import com.example.billmanagement.util.AppUtils;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductImportService {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private ProductImportRepository productImportRepository;
    @Autowired
    private ProductImportDetailRepository productImportDetailRepository;
    @Autowired
    private ProductRepository productRepository;

    public Page<ProductImportRequest> getAll(String search, Pageable pageable) {
        Page<ProductImportRequest> productImportRequests = productImportRepository
                .findByImportCodeContainingOrCustomer_NameContaining(search, search, pageable)
                .map(e -> AppUtils.mapper.map(e, ProductImportRequest.class));
        return productImportRequests;
    }

    @Transactional
    public void saveProductImport(ProductImportRequest p_import) {
        ProductImport productImport = AppUtils.mapper.map(p_import, ProductImport.class);
        for (ProductImportDetail productImportDetail : productImport.getProductImportDetails()) {
            Product product = productRepository.findAllById(productImportDetail.getProduct().getId());
            productImportDetail.setProduct(product);
            productImportDetail.setProductImport(productImport);
        }
        productImportDetailRepository.deleteAll(productImportDetailRepository.findProductImportDetailByProductImport_Id(productImport.getId()));
        customerRepository.save(productImport.getCustomer());
        productImportRepository.save(productImport);
    }

    public void deleteProductImport(int id) {
        productImportRepository.deleteById(id);
    }
}
