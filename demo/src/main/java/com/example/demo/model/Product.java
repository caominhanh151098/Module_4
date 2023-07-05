package com.example.demo.model;

import com.example.demo.validate.ValidateCatagoryId;
import jakarta.persistence.*;


@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    public String name;
    public long price;
    @ManyToOne
    @JoinColumn(name = "category_id")
    public Category category;

    public Product() {
    }

    public Product(String name, long price, Category category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public Product(int id, String name, long price, Category category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
