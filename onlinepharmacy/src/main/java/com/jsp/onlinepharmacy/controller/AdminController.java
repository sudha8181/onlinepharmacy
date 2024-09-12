package com.jsp.onlinepharmacy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.onlinepharmacy.dto.Admin;
import com.jsp.onlinepharmacy.service.AdminService;
import com.jsp.onlinepharmacy.util.ResponseStructure;

@RestController
public class AdminController {
	
	@Autowired
	private AdminService service;
	
	
	@PostMapping("/signup")
	public ResponseEntity<ResponseStructure<Admin>> signupAdmin(@RequestBody Admin admin){
		return service.signupAdmin(admin);
	}
	
	@GetMapping("/login")
	public ResponseEntity<ResponseStructure<Admin>> LoginAdmin(@RequestParam String email,@RequestParam String password){
		return service.loginAdmin(email,password);
	}
	
	@GetMapping("/alladmin")
	public ResponseEntity<ResponseStructure<List<Admin>>> allAdmin(){
		return service.allAdmin();
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<ResponseStructure<Admin>> updateAdmin(@PathVariable int id,@RequestBody Admin admin){
		return service.updateAdmin(id,admin);
	}
	
	@GetMapping("/login/{id}")
	public ResponseEntity<ResponseStructure<Admin>> findAdminById(@PathVariable int id){
		
		return service.findAdminById(id);
	}
	
	@PutMapping("/reset")
    public ResponseEntity<ResponseStructure<Admin>> resetpassword(@RequestParam String email,@RequestParam String newpass,@RequestParam  long phoneno){
		
		return service.resetpassword(email,newpass,phoneno);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<ResponseStructure<Admin>> deleteAdminById(@PathVariable int id){
		return service.deleteAdminById(id);
	}
	
	
	

}
