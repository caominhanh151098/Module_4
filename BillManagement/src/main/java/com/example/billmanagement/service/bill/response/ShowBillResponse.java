package com.example.billmanagement.service.bill.response;

public class ShowBillResponse {
    private String name;
    private String dateBought;
    private String totalPrice;
    private String nameProduct;

    public ShowBillResponse() {
    }

    public ShowBillResponse(String name, String dateBought, String totalPrice, String nameProduct) {
        this.name = name;
        this.dateBought = dateBought;
        this.totalPrice = totalPrice;
        this.nameProduct = nameProduct;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateBought() {
        return dateBought;
    }

    public void setDateBought(String dateBought) {
        this.dateBought = dateBought;
    }

    public String getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(String totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }
}
