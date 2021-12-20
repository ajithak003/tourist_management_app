package com.daoInterface;

import java.sql.SQLException;
import java.util.List;

import com.model.HotelClass;

public interface HotelDaoInterface {
	
	public boolean insertHotel(HotelClass Hotel) throws ClassNotFoundException, SQLException;
    List<HotelClass> getAllHotel() throws ClassNotFoundException, SQLException;
	public HotelClass getHotelByNo(HotelClass Hotel) throws ClassNotFoundException, SQLException;
	public boolean updateHotel(String name, String email,long mobileNo, String password) throws ClassNotFoundException, SQLException;
	public boolean deleteHotel(HotelClass Hotel) throws ClassNotFoundException, SQLException;
	public HotelClass validateHotel(String emailId, String password) throws ClassNotFoundException, SQLException;

}