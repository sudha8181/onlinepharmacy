package com.jsp.onlinepharmacy.exception;

public class StaffIdNotFoundException extends RuntimeException {
	
	private String message;
	
	public StaffIdNotFoundException(String message) {
        super();
		this.message=message;
	}

}
