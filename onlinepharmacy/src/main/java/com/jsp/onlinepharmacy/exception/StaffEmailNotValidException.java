package com.jsp.onlinepharmacy.exception;

public class StaffEmailNotValidException extends RuntimeException {

	
	private String message;
	
	public StaffEmailNotValidException(String message) {
		super();
		this.message=message;
	}
}
