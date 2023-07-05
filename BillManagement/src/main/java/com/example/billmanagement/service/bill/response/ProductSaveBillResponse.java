package com.example.billmanagement.service.bill.response;

import java.math.BigDecimal;

public class ProductSaveBillResponse {
    private Long id;

    private String name;

    private BigDecimal price;

    public ProductSaveBillResponse() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameProduct() {
        return name;
    }

    public void setNameProduct(String nameProduct) {
        this.name = nameProduct;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
