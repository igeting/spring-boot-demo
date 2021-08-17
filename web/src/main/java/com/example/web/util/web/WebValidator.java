package com.example.web.util.web;

import com.example.web.entity.WebParam;
import lombok.extern.slf4j.Slf4j;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

@Slf4j
public class WebValidator<T> {

    public void valid(T t) {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<T>> validates = validator.validate(t);
        for (ConstraintViolation<T> v : validates) {
            log.error(v.getMessage());
        }
    }

    public static void valid(WebParam webParam) {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<WebParam>> validates = validator.validate(webParam);
        for (ConstraintViolation<WebParam> v : validates) {
            log.error(v.getMessage());
        }
    }
}
