package com.example.billmanagement.service.product_import_detail.request;

import com.example.billmanagement.model.Product;
import com.example.billmanagement.model.ProductImport;
import com.example.billmanagement.model.enums.Color;
import com.example.billmanagement.model.enums.Size;
import com.example.billmanagement.service.SelectOptionRequest;
import jakarta.persistence.*;

import java.math.BigDecimal;

public class ProductImportDetailRequest {
    private String id;
    private SelectOptionRequest product;
    private String color;
    private String size;
    private String quantity;
    private String sellNum;

    public ProductImportDetailRequest() {
        product = new SelectOptionRequest();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public SelectOptionRequest getProduct() {
        return product;
    }

    public void setProduct(SelectOptionRequest product) {
        this.product = product;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getSellNum() {
        return sellNum;
    }

    public void setSellNum(String sellNum) {
        this.sellNum = sellNum;
    }

    public static class ProductSaveRequest {
        private String id;
        private String nameProduct;
        private String quantity;
        private String price;

        public ProductSaveRequest() {
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
    }
}
