package com.daoInterface;

import java.sql.SQLException;
import java.util.List;

import com.module.GaidClass;

public interface GaidDaoInterface {

	public boolean insertUser(GaidClass user) throws ClassNotFoundException, SQLException;
    List<GaidClass> getAllUser() throws ClassNotFoundException, SQLException;
	public void getUserById(GaidClass user) throws ClassNotFoundException, SQLException;
	public void updateuser(GaidClass user) throws ClassNotFoundException, SQLException;
	public void deleteuser(GaidClass user) throws ClassNotFoundException, SQLException;
	public void validateUser(GaidClass user) throws ClassNotFoundException, SQLException;
	
}
