package com.example.demo.validate;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = CategoryValidate.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)

public @interface ValidateCatagoryId {
    String message() default "Không thấy Category";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
