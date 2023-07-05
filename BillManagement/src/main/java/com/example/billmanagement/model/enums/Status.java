package com.example.billmanagement.model.enums;

public enum Status {
    PAID(1),
    UNPAID(2);
    private int index;
    Status(int index) {
        this.index = index;
    }
}
