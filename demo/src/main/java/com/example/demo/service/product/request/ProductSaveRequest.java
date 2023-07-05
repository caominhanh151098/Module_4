package com.example.demo.service.product.request;

import com.example.demo.validate.ValidateCatagoryId;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ProductSaveRequest {
    @NotNull
    @Min(0)
    private String id;
    @NotBlank(message = "Lỗi Tên sản phẩm!")
    private String name;
    @Min(value = 0, message = "Số lượng không bé hơn 0")
    private String price;
    @NotNull(message = "Chưa chọn Category")
    @ValidateCatagoryId
    private String categoryId;

    public ProductSaveRequest() {
    }

    public ProductSaveRequest(String id, String name, String price, String categoryId) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.categoryId = categoryId;
    }
}
