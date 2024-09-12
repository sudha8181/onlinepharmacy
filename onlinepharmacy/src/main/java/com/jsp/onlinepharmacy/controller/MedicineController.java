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

import com.jsp.onlinepharmacy.dto.Medicines;
import com.jsp.onlinepharmacy.service.MedicineService;
import com.jsp.onlinepharmacy.util.ResponseStructure;

@RestController
@RequestMapping("/medicine")
public class MedicineController {

	@Autowired
	private MedicineService service;
	
	
	@PostMapping
	public ResponseEntity<ResponseStructure<Medicines>> addMedicine(@RequestParam int storeId,@RequestBody Medicines medicines) {
			return service.addMedicine(storeId,medicines);
	}
	
	@PutMapping
	public ResponseEntity<ResponseStructure<Medicines>> updateMedicine(@RequestParam int medicineId,@RequestBody
			Medicines medicines) {
			return service.updateMedicine(medicineId,medicines);
	}
	
	@DeleteMapping
	public ResponseEntity<ResponseStructure<Medicines>>  deleteMedicine(@RequestParam int medicineId) {
			return service.deleteMedicine(medicineId);
	}
	
	@GetMapping
	public ResponseEntity<ResponseStructure<Medicines>> findMedicine(@RequestParam int medicineId) {
			return service.findMedicine(medicineId);
	}
	
	@GetMapping("/{medicineName}")
	public ResponseEntity<ResponseStructure<Medicines>> findMedicinesByName(@PathVariable String medicineName) {
			return service.findMedicinesByName(medicineName);
	}
}
