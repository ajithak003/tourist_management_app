package com.daoInterface;

import java.sql.SQLException;
import java.util.List;

import com.module.UserFeedbackClass;

public interface UserFeedbackDaoInterface {
	
	public boolean insertUser(UserFeedbackClass user) throws ClassNotFoundException, SQLException;
    List<UserFeedbackClass> getAllUser() throws ClassNotFoundException, SQLException;
	public void getUserById(UserFeedbackClass user) throws ClassNotFoundException, SQLException;
	public void updateuser(UserFeedbackClass user) throws ClassNotFoundException, SQLException;
	public void deleteuser(UserFeedbackClass user) throws ClassNotFoundException, SQLException;
	public void validateUser(UserFeedbackClass user) throws ClassNotFoundException, SQLException;

}
