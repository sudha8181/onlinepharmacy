package com.jsp.onlinepharmacy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.onlinepharmacy.dto.Staff;
import com.jsp.onlinepharmacy.service.StaffService;
import com.jsp.onlinepharmacy.util.ResponseStructure;

@RestController
@RequestMapping("/staff")
public class StaffController {

	@Autowired
	private StaffService service;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<Staff>> signupStaff(@RequestParam  int adminId,@RequestParam int storeId,
			@RequestBody Staff staff){
		return service.signupStaff(adminId,storeId,staff);
	}
	
	
	@GetMapping
	public ResponseEntity<ResponseStructure<Staff>> loginStaff(@RequestParam String email,@RequestParam String password){
		return service.loginStaff(email,password);
	}
	
	@PutMapping
	public ResponseEntity<ResponseStructure<Staff>> reset(@RequestParam String email,@RequestParam String newPassword,@RequestParam long phone){
		return service.reset(email,newPassword,phone);
	}
	
	@PutMapping("/{staffId}")
	public ResponseEntity<ResponseStructure<Staff>> updateStaff(@PathVariable int staffId,@RequestBody Staff staff){
		return service.updateStaff(staffId,staff);
	}
	
	@GetMapping("/{staffId}")
	public ResponseEntity<ResponseStructure<Staff>> findStaff(@PathVariable int staffId){
		return service.findStaff(staffId);
	}
	
	@DeleteMapping
	public ResponseEntity<ResponseStructure<Staff>> deleteStaff(@RequestParam int staffId){
		return service.deleteStaff(staffId);
	}
	
	
}
