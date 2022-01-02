package com.ajith.daoInterface;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import com.ajith.model.BookingClass;
import com.ajith.model.UserClass;

public interface BookingDaoInterface {
	
	public boolean insertbooking(BookingClass booking, int end,int businessClassSeats,int economicClassSeats) throws ClassNotFoundException, SQLException;
    List<BookingClass> getAllbooking(UserClass user) throws ClassNotFoundException, SQLException;
	public BookingClass getbookingById( int user_id, LocalDate startDate) throws ClassNotFoundException, SQLException;
	public boolean updatebooking(int user_id, LocalDate startDate, double refundPrice,int businessSeats,int economicSeats,int flightNo) throws ClassNotFoundException, SQLException;
	public boolean deletebooking(int userId, LocalDate startDate) throws ClassNotFoundException, SQLException;
	public BookingClass validatebooking(String emailId, String password) throws ClassNotFoundException, SQLException;

	

}
