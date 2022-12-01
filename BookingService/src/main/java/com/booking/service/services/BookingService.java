package com.booking.service.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booking.service.DAO.BookingDAO;
import com.booking.service.entities.Booking;
import com.booking.service.entities.Room;
import com.booking.service.exceptions.BookingDetailsNotFoundException;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class BookingService {

	@Autowired
	private BookingDAO bookingDAO;
	
	public int intiateBooking(Booking booking,List<Room> availableRooms) {
		StringBuilder strBuilder = new StringBuilder();
		availableRooms.stream().forEach(room->{
			strBuilder.append(room.getRoomNumber()+" ");
		});
		int totalPrice = 0;
		for(Room room : availableRooms) {
			totalPrice += room.getPrice();
		}
		// set Room Numbers and Price
		booking.setRoomNumbers(strBuilder.toString());
		booking.setRoomPrice(totalPrice);
		return bookingDAO.save(booking).getId();
	}
	
	public Booking processAndConfirmBooking(int bookingID,int transactionID){
		Optional<Booking> bookingDetails = bookingDAO.findById(bookingID);
		bookingDetails.orElseThrow(()->new BookingDetailsNotFoundException("No Details for bookingId "+bookingID+" found !"));
		
		// set booking date
		bookingDetails.get().setBookedOn(new Date());
		
		// set transaction id
		bookingDetails.get().setTransactionId(transactionID);
		
		return bookingDetails.get();
	}
	
	public void processAndCancelBooking(int bookingID){
		if(bookingDAO.existsById(bookingID))
			bookingDAO.deleteById(bookingID);
		else
			throw new BookingDetailsNotFoundException("No Details for bookingId "+bookingID+" found !");
	    
	}

}
