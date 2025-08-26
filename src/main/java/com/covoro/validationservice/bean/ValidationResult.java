package com.covoro.validationservice.bean;

import java.util.ArrayList;
import java.util.List;

public class ValidationResult {

    private final List<ValidationError> errors = new ArrayList<>();

    public void add(String field, String message) {
        errors.add(new ValidationError().setField(field).setMessage(message));
    }

    public List<ValidationError> get() {
        return errors;
    }

}
