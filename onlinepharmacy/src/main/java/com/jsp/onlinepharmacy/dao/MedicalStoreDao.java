package com.jsp.onlinepharmacy.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.onlinepharmacy.dto.Address;
import com.jsp.onlinepharmacy.dto.MedicalStore;
import com.jsp.onlinepharmacy.repository.MedicalStoreRepo;

@Repository
public class MedicalStoreDao {
	
	@Autowired
	private MedicalStoreRepo repo;

	public MedicalStore saveMedicalStore(MedicalStore medicalstore) {
		
		return repo.save(medicalstore);
	}

	

	public MedicalStore updateMedicalStore(int storeid, MedicalStore medicalstore) {
		Optional<MedicalStore> medicalstoredb=repo.findById(storeid);	
		if(medicalstoredb.isPresent()) {
			medicalstore.setStoreId(storeid);
			medicalstore.setAdmin(medicalstoredb.get().getAdmin());
			medicalstore.setAddress(medicalstoredb.get().getAddress());
			return repo.save(medicalstore);
		}else {
			return null;
		}
	}

	public MedicalStore deleteMedicalStore(int storeid) {
		Optional<MedicalStore> medicalstore =repo.findById(storeid);
		if(medicalstore.isPresent()) {
           Address address=medicalstore.get().getAddress();		
           address.setMedicalStore(null);
		   repo.deleteById(storeid);
		    return medicalstore.get();
		}else {
			return null;
		}
		
	}

	public MedicalStore findMedicalStore(int storeid) {
		
		Optional<MedicalStore> medicalstore=repo.findById(storeid);
		if(medicalstore.isPresent()) {
			return medicalstore.get();
		}else {
			return null;
		}
	}


}
