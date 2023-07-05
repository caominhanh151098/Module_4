package com.example.demo.validate;

import com.example.demo.model.Category;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.service.CategoryService;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CategoryValidate implements ConstraintValidator<ValidateCatagoryId, Integer> {
    @Autowired
//    private CategoryService categoryService;
    private CategoryRepository categoryRepository;

    @Override
    public void initialize(ValidateCatagoryId constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Integer id, ConstraintValidatorContext constraintValidatorContext) {
        if (id == null)
            return true;
        if (categoryRepository.findById(id).orElse(null) != null)
            return true;
        return false;
    }
}
