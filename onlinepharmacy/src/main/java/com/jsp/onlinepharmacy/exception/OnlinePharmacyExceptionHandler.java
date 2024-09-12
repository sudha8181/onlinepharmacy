package com.jsp.onlinepharmacy.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.jsp.onlinepharmacy.util.ResponseStructure;

@RestControllerAdvice
public class OnlinePharmacyExceptionHandler<StaffPasswordNotValidException> extends ResponseEntityExceptionHandler {
	
	ResponseStructure<String> rs=new ResponseStructure<>();
	
	@ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> handleAdminPasswordNotValidException(AdminPasswordNotValidException exception){
		rs.setMessage("Invalid Admin Password !!!");
		rs.setHttpstatus(HttpStatus.NOT_FOUND.value());
		rs.setData(exception.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(rs,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> handleAddressIdNotFoundException(AddressIdNotFoundException exception){
		rs.setMessage("Address Not Found !!!");
		rs.setHttpstatus(HttpStatus.NOT_FOUND.value());
		rs.setData(exception.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(rs,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> handleAddressNotUpdateException(AddressNotUpdateException exception){
		rs.setMessage("Address Not Found !!!");
		rs.setHttpstatus(HttpStatus.NOT_FOUND.value());
		rs.setData(exception.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(rs,HttpStatus.NOT_FOUND);
	}
	

	@ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> handleAdminEmailNotValidException(AdminEmailNotValidException exception){
		rs.setMessage("Invalid Admin Email !!!");
		rs.setHttpstatus(HttpStatus.NOT_FOUND.value());
		rs.setData(exception.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(rs,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> handleAdminIdNotFoundException(AdminIdNotFoundException exception){
		rs.setMessage("sorry Admin id is not found !!!");
		rs.setHttpstatus(HttpStatus.NOT_FOUND.value());
		rs.setData(exception.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(rs,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> handleCustomerIdNotFoundException(CustomerIdNotFoundException exception){
		rs.setMessage("sorry customer id is not found !!!");
		rs.setHttpstatus(HttpStatus.NOT_FOUND.value());
		rs.setData(exception.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(rs,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> handleBookingCantCancelledException(BookingCantCancelledException exception){
		rs.setMessage("sorry bookig cant cancel!!!");
		rs.setHttpstatus(HttpStatus.NOT_FOUND.value());
		rs.setData(exception.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(rs,HttpStatus.NOT_FOUND);
	}
	
	

	@ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> handleAdminPhoneNotValidException(AdminPhoneNotValidException exception){
		rs.setMessage("	Invalid Phone Number !!!");
		rs.setHttpstatus(HttpStatus.NOT_FOUND.value());
		rs.setData(exception.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(rs,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> handleStaffIdNotFoundException(StaffIdNotFoundException exception){
		rs.setMessage("Sorry staff id is not found");
		rs.setHttpstatus(HttpStatus.NOT_FOUND.value());
		rs.setMessage(exception.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(rs,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> handleStaffPasswordNotValidException(StaffPasswordNotInvalidException exception){
		rs.setMessage("Invalid staff Password");
		rs.setHttpstatus(HttpStatus.NOT_FOUND.value());
		rs.setData(exception.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(rs,HttpStatus.NOT_FOUND);
	}
	

	@ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> handleStaffEmailNotValidException(StaffEmailNotValidException exception){
		rs.setMessage("Invalid staff email");
		rs.setHttpstatus(HttpStatus.NOT_FOUND.value());
		rs.setData(exception.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(rs,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> handleMedicalStoreIdNotFoundException(MedicalStoreIdNotFoundException exception){
		rs.setMessage("Invalid Store Id");
		rs.setHttpstatus(HttpStatus.NOT_FOUND.value());
		rs.setData(exception.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(rs,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> handleMedicineIdNotFoundException(MedicineIdNotFoundException exception){
		rs.setMessage("Sorry Medicine id is not found");
		rs.setHttpstatus(HttpStatus.NOT_FOUND.value());
		rs.setData(exception.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(rs,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> handleMedicineNameNotFoundException(MedicineNameNotFoundException exception){
		rs.setMessage("Sorry Medicine name is not found");
		rs.setHttpstatus(HttpStatus.NOT_FOUND.value());
		rs.setData(exception.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(rs,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> handleBookingIdNotFoundException(bookingIdNotFoundException exception){
		rs.setMessage("Sorry BOOKING id  is  not found");
		rs.setHttpstatus(HttpStatus.NOT_FOUND.value());
		rs.setData(exception.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(rs,HttpStatus.NOT_FOUND);
	}
	
}
