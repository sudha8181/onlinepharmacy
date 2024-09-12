package com.jsp.onlinepharmacy.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.onlinepharmacy.dao.AddressDao;
import com.jsp.onlinepharmacy.dao.CustomerDao;
import com.jsp.onlinepharmacy.dto.Address;
import com.jsp.onlinepharmacy.dto.Customer;
import com.jsp.onlinepharmacy.exception.AddressIdNotFoundException;
import com.jsp.onlinepharmacy.util.ResponseStructure;

@Service
public class CustomerService {

	
	@Autowired
	 private CustomerDao dao;
	
	@Autowired
	private AddressDao addressdao;
	
	
	public ResponseEntity<ResponseStructure<Customer>> saveCustomer(int addressId,Customer customer){
		Address dbAddress=addressdao.findAddressById(addressId);
		if(dbAddress!=null) {
			List<Address> addresses=new ArrayList<>();
			addresses.add(dbAddress);
			customer.setAddresses(addresses);
			Customer dbcustomer=dao.saveCustomer(customer);
			dbAddress.setCustomer(customer);
			ResponseStructure<Customer> rs=new ResponseStructure<>();
			rs.setMessage("Customer signed up Successfully");
			rs.setHttpstatus(HttpStatus.CREATED.value());
			rs.setData(dbcustomer);
			return new ResponseEntity<ResponseStructure<Customer>>(rs,HttpStatus.CREATED);
			
		}else {
			throw new AddressIdNotFoundException("sorry failed to signup customer");
		}
	}
	
	
}
