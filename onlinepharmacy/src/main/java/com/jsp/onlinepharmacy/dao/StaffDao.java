package com.jsp.onlinepharmacy.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.onlinepharmacy.dto.Staff;
import com.jsp.onlinepharmacy.repository.StaffRepo;

@Repository
public class StaffDao {
	
	@Autowired
	private StaffRepo repo;

	public Staff saveStaff(Staff staff) {
		return repo.save(staff);	
	}

	public Staff findStaffById(int staffId) {
		
		Optional<Staff> optional=repo.findById(staffId);
		if(optional.isPresent()) {
			return optional.get();
		}else {
			return null;
		}	
		
	}
	
	
	public Staff updateStaff(int id,Staff staff) {
		Optional<Staff> staffdb=repo.findById(id);
		if(staffdb.isPresent()) {
			staff.setStaffId(id);
			staff.setAdmin(staffdb.get().getAdmin());
			staff.setMedicalStore(staffdb.get().getMedicalStore());
			return repo.save(staff);
		}else {
			return null;
		}
	}
	
	
	public Staff deleteStaff(int staffId) {
		Optional<Staff> op=repo.findById(staffId);
		if(op.isPresent()) {
			repo.delete(op.get());
			return op.get();
		}else {
			return null;
		}
	}

	public Staff findStaffByEmail(String email){
    Optional<Staff> op=repo.findByEmail(email);
     if(op.isPresent()) {
    	return op.get();	
      }else {
      return null;
     }
    
	}
		

	
	

}
