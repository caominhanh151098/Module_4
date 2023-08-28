package com.example.billmanagement.service.category;

import com.example.billmanagement.repository.CategoryRepository;
import com.example.billmanagement.service.customer.response.CategorySaveResponse;
import com.example.billmanagement.util.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public List<CategorySaveResponse> getAll() {
        return categoryRepository.findAll()
                .stream()
                .map(e -> AppUtils.mapper.map(e, CategorySaveResponse.class))
                .collect(Collectors.toList());
    }
}
