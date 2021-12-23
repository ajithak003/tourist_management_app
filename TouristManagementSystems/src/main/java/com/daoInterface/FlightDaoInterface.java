package com.daoInterface;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;


import com.model.FlightClass;


public interface FlightDaoInterface {
	
	public boolean insertFlight(FlightClass flight) throws ClassNotFoundException, SQLException;
    List<FlightClass> getAllFlight() throws ClassNotFoundException, SQLException;
	//public FlightClass getFlightByNo(String location, LocalDateTime startDate) throws ClassNotFoundException, SQLException;
	public boolean updateFlight(FlightClass flight) throws ClassNotFoundException, SQLException;
	public boolean deleteFlight(int flightNo) throws ClassNotFoundException, SQLException;
	public FlightClass validateFlight(String emailId, String password) throws ClassNotFoundException, SQLException;
	List<FlightClass> getFlightByNo(String location, LocalDate startDate);
	FlightClass getSingleFlight(int flightNo);


}