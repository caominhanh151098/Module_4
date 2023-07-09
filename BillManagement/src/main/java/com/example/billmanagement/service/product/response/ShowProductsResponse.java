package com.example.billmanagement.service.product.response;

import com.example.billmanagement.service.SelectOptionRequest;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class ShowProductsResponse {
    private String id;
    private String nameProduct;
    private String quantity;
    private String price;
    private String category;

    public ShowProductsResponse() {
    }

    public ShowProductsResponse(String id, String nameProduct, String quantity, String price, String category) {
        this.id = id;
        this.nameProduct = nameProduct;
        this.quantity = quantity;
        this.price = price;
        this.category = category;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

}
