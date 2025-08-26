package com.covoro.validationservice.bean;


public class ApiResponse {
	
	private String status;
	private Object payload;
	private Error error;

	public String getStatus() {
		return status;
	}

	public ApiResponse setStatus(String status) {
		this.status = status;
		return this;
	}

    public Object getPayload() {
        return payload;
    }

    public ApiResponse setPayload(Object payload) {
        this.payload = payload;
        return this;
    }

    public Error getError() {
        return error;
    }

    public ApiResponse setError(Error error) {
        this.error = error;
        return this;
    }

}
