package com.jsp.onlinepharmacy.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jsp.onlinepharmacy.dto.Staff;

public interface StaffRepo extends JpaRepository<Staff, Integer>{
   
	@Query("select s from Staff s where s.staffEmail=?1")
	public Optional<Staff> findByEmail(String email);
}
