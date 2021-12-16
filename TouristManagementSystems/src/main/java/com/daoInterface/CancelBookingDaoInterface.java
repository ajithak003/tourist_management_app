package com.daoInterface;

import java.sql.SQLException;
import java.util.List;

import com.module.CancelBookingClass;

public interface CancelBookingDaoInterface {
	
	public boolean insertUser(CancelBookingClass user) throws ClassNotFoundException, SQLException;
    List<CancelBookingClass> getAllUser() throws ClassNotFoundException, SQLException;
	public void getUserById(CancelBookingClass user) throws ClassNotFoundException, SQLException;
	public void updateuser(CancelBookingClass user) throws ClassNotFoundException, SQLException;
	public void deleteuser(CancelBookingClass user) throws ClassNotFoundException, SQLException;
	public void validateUser(CancelBookingClass user) throws ClassNotFoundException, SQLException;
	

}
