package com.jsp.onlinepharmacy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.onlinepharmacy.dao.AddressDao;
import com.jsp.onlinepharmacy.dao.AdminDao;
import com.jsp.onlinepharmacy.dao.MedicalStoreDao;
import com.jsp.onlinepharmacy.dto.Address;
import com.jsp.onlinepharmacy.dto.Admin;
import com.jsp.onlinepharmacy.dto.MedicalStore;
import com.jsp.onlinepharmacy.exception.AddressIdNotFoundException;
import com.jsp.onlinepharmacy.exception.AdminIdNotFoundException;
import com.jsp.onlinepharmacy.exception.MedicalStoreIdNotFoundException;
import com.jsp.onlinepharmacy.util.ResponseStructure;


 @Service
 public class MedicalStoreService{
	
   @Autowired
   private MedicalStoreDao dao;

   @Autowired
   private AdminDao admindao;

   @Autowired
   private AddressDao addressdao;


   ResponseStructure<MedicalStore> rs=new ResponseStructure<>();

       public ResponseEntity<ResponseStructure<MedicalStore>> establishMedicalStore(int adminid, int addressid,
		MedicalStore medicalstore) {
	      Admin admindb=admindao.findAdminById(adminid);
     	if(admindao!=null) {
		
		medicalstore.setAdmin(admindb);
		Address addressdb=addressdao.findAddressById(addressid);
		if(addressdb!=null) {
			addressdb.setMedicalStore(medicalstore);
			medicalstore.setAddress(addressdb);
			MedicalStore medicalstoredb=dao.saveMedicalStore(medicalstore);
			rs.setMessage("Medicalstore Establish Successfully");
			rs.setHttpstatus(HttpStatus.CREATED.value());
			rs.setData(medicalstoredb);
			return new ResponseEntity<ResponseStructure<MedicalStore>>(rs,HttpStatus.CREATED);	
		}else {
			throw new AddressIdNotFoundException("sorry failed to establish the medicalstore");
		}
		
	}else {
		throw new AdminIdNotFoundException("sorry failed to establish the medicalstore");
	}
}

       public ResponseEntity<ResponseStructure<MedicalStore>> updateMedicalStore(int storeid, MedicalStore medicalstore) {
	    MedicalStore medicalstoredb=dao.updateMedicalStore(storeid,medicalstore);
	    if(medicalstoredb!=null) {
		rs.setMessage("medicalstore updated successfully");
		rs.setHttpstatus(HttpStatus.OK.value());
		rs.setData(medicalstore);
		return new ResponseEntity<ResponseStructure<MedicalStore>>(rs,HttpStatus.OK);
	    }else {
		throw new MedicalStoreIdNotFoundException("sorry failed to update Medical Store");
	    }
	
       }

       public ResponseEntity<ResponseStructure<MedicalStore>> deleteMedicalStore(int storeid) {
     	MedicalStore medicalstoredb=dao.deleteMedicalStore(storeid);
	    if(medicalstoredb!=null) {
		 rs.setMessage("MedicalStore deleted Successfully");
		 rs.setHttpstatus(HttpStatus.FORBIDDEN.value());
		 rs.setData(medicalstoredb);
		 return new ResponseEntity<ResponseStructure<MedicalStore>>(rs,HttpStatus.FORBIDDEN);
	    }else {
		
		throw new MedicalStoreIdNotFoundException("sorry failed to delete Medical Store");
	    }
	
	   }

       public ResponseEntity<ResponseStructure<MedicalStore>> findMedicalStore(int storeid) {
        MedicalStore medicalstoredb=dao.findMedicalStore(storeid);
        if(medicalstoredb!=null) {
         rs.setMessage("Medicalstore found Successfully");
         rs.setHttpstatus(HttpStatus.FOUND.value());
         rs.setData(medicalstoredb);
         return new ResponseEntity<ResponseStructure<MedicalStore>>(rs,HttpStatus.FOUND);		

          }else {
	
	     throw new MedicalStoreIdNotFoundException("sorry failed to fetch the MedicalStore");
         }

        }
	
	
}



