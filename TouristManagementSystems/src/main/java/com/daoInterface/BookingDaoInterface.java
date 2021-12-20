package com.daoInterface;

import java.sql.SQLException;
import java.util.List;

import com.model.BookingClass;

public interface BookingDaoInterface {
	
	public boolean insertbooking(BookingClass booking) throws ClassNotFoundException, SQLException;
    List<BookingClass> getAllbooking() throws ClassNotFoundException, SQLException;
	public BookingClass getbookingById(BookingClass booking) throws ClassNotFoundException, SQLException;
	public boolean updatebooking(String name, String email,long mobileNo, String password) throws ClassNotFoundException, SQLException;
	public boolean deletebooking(BookingClass booking) throws ClassNotFoundException, SQLException;
	public BookingClass validatebooking(String emailId, String password) throws ClassNotFoundException, SQLException;

	

}
