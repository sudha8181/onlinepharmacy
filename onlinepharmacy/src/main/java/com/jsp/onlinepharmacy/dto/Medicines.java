package com.jsp.onlinepharmacy.dto;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonValueFormat;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Medicines {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int medicineId;
	private  String medicineName;
	private  double cost;
	
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
	private  LocalDateTime expiryDate;
	private int stockQunatity;
	private String manufacturer;
	private String description;
	
	
	@ManyToOne
	private MedicalStore medicalStore;
	
	
	

}
