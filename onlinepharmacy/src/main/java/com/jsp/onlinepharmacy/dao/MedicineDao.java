package com.jsp.onlinepharmacy.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.onlinepharmacy.dto.Medicines;
import com.jsp.onlinepharmacy.repository.MedicalStoreRepo;
import com.jsp.onlinepharmacy.repository.MedicinesRepo;

@Repository
public class MedicineDao {

	@Autowired
	private MedicinesRepo repo;
	
	
	
	public Medicines saveMedicines(Medicines medicines) {
	return repo.save(medicines);
		
	}
	
	public Medicines updateMedicine(int medicineId,Medicines medicines) {
		Optional<Medicines> optional=repo.findById(medicineId);
		if(optional.isPresent()) {
			
			medicines.setMedicineId(optional.get().getMedicineId());
			 return repo.save(medicines);
		}else {
			return null;
		}
		
	}
	
	public Medicines findMedicineById(int medicineId) {
		Optional<Medicines> optional=repo.findById(medicineId);
		if(optional.isPresent()) {
			 return optional.get();
		}else {
			return null;
		}
	}
	
	
	public Medicines deleteMedicineById(int medicineId) {
		Optional<Medicines> optional=repo.findById(medicineId);
		if(optional.isPresent()) {
			 repo.delete(optional.get());
			 return optional.get();
		}else {
			return null;
		}
	}
	
	public Medicines findMedicineByName(String medicineName) {
		Optional<Medicines> optional=repo.findMedicineByName(medicineName);
		if(optional.isPresent()) {
			 return optional.get();
		}else {
			return null;
		}
	}

}
