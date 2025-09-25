package com.covoro.validationservice.constant;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

public enum ValidationServiceError {
    VALIDATION_ERROR(HttpStatus.BAD_REQUEST, "VS-400", "Validation Failed"),
    SQL_EXCEPTION(HttpStatus.INTERNAL_SERVER_ERROR, "VS-100", "Database Error"),
    VALIDATION_SERVICE_EXCEPTION(HttpStatus.INTERNAL_SERVER_ERROR, "VS-500", "Validation Service Exception");

    final HttpStatusCode httpStatusCode;
    final String code;
    final String message;

    ValidationServiceError(HttpStatusCode httpStatusCode, String code, String message) {
        this.httpStatusCode = httpStatusCode;
        this.code = code;
        this.message = message;
    }

    public HttpStatusCode getHttpStatusCode() {
        return httpStatusCode;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

}
