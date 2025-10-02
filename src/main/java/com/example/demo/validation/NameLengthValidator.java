package com.example.demo.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class NameLengthValidator implements ConstraintValidator<NameLength, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) return false;
        int length = value.codePointCount(0, value.length());  //문자 단위 길이
        System.out.println(length);
        return length >= 2;
    }
}