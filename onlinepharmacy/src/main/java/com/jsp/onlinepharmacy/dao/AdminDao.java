package com.jsp.onlinepharmacy.dao;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.jsp.onlinepharmacy.dto.Admin;
import com.jsp.onlinepharmacy.repository.AdminRepo;


@Repository
public class AdminDao {
	
	@Autowired 
	private AdminRepo repo;

	public Admin saveAdmin(Admin admin) {
		
		return repo.save(admin);
	}

	public Admin findAdminByEmail(String email) {

	  Optional<Admin> op=repo.findByEmail(email);
	  if(op.isPresent()) {
		  
		 return op.get();
	  }else {
		  return null;
	  }
		
	}

	public List<Admin> findAllAdmin() {
		List<Admin> list=repo.findAll();
		if(list!=null) {
			return list;
		}else {
			return null;
		}
	   
	 }
	public Admin findAdminById(int id) {
		Optional<Admin> data=repo.findById(id);
		if(data.isPresent()) {
			return data.get();
		}else {
		return null;
		}
	}

	public Admin updateAdmin(int id, Admin admin) {
		Admin admin2=findAdminById(id);
		if(admin2!=null) {
			admin.setAdminId(admin2.getAdminId());
			return repo.save(admin);
		}else {
			return null;	
		}
	}



	public Admin deleteAdminById(int id) {
		Admin admin=findAdminById(id);
		if(admin!=null) {
			repo.delete(admin);
			return admin;
		}else {
			return null;	
		}
		
	}

	

	

}
