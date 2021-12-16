package com.daoInterface;

import java.sql.SQLException;
import java.util.List;

import com.module.FlightClass;

public interface FlightDaoInterface {
	
	public boolean insertUser(FlightClass user) throws ClassNotFoundException, SQLException;
    List<FlightClass> getAllUser() throws ClassNotFoundException, SQLException;
	public void getUserById(FlightClass user) throws ClassNotFoundException, SQLException;
	public void updateuser(FlightClass user) throws ClassNotFoundException, SQLException;
	public void deleteuser(FlightClass user) throws ClassNotFoundException, SQLException;
	public void validateUser(FlightClass user) throws ClassNotFoundException, SQLException;
	


}
