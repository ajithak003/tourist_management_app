package com.daoInterface;

import java.sql.SQLException;
import java.util.List;

import com.model.UserFeedbackClass;

public interface UserFeedbackDaoInterface {
	
	public boolean insertFeedback(UserFeedbackClass Feedback) throws ClassNotFoundException, SQLException;
    List<UserFeedbackClass> getAllFeedback() throws ClassNotFoundException, SQLException;
	public UserFeedbackClass getFeedbackByNo(UserFeedbackClass Feedback) throws ClassNotFoundException, SQLException;
	public boolean updateFeedback(String name, String email,long mobileNo, String password) throws ClassNotFoundException, SQLException;
	public boolean deleteFeedback(UserFeedbackClass Feedback) throws ClassNotFoundException, SQLException;
	public UserFeedbackClass validateFeedback(String emailId, String password) throws ClassNotFoundException, SQLException;
	
}
