package com.jsp.onlinepharmacy.dao;


import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.onlinepharmacy.dto.Booking;
import com.jsp.onlinepharmacy.repository.BookingRepo;

@Repository
public class BookingDao {

	
	@Autowired
	private BookingRepo repo;
	
	public Booking savBooking(Booking booking) {
		return repo.save(booking);
	}

	public Booking findBooking(int bookingId) {
		Optional<Booking> op=repo.findById(bookingId);
		if(op.isPresent()) {
			
			return op.get();
		}else {
			return null;
		}
		
		
	}
}
