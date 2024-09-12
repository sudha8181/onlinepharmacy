package com.jsp.onlinepharmacy.exception;

public class AdminPhoneNotValidException extends RuntimeException {
private String message;
	
	public AdminPhoneNotValidException(String message) {
		super();
		this.message=message;
	}
}
