package com.example.services;

public class ServiceResponse<T> {

	private String status;
	private T object;

	public ServiceResponse(String status, T object) {
		super();
		this.status = status;
		this.object = object;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public T getObject() {
		return object;
	}

	public void setObject(T object) {
		this.object = object;
	}

}
