package com.example.billmanagement.service.product.request;

import com.example.billmanagement.service.SelectOptionRequest;
import com.example.billmanagement.validate.product.ValidateNameProduct;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class ProductSaveRequest {
    private String id;
    @NotBlank(message = "Không được để trống!")
    @ValidateNameProduct
    private String nameProduct;
    @NotBlank(message = "Không được để trống!")
    @Pattern(regexp = "\\d+", message = "Lỗi nhập số!")
    private String quantity;
    @NotBlank(message = "Không được để trống!")
    @Pattern(regexp = "\\d+", message = "Lỗi nhập số!")
    private String price;
    private SelectOptionRequest category;

    public ProductSaveRequest() {
        category = new SelectOptionRequest();
    }

    public ProductSaveRequest(SelectOptionRequest category) {
        this.category = category;
    }

    public ProductSaveRequest(String id, String nameProduct, String quantity, String price, SelectOptionRequest category) {
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

    public SelectOptionRequest getCategory() {
        return category;
    }

    public void setCategory(SelectOptionRequest category) {
        this.category = category;
    }
}
