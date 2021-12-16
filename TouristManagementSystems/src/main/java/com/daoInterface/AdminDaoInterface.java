package com.daoInterface;

import java.sql.SQLException;
import java.util.List;

import com.module.AdminClass;

public interface AdminDaoInterface {
	

	public boolean insertUser(AdminClass user) throws ClassNotFoundException, SQLException;
    List<AdminClass> getAllUser() throws ClassNotFoundException, SQLException;
	public void getUserById(AdminClass user) throws ClassNotFoundException, SQLException;
	public void updateuser(AdminClass user) throws ClassNotFoundException, SQLException;
	public void deleteuser(AdminClass user) throws ClassNotFoundException, SQLException;
	public AdminClass validateUser(String emailId, String password ) throws ClassNotFoundException, SQLException;

}
