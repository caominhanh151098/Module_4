package com.example.billmanagement.service;

public class SelectOptionRequest {
    private String id;

    public SelectOptionRequest() {
    }

    public SelectOptionRequest(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
