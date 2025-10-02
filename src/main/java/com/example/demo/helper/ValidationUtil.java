package com.example.demo.helper;

import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.validation.BindingResult;

public class ValidationUtil {
    public static Map<String, String> extractErrors(BindingResult bindingResult) {
        return bindingResult.getFieldErrors().stream()
                .collect(Collectors.toMap(
                        e -> e.getField(),
                        e -> e.getDefaultMessage()
                ));
    }
}
