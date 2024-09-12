package com.jsp.onlinepharmacy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.onlinepharmacy.dto.MedicalStore;
import com.jsp.onlinepharmacy.service.MedicalStoreService;
import com.jsp.onlinepharmacy.util.ResponseStructure;

@RestController
@RequestMapping("/store")
public class MedicalStoreController {
	
	
	@Autowired
	private MedicalStoreService service;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<MedicalStore>> establishMedicalStore(@RequestParam int adminid,@RequestParam int addressid,@RequestBody MedicalStore medicalstore){
		return  service.establishMedicalStore(adminid,addressid,medicalstore);
	}
	
   @PutMapping
	public ResponseEntity<ResponseStructure<MedicalStore>> updateMedicalStore(@RequestParam int storeid,@RequestBody MedicalStore medicalstore){
		return  service.updateMedicalStore(storeid,medicalstore);
	}
	
	@GetMapping
	public ResponseEntity<ResponseStructure<MedicalStore>>   findMedicalStore(@RequestParam int storeid){
		return  service.findMedicalStore(storeid);
	}
	
	@DeleteMapping
	public ResponseEntity<ResponseStructure<MedicalStore>> deleteMedicalStore(@RequestParam int storeid){
		return  service.deleteMedicalStore(storeid);
	}
	

}
