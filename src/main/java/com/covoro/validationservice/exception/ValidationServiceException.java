package com.covoro.validationservice.exception;

import com.covoro.validationservice.bean.Error;
import com.covoro.validationservice.constant.ValidationServiceError;
import org.springframework.http.HttpStatusCode;

public class ValidationServiceException extends RuntimeException {

    private final static long serialVersionUID = 5248635321125441155L;
    private final HttpStatusCode httpStatusCode;
    private final Error error;

    public ValidationServiceException(ValidationServiceError error, Object detail) {
        this.httpStatusCode = error.getHttpStatusCode();
        this.error = new Error().setCode(error.getCode()).setMessage(error.getMessage()).setDetail(detail);
    }

    public HttpStatusCode getHttpStatusCode() {
        return httpStatusCode;
    }

    public Error getError() {
        return error;
    }

    @Override
    public String getMessage() {
        return "HTTP " + this.httpStatusCode.toString() + " :: " + this.error;
    }

}
