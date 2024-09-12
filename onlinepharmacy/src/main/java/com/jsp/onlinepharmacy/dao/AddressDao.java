package com.jsp.onlinepharmacy.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.onlinepharmacy.dto.Address;
import com.jsp.onlinepharmacy.repository.AddressRepo;

@Repository
public class AddressDao {

	@Autowired
	private AddressRepo repo;
	
	
	public Address saveAddress(Address address) {
		return repo.save(address);
	}
	
	
	public Address updateAddress(int id,Address address) {
		Optional<Address> op=repo.findById(id);
		
		if(op.isPresent()) {
			
			address.setAddressId(op.get().getAddressId());
			address.setCustomer(op.get().getCustomer());
			address.setMedicalStore(op.get().getMedicalStore());
			return repo.save(address);
		}else {
			return null;
		}
		
		
	}


	public Address findAddressById(int id) {
		Optional<Address> op=repo.findById(id);
		if(op.isPresent()) {
			return op.get();
		}else {
			return null;
		}
		
	}


	public Address deleteAddress(int id) {
		Optional<Address> op=repo.findById(id);
        if(op.isPresent()) {
			repo.delete(op.get());
			return op.get();	
		}else {
			return null;
		}
	}
	
	
}
