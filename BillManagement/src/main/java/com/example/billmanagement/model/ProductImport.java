package com.example.billmanagement.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Set;

@Entity
public class ProductImport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
    @Column(nullable = false)
    private LocalDate importDay;
    @Column(nullable = false)
    private String importCode;
    @OneToMany(mappedBy = "productImport",cascade = CascadeType.ALL)
    private Set<ProductImportDetail> productImportDetails;

    public ProductImport() {
    }

    public ProductImport(int id, Customer customer, LocalDate importDay, String importCode) {
        this.id = id;
        this.customer = customer;
        this.importDay = importDay;
        this.importCode = importCode;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public LocalDate getImportDay() {
        return importDay;
    }

    public void setImportDay(LocalDate importDay) {
        this.importDay = importDay;
    }

    public String getImportCode() {
        return importCode;
    }

    public void setImportCode(String importCode) {
        this.importCode = importCode;
    }

    public Set<ProductImportDetail> getProductImportDetails() {
        return productImportDetails;
    }

    public void setProductImportDetails(Set<ProductImportDetail> productImportDetails) {
        this.productImportDetails = productImportDetails;
    }
}
