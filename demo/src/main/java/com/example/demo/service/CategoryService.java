package com.example.demo.service;

import com.example.demo.model.Category;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CategoryService {
    private static List<Category> categoryList = new ArrayList<>();
    static {
        categoryList.add(new Category(1, "Giày"));
        categoryList.add(new Category(2, "Dép"));
        categoryList.add(new Category(3, "Dép tổ ong"));
    }

    public List<Category> getAll () {
        return categoryList;
    }

    public Category getById(int id) {
        return categoryList.stream().filter(e -> e.getId() == id).findFirst().orElse(null);
    }
}
