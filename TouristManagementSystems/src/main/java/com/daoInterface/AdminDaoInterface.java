package com.daoInterface;

import java.sql.SQLException;
import java.util.List;

import com.model.AdminClass;

public interface AdminDaoInterface {
	

	public boolean insertAdmin(AdminClass admin) throws ClassNotFoundException, SQLException;
    List<AdminClass> getAllAdmin() throws ClassNotFoundException, SQLException;
	public void getUserById(AdminClass admin) throws ClassNotFoundException, SQLException;
	public void updateuser(AdminClass admin) throws ClassNotFoundException, SQLException;
	public void deleteuser(AdminClass admin) throws ClassNotFoundException, SQLException;
	public AdminClass validateAdmin(String emailId, String password ) throws ClassNotFoundException, SQLException;

}
