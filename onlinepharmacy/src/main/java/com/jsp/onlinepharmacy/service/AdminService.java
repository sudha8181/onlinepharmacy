package com.jsp.onlinepharmacy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.onlinepharmacy.dao.AdminDao;
import com.jsp.onlinepharmacy.dto.Admin;
import com.jsp.onlinepharmacy.exception.AdminEmailNotValidException;
import com.jsp.onlinepharmacy.exception.AdminIdNotFoundException;
import com.jsp.onlinepharmacy.exception.AdminEmailNotValidException;
import com.jsp.onlinepharmacy.exception.AdminPasswordNotValidException;
import com.jsp.onlinepharmacy.exception.AdminPhoneNotValidException;
import com.jsp.onlinepharmacy.util.ResponseStructure;

@Service
public class AdminService {
	
	@Autowired
	private AdminDao dao;
	
	ResponseStructure<Admin> rs=new ResponseStructure<>();
	
	
	public ResponseEntity<ResponseStructure<Admin>> signupAdmin(Admin admin){
		
		Admin admindb=dao.saveAdmin(admin);
		rs.setMessage("Admin signedUp Successfully");
		rs.setHttpstatus(HttpStatus.CREATED.value());
		rs.setData(admindb);
		
		return new ResponseEntity<ResponseStructure<Admin>>(rs,HttpStatus.CREATED);
	}


	public ResponseEntity<ResponseStructure<Admin>> loginAdmin(String email, String password) {
		Admin admin=dao.findAdminByEmail(email);
		if(admin!=null) {
			
			if(admin.getPassword().equals(password)) {
				rs.setMessage("Admin Login Successfully !!!!!");
				rs.setHttpstatus(HttpStatus.FOUND.value());
				rs.setData(admin);
				return new ResponseEntity<ResponseStructure<Admin>>(rs,HttpStatus.FOUND);
			}else {
				throw new AdminPasswordNotValidException("sorry failed to Login");
			}
		}else {
			throw new AdminEmailNotValidException("sorry failed to login");
			
		}
		
	}


	
	
	public ResponseEntity<ResponseStructure<List<Admin>>> allAdmin() {
	
		List<Admin> admins=dao.findAllAdmin();
		ResponseStructure<List<Admin>> rp=new ResponseStructure<>();
		if(admins!=null) {
			rp.setMessage("found all Admin");
			rp.setHttpstatus(HttpStatus.FOUND.value());
			rp.setData(admins);
			return new ResponseEntity<ResponseStructure<List<Admin>>>(rp,HttpStatus.FOUND);
		}
		else {
			rp.setMessage("Not Found admin data");
			rp.setHttpstatus(HttpStatus.BAD_REQUEST.value());
			rp.setData(null);
			return new ResponseEntity<ResponseStructure<List<Admin>>>(rp,HttpStatus.BAD_REQUEST);
		}
	}


	public ResponseEntity<ResponseStructure<Admin>> updateAdmin(int id, Admin admin) {
		
		Admin updatedAdmin=dao.updateAdmin(id,admin);
		if(updatedAdmin!=null) {
			rs.setMessage("Admin Updated Successfully !!!!!");
			rs.setHttpstatus(HttpStatus.OK.value());
			rs.setData(updatedAdmin);
			return new ResponseEntity<ResponseStructure<Admin>>(rs,HttpStatus.OK);
		}else {
			
			throw new AdminIdNotFoundException("sorry failed to update");
		}
		
	}


	
	
	public ResponseEntity<ResponseStructure<Admin>> findAdminById(int id) {
	
		Admin admin=dao.findAdminById(id);
		if(admin!=null) {
			rs.setMessage("Admin Found Succesfully");
			rs.setHttpstatus(HttpStatus.FOUND.value());
			rs.setData(admin);
			return new ResponseEntity<ResponseStructure<Admin>>(rs,HttpStatus.FOUND);
		}else {
			throw new AdminIdNotFoundException("sorry failed to fetch the data");
		}
		
	}


	
	
	
	public ResponseEntity<ResponseStructure<Admin>> resetpassword(String email, String newpassword, long phoneno) {

         Admin admin=dao.findAdminByEmail(email);
         if(admin!=null) {
        	 
        	 if(admin.getPhoneNumber()==phoneno) {
        	
        		 admin.setPassword(newpassword);
        		 dao.updateAdmin(admin.getAdminId(), admin);
        		 rs.setMessage("Admin password updated successfully");
        		 rs.setHttpstatus(HttpStatus.OK.value());
        		 rs.setData(admin);
        		 return new ResponseEntity<ResponseStructure<Admin>>(rs,HttpStatus.OK); 
        	 }else {
        		 throw new AdminPhoneNotValidException("sorry failed to reset the password");
        		
        	 }
        	 
         }else {
        	 throw new AdminEmailNotValidException("sorry failed to reset the password");
         }
	
	}


	public ResponseEntity<ResponseStructure<Admin>> deleteAdminById(int id) {
	Admin admin=dao.deleteAdminById(id);
	if(admin!=null) {
		rs.setMessage("Admin deleted successfully");
		rs.setHttpstatus(HttpStatus.OK.value());
		rs.setData(admin);
		return new ResponseEntity<ResponseStructure<Admin>>(rs, HttpStatus.OK);
	}else {
		throw new AdminIdNotFoundException("sorry failed to delete the admin details");
		
		
	}
		
	}

	
	
	

}
