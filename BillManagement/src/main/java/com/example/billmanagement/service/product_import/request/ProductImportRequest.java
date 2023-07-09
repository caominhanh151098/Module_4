package com.example.billmanagement.service.product_import.request;

import com.example.billmanagement.model.Customer;
import com.example.billmanagement.model.ProductImportDetail;
import com.example.billmanagement.service.customer.request.CustomerSaveProductImportRequest;
import com.example.billmanagement.service.customer.request.CustomerSaveRequest;
import com.example.billmanagement.service.product_import_detail.request.ProductImportDetailRequest;
import jakarta.persistence.*;
import jakarta.validation.Valid;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public class ProductImportRequest {
    private String id;
    private @Valid CustomerSaveProductImportRequest customer;
    private String importDay;
    private String importCode;
    private List<@Valid ProductImportDetailRequest> productImportDetails;

    public ProductImportRequest() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public CustomerSaveProductImportRequest getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerSaveProductImportRequest customer) {
        this.customer = customer;
    }

    public String getImportDay() {
        return importDay;
    }

    public void setImportDay(String importDay) {
        this.importDay = importDay;
    }

    public String getImportCode() {
        return importCode;
    }

    public void setImportCode(String importCode) {
        this.importCode = importCode;
    }

    public List<ProductImportDetailRequest> getProductImportDetails() {
        return productImportDetails;
    }

    public void setProductImportDetails(List<ProductImportDetailRequest> productImportDetails) {
        this.productImportDetails = productImportDetails;
    }
}
