package com.example.billmanagement.model;

import com.example.billmanagement.model.enums.Color;
import com.example.billmanagement.model.enums.Size;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
public class ProductImportDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Color color;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Size size;
    @Column(nullable = false)
    private int quantity;
    @Column(nullable = false)
    private int sellNum;
    @ManyToOne
    @JoinColumn(name = "product_import_id",referencedColumnName = "id")
    @JsonIgnore
    public ProductImport productImport;

    public ProductImportDetail() {
    }

    public ProductImportDetail(int id, Product product, Color color, Size size, int quantity, int sellNum) {
        this.id = id;
        this.product = product;
        this.color = color;
        this.size = size;
        this.quantity = quantity;
        this.sellNum = sellNum;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getSellNum() {
        return sellNum;
    }

    public void setSellNum(int sellNum) {
        this.sellNum = sellNum;
    }

    public ProductImport getProductImport() {
        return productImport;
    }

    public void setProductImport(ProductImport productImport) {
        this.productImport = productImport;
    }
}
