package com.example.billmanagement.model.enums;

public enum Color {
    RED(1),
    BLUE(2),
    YELLOW(3),
    BLACK(4);

    private int index;

    Color(int index) {
        this.index = index;
    }
}
