package com.jsp.onlinepharmacy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.onlinepharmacy.dto.Customer;

public interface CustomerRepo extends JpaRepository<Customer,Integer >{

}
