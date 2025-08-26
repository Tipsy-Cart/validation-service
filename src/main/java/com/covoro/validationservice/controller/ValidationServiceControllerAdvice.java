package com.covoro.validationservice.controller;

import com.covoro.validationservice.bean.ApiResponse;
import com.covoro.validationservice.bean.Error;
import com.covoro.validationservice.constant.AppConstant;
import com.covoro.validationservice.constant.ValidationServiceError;
import com.covoro.validationservice.exception.ValidationServiceException;
import com.covoro.validationservice.logging.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ValidationServiceControllerAdvice {

    private final Logger logger;

    public ValidationServiceControllerAdvice(Logger logger) {
        this.logger = logger;
    }

    @ExceptionHandler(value = {ValidationServiceException.class})
    public ResponseEntity<ApiResponse> handleAuthenticationServiceException(ValidationServiceException ex) {
        logger.error(ex.getMessage(), ex);
        return ResponseEntity.status(ex.getHttpStatusCode()).body(new ApiResponse().setStatus(AppConstant.STATUS_FAILED).setError(ex.getError()));
    }

    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<ApiResponse> handleException(Exception ex) {
        logger.error("Exception : " + ex.getMessage());
        logger.trace("Exception : ", ex);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponse().setStatus(AppConstant.STATUS_FAILED).setError(new Error().setCode(ValidationServiceError.VALIDATION_SERVICE_EXCEPTION.getCode()).setMessage(ValidationServiceError.VALIDATION_SERVICE_EXCEPTION.getMessage()).setDetail(ex.getMessage())));
    }
}
