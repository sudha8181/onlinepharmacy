package com.jsp.onlinepharmacy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.onlinepharmacy.dto.Address;

public interface AddressRepo extends JpaRepository<Address, Integer> {

}
