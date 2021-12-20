package com.daoInterface;

import java.sql.SQLException;
import java.util.List;

import com.module.UserClass;

public interface UserDaoInterface {
	
	public void insertUser(UserClass user) throws ClassNotFoundException, SQLException;
    List<UserClass> getAllUser() throws ClassNotFoundException, SQLException;
	public void getUserById(UserClass user) throws ClassNotFoundException, SQLException;
	public void updateuser(UserClass user) throws ClassNotFoundException, SQLException;
	public void deleteuser(UserClass user) throws ClassNotFoundException, SQLException;
	public void validateUser(UserClass user) throws ClassNotFoundException, SQLException;

}
