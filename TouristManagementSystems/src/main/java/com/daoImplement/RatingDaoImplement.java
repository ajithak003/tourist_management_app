package com.daoImplement;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import com.connection.ConnectionUtil;
import com.daoInterface.UserFeedbackDaoInterface;
import com.model.BookingClass;
import com.model.UserClass;
import com.model.UserFeedbackClass;

public class RatingDaoImplement implements UserFeedbackDaoInterface {

	@Override
	public boolean insertFeedback(UserFeedbackClass Feedback) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
		Connection con = null;
		PreparedStatement pstmt = null;
		int pstmtvalue = 0;
		String commit = "commit";
		String query = "insert into users_feedback(user_id,booking_id,package_id,rating,describtion) values(?,?,?,?,?)";
		

		try {
			con = ConnectionUtil.getDBConnect();
			
			pstmt = con.prepareStatement(query);

//		String date1=dateFormatMDY.format(employees.getHire());
			pstmt.setInt(1, Feedback.getUserId());
			pstmt.setInt(2, Feedback.getBookingId());
			pstmt.setInt(3, Feedback.getPackageId());
			pstmt.setFloat(4,Feedback.getRating() );
			pstmt.setString(5, Feedback.getDescribtion());
			
			
			//System.out.println(query);
			pstmtvalue = pstmt.executeUpdate();
			
			//System.out.println(user.getEmail());
			pstmt.executeQuery(commit);

			// System.out.println( stmt.executeUpdate()+" Row Instered");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println(e.getMessage());
		} finally {
			ConnectionUtil.closePreparedStatement(pstmt, con);
		}
		return pstmtvalue > 0;
		
	}

	@Override
	public List<UserFeedbackClass> getAllFeedback() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserFeedbackClass getFeedbackByNo(UserFeedbackClass Feedback) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateFeedback(String name, String email, long mobileNo, String password)
			throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteFeedback(UserFeedbackClass Feedback) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public UserFeedbackClass validateFeedback(String emailId, String password)
			throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	
	public boolean endDateCheck(BookingClass booking) {
		Connection con = null;
	    PreparedStatement pstmt =null;		
        String query = "select * from booking_details where booking_id=? and SYSDATE>=?";
        			
		boolean flag = false;
		
				
		try {
			con = ConnectionUtil.getDBConnect();
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, booking.getBookingId());
			//pstmt.setDate(2, new java.sql.Date(Date.valueOf(booking.getEndDate()).getTime()));
			pstmt.setDate(2, java.sql.Date.valueOf(booking.getEndDate()));

		ResultSet rs = pstmt.executeQuery();
		if (rs.next()) {
			
			int result = rs.getInt(1);
			 flag =true;
			
		}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			
			
		} finally {
			ConnectionUtil.closePreparedStatement(pstmt, con);;
		}
		
		
		return flag;
	}

}
