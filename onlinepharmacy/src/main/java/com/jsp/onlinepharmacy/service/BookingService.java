package com.jsp.onlinepharmacy.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.onlinepharmacy.dao.BookingDao;
import com.jsp.onlinepharmacy.dao.CustomerDao;
import com.jsp.onlinepharmacy.dao.MedicineDao;
import com.jsp.onlinepharmacy.dto.Booking;
import com.jsp.onlinepharmacy.dto.Customer;
import com.jsp.onlinepharmacy.dto.Medicines;
import com.jsp.onlinepharmacy.enums.BookingStatus;
import com.jsp.onlinepharmacy.exception.BookingCantCancelledException;
import com.jsp.onlinepharmacy.exception.CustomerIdNotFoundException;
import com.jsp.onlinepharmacy.exception.MedicineIdNotFoundException;
import com.jsp.onlinepharmacy.exception.bookingIdNotFoundException;
import com.jsp.onlinepharmacy.util.ResponseStructure;

@Service
public class BookingService {
	
	@Autowired
	private BookingDao dao;
	
	@Autowired
	private MedicineDao medicinedao;
	
	@Autowired
	private CustomerDao customerdao;

	public ResponseEntity<ResponseStructure<Booking>> saveBooking(int medicineId, int customerId, Booking bookings) {
		Customer customer=customerdao.findCutomer(customerId);
		if(customer!=null) {
		   Medicines dbmedicine=medicinedao.findMedicineById(medicineId);
		   if(dbmedicine!=null) {
			   bookings.setOrderDate(LocalDate.now());
			   bookings.setExpectedDate(LocalDate.now().plusDays(7));
			   bookings.setBookingStatus(BookingStatus.ACTIVE);
			   List<Medicines> medicines=new ArrayList<>();
			   medicines.add(dbmedicine);
			   bookings.setCustomer(customer);
			   bookings.setMedicines(medicines);
			   List<Booking> bookingofcustomer=new ArrayList<>();
			   bookingofcustomer.add(bookings);
			   customer.setBookings(bookingofcustomer);
			   Booking dbBooking=dao.savBooking(bookings);
			   ResponseStructure<Booking> rs=new ResponseStructure<Booking>();
			   rs.setMessage("BOOKING SUCCESSFULLY");
			   rs.setHttpstatus(HttpStatus.CREATED.value());
			   rs.setData(dbBooking);
		       return new ResponseEntity<ResponseStructure<Booking>>(rs,HttpStatus.CREATED);	
	        
			}else {
				throw new MedicineIdNotFoundException("Sorry failed to add bookings");
			}
		}else {
			throw new CustomerIdNotFoundException("Sorry failed to add bookings");
		}
		
	}

	public ResponseEntity<ResponseStructure<Booking>> cancelBooking(int bookingId) {
	 Booking dbbooking=dao.findBooking(bookingId);
	 if(dbbooking!=null) {
		 LocalDate cantcancelled=dbbooking.getExpectedDate().minusDays(2);
		 if(dbbooking.getBookingStatus().equals(BookingStatus.DELIVERED)) {
			 throw new BookingCantCancelledException("Sorry booking already delivered");
			 
		 }else if(dbbooking.getBookingStatus().equals(BookingStatus.CANCELLED)) {
			 throw new BookingCantCancelledException("Sorry booking already cancelled");
			 
		 }else if(LocalDate.now().equals(cantcancelled) && LocalDate.now().isAfter(cantcancelled)) {
			 throw new BookingCantCancelledException("Sorry Its already late");
			 
		 }else {
			 dbbooking.setBookingStatus(BookingStatus.CANCELLED);
			 ResponseStructure<Booking> rs=new ResponseStructure<>();
			 rs.setMessage("Booking cancelled Successfully");
			 rs.setHttpstatus(HttpStatus.FORBIDDEN.value());
			 rs.setData(dbbooking);
			 return new ResponseEntity<ResponseStructure<Booking>>(rs,HttpStatus.FORBIDDEN);
		 }
	 }else {
		 
		 throw new bookingIdNotFoundException("sorry fialed to cancel booking");
	 }
	
		
		
	}

}
