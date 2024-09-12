package com.jsp.onlinepharmacy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.onlinepharmacy.dao.MedicalStoreDao;
import com.jsp.onlinepharmacy.dao.MedicineDao;
import com.jsp.onlinepharmacy.dto.MedicalStore;
import com.jsp.onlinepharmacy.dto.Medicines;
import com.jsp.onlinepharmacy.exception.MedicalStoreIdNotFoundException;
import com.jsp.onlinepharmacy.exception.MedicineIdNotFoundException;
import com.jsp.onlinepharmacy.exception.MedicineNameNotFoundException;
import com.jsp.onlinepharmacy.util.ResponseStructure;

@Service
public class MedicineService {

	
	@Autowired
	private MedicineDao dao;
	
	@Autowired
	private MedicalStoreDao storedao;
	
	
	
	public ResponseEntity<ResponseStructure<Medicines>> addMedicine( int storeId, Medicines medicines) {
	        MedicalStore dbMedicalStore=storedao.findMedicalStore(storeId);
	        if(dbMedicalStore!=null) {
	        	medicines.setMedicalStore(dbMedicalStore);
	        	Medicines dbMedicine=dao.saveMedicines(medicines);
	        	ResponseStructure<Medicines> rs =new ResponseStructure<>();
	        	rs.setMessage("Medicine added Successfully");
	        	rs.setHttpstatus(HttpStatus.CREATED.value());
	        	rs.setData(dbMedicine);
	        	return new ResponseEntity<ResponseStructure<Medicines>>(rs, HttpStatus.CREATED);
	        }else {
	        	throw new MedicalStoreIdNotFoundException("sorry failed to add Medicine");
	        }
		
	}

	public ResponseEntity<ResponseStructure<Medicines>> updateMedicine(int medicineId, Medicines medicines) {
	 Medicines dbmedicine=dao.updateMedicine(medicineId, medicines);
	  if(dbmedicine!=null) {
		ResponseStructure<Medicines> rs =new ResponseStructure<>();
    	rs.setMessage("Medicine updated Successfully");
    	rs.setHttpstatus(HttpStatus.OK.value());
    	rs.setData(dbmedicine);
    	return new ResponseEntity<ResponseStructure<Medicines>>(rs, HttpStatus.OK);
	  }else {
		throw new MedicineIdNotFoundException("sorry failed to update Medicine");
       }
	
	}

	public ResponseEntity<ResponseStructure<Medicines>> deleteMedicine(int medicineId) {
		Medicines dbmedicine=dao.deleteMedicineById(medicineId);
		if(dbmedicine!=null) {
			ResponseStructure<Medicines> rs =new ResponseStructure<>();
        	rs.setMessage("Medicine updated Successfully");
        	rs.setHttpstatus(HttpStatus.FORBIDDEN.value());
        	rs.setData(dbmedicine);	
        	return new ResponseEntity<ResponseStructure<Medicines>>(rs,HttpStatus.FORBIDDEN);
		   }else {
			throw new MedicineIdNotFoundException("sorry failed to delete Medicine");
		  }
	}

	public ResponseEntity<ResponseStructure<Medicines>> findMedicine(int medicineId) {
		Medicines dbmedicine=dao.findMedicineById(medicineId);
		if(dbmedicine!=null) {
			ResponseStructure<Medicines> rs =new ResponseStructure<>();
        	rs.setMessage("Medicine found Successfully");
        	rs.setHttpstatus(HttpStatus.FOUND.value());
        	rs.setData(dbmedicine);	
        	return new ResponseEntity<ResponseStructure<Medicines>>(rs,HttpStatus.FOUND);
		}else {
			throw new MedicineIdNotFoundException("sorry failed to fetch Medicine");
		}
	}

	public ResponseEntity<ResponseStructure<Medicines>> findMedicinesByName(String medicineName) {
		Medicines dbmedicine=dao.findMedicineByName(medicineName);
		if(dbmedicine!=null) {
			ResponseStructure<Medicines> rs =new ResponseStructure<>();
        	rs.setMessage("Medicine found Successfully");
        	rs.setHttpstatus(HttpStatus.FOUND.value());
        	rs.setData(dbmedicine);	
        	return new ResponseEntity<ResponseStructure<Medicines>>(rs,HttpStatus.FOUND);
		}else {
			throw new MedicineNameNotFoundException("Sorry failed to fetch Medicine");
		}
	}

	

	

}
