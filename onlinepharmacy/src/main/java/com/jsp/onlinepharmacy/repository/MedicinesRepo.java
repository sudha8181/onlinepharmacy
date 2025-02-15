package com.jsp.onlinepharmacy.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jsp.onlinepharmacy.dto.Medicines;

public interface MedicinesRepo extends JpaRepository<Medicines, Integer>{

	@Query("select m from Medicines m where m.medicineName=?1")
	public Optional<Medicines> findMedicineByName(String medicineName);
}
