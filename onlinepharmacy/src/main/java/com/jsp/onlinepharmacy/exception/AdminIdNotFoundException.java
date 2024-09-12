package com.jsp.onlinepharmacy.exception;

public class AdminIdNotFoundException extends RuntimeException {
private String message;
	
	public AdminIdNotFoundException(String message) {
		super();
		this.message=message;
	}
}
