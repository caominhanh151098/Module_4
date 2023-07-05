package com.example.billmanagement.service.bill_detail.request;

import com.example.billmanagement.service.SelectOptionRequest;
import jakarta.validation.constraints.Min;

public class BillDetailSaveRequest {
    private SelectOptionRequest product;
    private String price;
    @Min(0)
    private String quantity;

    public BillDetailSaveRequest() {
        product = new SelectOptionRequest();
    }

    public BillDetailSaveRequest(SelectOptionRequest product) {
        this.product = product;
    }

    public SelectOptionRequest getProduct() {
        return product;
    }

    public void setProduct(SelectOptionRequest product) {
        this.product = product;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
}
