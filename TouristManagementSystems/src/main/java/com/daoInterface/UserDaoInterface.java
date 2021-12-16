package com.daoInterface;

import java.sql.SQLException;
import java.util.List;

import com.module.UserClass;

public interface UserDaoInterface {
	
	public boolean insertUser(UserClass user) throws ClassNotFoundException, SQLException;
    List<UserClass> getAllUser() throws ClassNotFoundException, SQLException;
	public void getUserById(UserClass user) throws ClassNotFoundException, SQLException;
	public void updateuser(UserClass user) throws ClassNotFoundException, SQLException;
	public void deleteuser(UserClass user) throws ClassNotFoundException, SQLException;
	public UserClass validateUser(String emailId, String password) throws ClassNotFoundException, SQLException;

}
