package com.example.demo.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Constraint(validatedBy = NameLengthValidator.class)
@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface NameLength {
    String message() default "아이디는 2자 이상이어야 합니다.";
    Class<?>[] groups() default {};  //Validation 그룹 지정 실무에서는 주로 기본 그룹만 쓰기 때문에 {}로 비워둠
    Class<? extends Payload>[] payload() default {}; //추가 메타데이터를 담을 수 있는 용도 보통 거의 사용하지 않음
}