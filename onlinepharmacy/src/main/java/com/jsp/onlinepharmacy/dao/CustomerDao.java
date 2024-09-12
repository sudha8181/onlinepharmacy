package com.jsp.onlinepharmacy.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.onlinepharmacy.dto.Customer;
import com.jsp.onlinepharmacy.repository.AddressRepo;
import com.jsp.onlinepharmacy.repository.CustomerRepo;

@Repository
public class CustomerDao {

	@Autowired
	CustomerRepo repo;
	
	@Autowired
	AddressRepo addressrepo;
	
	
	public Customer saveCustomer(Customer customer) {
	
		return repo.save(customer);
	}
	
	public Customer findCutomer(int customerId) {
		Optional<Customer> op=repo.findById(customerId);
		if(op.isPresent()) {
			return op.get();
		}else {
			return null;
		}
	}
}
