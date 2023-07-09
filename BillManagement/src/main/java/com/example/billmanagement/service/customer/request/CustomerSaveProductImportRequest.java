package com.example.billmanagement.service.customer.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class CustomerSaveProductImportRequest {
    private String id;
    @NotBlank(message = "Không được để trống!")
    private String name;
    @NotBlank(message = "Không được để trống!")
    @Pattern(regexp = "\\d{10}",message = "SĐT không hợp lệ!")
    public String phone;
    @NotBlank(message = "Không được để trống!")
    @Email(message = "Email sai định dạng!")
    public String email;
    @NotBlank(message = "Không được để trống!")
    public String address;

    public CustomerSaveProductImportRequest() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
