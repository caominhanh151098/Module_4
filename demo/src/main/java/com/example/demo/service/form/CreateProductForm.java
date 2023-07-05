package com.example.demo.service.form;

import com.example.demo.model.Category;
import com.example.demo.validate.ValidateCatagoryId;
import jakarta.validation.constraints.*;
import org.springframework.format.annotation.NumberFormat;

public class CreateProductForm {
    @Min(0)
    private int id;
    @NotBlank(message = "Lỗi Tên sản phẩm!")
    private String name;
    @Min(value = 0, message = "Số lượng không bé hơn 0")
    private long price;

    @NotNull(message = "Chưa chọn Category")
    @ValidateCatagoryId
    private int categoryId;

    public CreateProductForm() {
    }

    public CreateProductForm(int id, String name, long price, int categoryId) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.categoryId = categoryId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }
}
