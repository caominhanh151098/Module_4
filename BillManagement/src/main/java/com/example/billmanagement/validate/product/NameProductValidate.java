package com.example.billmanagement.validate.product;

import com.example.billmanagement.repository.ProductRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

public class NameProductValidate implements ConstraintValidator<ValidateNameProduct, String> {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public void initialize(ValidateNameProduct constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if (s == null)
            return true;
        if (productRepository.findAllByNameProduct(s) != null)
            return false;
        return true;
    }
}
