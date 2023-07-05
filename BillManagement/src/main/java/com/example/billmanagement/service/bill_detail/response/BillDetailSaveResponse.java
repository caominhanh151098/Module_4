package com.example.billmanagement.service.bill_detail.response;

import com.example.billmanagement.service.SelectOptionRequest;
import jakarta.validation.constraints.Min;

public class BillDetailSaveResponse {
    private SelectOptionRequest product;
    private String price;
    @Min(0)
    private String quantity;

    public BillDetailSaveResponse() {
        product = new SelectOptionRequest();
    }

    public BillDetailSaveResponse(SelectOptionRequest product) {
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
