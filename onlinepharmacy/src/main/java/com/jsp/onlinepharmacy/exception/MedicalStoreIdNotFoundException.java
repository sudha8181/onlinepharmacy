package com.jsp.onlinepharmacy.exception;

public class MedicalStoreIdNotFoundException extends RuntimeException {
	
	private String message;
	
	public MedicalStoreIdNotFoundException(String message) {
		super();
		this.message=message;
	}

}
