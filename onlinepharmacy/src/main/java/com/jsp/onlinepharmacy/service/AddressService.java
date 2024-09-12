package com.jsp.onlinepharmacy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.onlinepharmacy.dao.AddressDao;
import com.jsp.onlinepharmacy.dto.Address;
import com.jsp.onlinepharmacy.exception.AddressIdNotFoundException;
import com.jsp.onlinepharmacy.exception.AddressNotUpdateException;
import com.jsp.onlinepharmacy.util.ResponseStructure;

@Service
public class AddressService {

	@Autowired
	private AddressDao dao;
	
	
	ResponseStructure<Address> rs=new ResponseStructure<>();
	
	
	
	public ResponseEntity<ResponseStructure<Address>> saveAddress(Address address) {
	 	Address add=dao.saveAddress(address);
	 	rs.setMessage("Address saved Successfully");
        rs.setHttpstatus(HttpStatus.CREATED.value());
        rs.setData(add);
        return new ResponseEntity<ResponseStructure<Address>>(rs,HttpStatus.CREATED);
	}


	public ResponseEntity<ResponseStructure<Address>> updateAddress(int id, Address address) {
		Address newaddress=dao.updateAddress(id, address);
		if(newaddress!=null) {
			rs.setMessage("Address Updated Successfully");
	        rs.setHttpstatus(HttpStatus.OK.value());
	        rs.setData(newaddress);
	        return new ResponseEntity<ResponseStructure<Address>>(rs,HttpStatus.OK);
		}else {
			
			throw new AddressNotUpdateException();
		}
		
	}


	public ResponseEntity<ResponseStructure<Address>> findAddress(int id) {
	Address address=dao.findAddressById(id);
	if(address!=null) {
		 rs.setMessage("Address found Successfully");
		 rs.setHttpstatus(HttpStatus.FOUND.value());
		 rs.setData(address);
		 return new ResponseEntity<ResponseStructure<Address>>(rs,HttpStatus.FOUND);
	}else {
		
	   throw new AddressIdNotFoundException("sorry unable to find Address");
		
	 }
		
	}


	public ResponseEntity<ResponseStructure<Address>> deleteAddress(int id) {
		Address address=dao.deleteAddress(id);
		if(address!=null) {
			 rs.setMessage("Address deleted Successfully");
			 rs.setHttpstatus(HttpStatus.FORBIDDEN.value());
			 rs.setData(address);
			 return new ResponseEntity<ResponseStructure<Address>>(rs,HttpStatus.FORBIDDEN);
		}else {
			
		   throw new AddressIdNotFoundException("sorry unable to delete Address");
			
		 }
	}

	
}
