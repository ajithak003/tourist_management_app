package com.daoInterface;

import java.sql.SQLException;
import java.util.List;

import com.module.BookingClass;

public interface BookingDaoInterface {
	
	public boolean insertUser(BookingClass user) throws ClassNotFoundException, SQLException;
    List<BookingClass> getAllUser() throws ClassNotFoundException, SQLException;
	public void getUserById(BookingClass user) throws ClassNotFoundException, SQLException;
	public void updateuser(BookingClass user) throws ClassNotFoundException, SQLException;
	public void deleteuser(BookingClass user) throws ClassNotFoundException, SQLException;
	public void validateUser(BookingClass user) throws ClassNotFoundException, SQLException;
	
	

}
