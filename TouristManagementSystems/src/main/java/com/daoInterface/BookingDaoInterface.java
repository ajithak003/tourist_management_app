package com.daoInterface;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import com.model.BookingClass;
import com.model.UserClass;

public interface BookingDaoInterface {
	
	public boolean insertbooking(BookingClass booking, int end) throws ClassNotFoundException, SQLException;
    List<BookingClass> getAllbooking(UserClass user) throws ClassNotFoundException, SQLException;
	public BookingClass getbookingById( int user_id, LocalDate startDate) throws ClassNotFoundException, SQLException;
	public boolean updatebooking(int user_id, LocalDate startDate, double refundPrice) throws ClassNotFoundException, SQLException;
	public boolean deletebooking(int userId, LocalDate startDate) throws ClassNotFoundException, SQLException;
	public BookingClass validatebooking(String emailId, String password) throws ClassNotFoundException, SQLException;

	

}
