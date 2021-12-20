package com.daoInterface;

import java.sql.SQLException;
import java.util.List;


import com.model.FlightClass;


public interface FlightDaoInterface {
	
	public boolean insertFlight(FlightClass flight) throws ClassNotFoundException, SQLException;
    List<FlightClass> getAllFlight() throws ClassNotFoundException, SQLException;
	public FlightClass getFlightByNo(FlightClass flight) throws ClassNotFoundException, SQLException;
	public boolean updateFlight(FlightClass flight) throws ClassNotFoundException, SQLException;
	public boolean deleteFlight(int flightNo) throws ClassNotFoundException, SQLException;
	public FlightClass validateFlight(String emailId, String password) throws ClassNotFoundException, SQLException;


}
