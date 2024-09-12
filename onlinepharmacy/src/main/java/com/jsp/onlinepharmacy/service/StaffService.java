package com.jsp.onlinepharmacy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.onlinepharmacy.dao.AdminDao;
import com.jsp.onlinepharmacy.dao.MedicalStoreDao;
import com.jsp.onlinepharmacy.dao.StaffDao;
import com.jsp.onlinepharmacy.dto.Admin;
import com.jsp.onlinepharmacy.dto.MedicalStore;
import com.jsp.onlinepharmacy.dto.Staff;
import com.jsp.onlinepharmacy.exception.AdminIdNotFoundException;
import com.jsp.onlinepharmacy.exception.MedicalStoreIdNotFoundException;
import com.jsp.onlinepharmacy.exception.StaffEmailNotValidException;
import com.jsp.onlinepharmacy.exception.StaffIdNotFoundException;
import com.jsp.onlinepharmacy.util.ResponseStructure;

@Service
public class StaffService {
	
	@Autowired
	private StaffDao dao;
	
	@Autowired
	private AdminDao admindao;

	@Autowired
	private MedicalStoreDao storedao;
	
	ResponseStructure<Staff> rs=new ResponseStructure<>();
	
	public ResponseEntity<ResponseStructure<Staff>> signupStaff(int adminid, int storeid, Staff staff) {
		Admin dbAdmin=admindao.findAdminById(storeid);
		if(dbAdmin!=null) {
			staff.setAdmin(dbAdmin);
			
		MedicalStore dbMedicalStore=storedao.findMedicalStore(storeid);	
		if(dbMedicalStore!=null) {
			staff.setMedicalStore(dbMedicalStore);
			Staff dbstaff=dao.saveStaff(staff);
			rs.setMessage("staff save successfully");
			rs.setHttpstatus(HttpStatus.CREATED.value());
			rs.setData(dbstaff);
			
			return new ResponseEntity<ResponseStructure<Staff>>(rs,HttpStatus.CREATED);
		}else {
			
			throw new MedicalStoreIdNotFoundException("sorry failed to Sign up Admin");
		}
			
			
		}else {
			
			throw new AdminIdNotFoundException("sorry failed to signup Staff");
			
		}
		
	}


	public ResponseEntity<ResponseStructure<Staff>> loginStaff(String email,String password){
		Staff staff=dao.findStaffByEmail(email);
		if(staff!=null) {
			if(staff.getStaffName().equals(password)) {
				rs.setMessage("Staff Login Successfully");
				rs.setHttpstatus(HttpStatus.OK.value());
				rs.setData(staff);
				return new ResponseEntity<ResponseStructure<Staff>>(rs,HttpStatus.OK);
			}else {
				throw new StaffEmailNotValidException("failed to login");
			}
		}else {
			throw new StaffEmailNotValidException("failed to login");
		}
		
	}
	
	
	public ResponseEntity<ResponseStructure<Staff>> updateStaff(int staffId, Staff staff) {
		Staff staffdb=dao.updateStaff(staffId, staff);
		if(staffdb!=null) {
			rs.setMessage("staff update successfuly");
			rs.setHttpstatus(HttpStatus.OK.value());
			rs.setData(staffdb);
			return new ResponseEntity<ResponseStructure<Staff>>(rs,HttpStatus.OK);
		}else {
			throw new StaffIdNotFoundException("sorry failed to update staff");
		}
		
	}
	
	

	public ResponseEntity<ResponseStructure<Staff>> deleteStaff(int staffId) {
		Staff staff=dao.deleteStaff(staffId);
		if(staff!=null) {
			rs.setMessage("Staff deleted succesfully !!!");
			rs.setHttpstatus(HttpStatus.FORBIDDEN.value());
			rs.setData(staff);
			return new ResponseEntity<ResponseStructure<Staff>>(rs,HttpStatus.FORBIDDEN);
		}else {
			throw new StaffIdNotFoundException("sorry failed to delete staff");
		}
		
	}



	public ResponseEntity<ResponseStructure<Staff>> findStaff(int staffId) {
		Staff staff=dao.findStaffById(staffId);
		if(staff!=null) {
			rs.setMessage("Staff found Successfully !!!");
			rs.setHttpstatus(HttpStatus.FOUND.value());
			rs.setData(staff);
			return new ResponseEntity<ResponseStructure<Staff>>(rs, HttpStatus.FOUND);
		}else {
		
			throw new StaffIdNotFoundException("sorry failed to fetch  staff ");
	
		}
	}


	public ResponseEntity<ResponseStructure<Staff>> reset(String email, String newPassword, long phone) {
		Staff staff=dao.findStaffByEmail(email);
		if(email!=null) {
			if(staff.getPhoneNumber()==phone) {
				staff.setStaffPassword(newPassword);
				dao.updateStaff(staff.getStaffId(), staff);
				rs.setMessage("Staff password reser succssfully");
				rs.setHttpstatus(HttpStatus.OK.value());
				rs.setData(staff);
				return new ResponseEntity<ResponseStructure<Staff>>(rs,HttpStatus.OK);
			}else {
			throw new StaffIdNotFoundException("sorry failed to reset password");
			}
		}else {
			throw new StaffIdNotFoundException("sorry failed to reset password");
		}
		
	}


	

	
	
}
