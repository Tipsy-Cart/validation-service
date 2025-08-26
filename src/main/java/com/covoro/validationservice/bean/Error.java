package com.covoro.validationservice.bean;

import java.io.Serializable;

public class Error implements Serializable {

    private static final long serialVersionUID = 1L;
	private String code;
	private String message;
	private Object detail;

	public String getCode() {
		return code;
	}

	public Error setCode(String code) {
		this.code = code;
		return this;
	}

	public String getMessage() {
		return message;
	}

	public Error setMessage(String message) {
		this.message = message;
		return this;
	}

    public Object getDetail() {
        return detail;
    }

    public Error setDetail(Object detail) {
        this.detail = detail;
        return this;
    }

    @Override
	public String toString() {
        String error = code + " :: " + message;
        if(null != detail)
            error = error + " :: " + detail;
        return error;
	}

}
