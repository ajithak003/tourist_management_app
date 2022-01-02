package com.ajith.daoImplement;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.ajith.connection.ConnectionUtil;
import com.ajith.daoInterface.UserFeedbackDaoInterface;
import com.ajith.model.BookingClass;
import com.ajith.model.HotelClass;
import com.ajith.model.UserClass;
import com.ajith.model.UserFeedbackClass;

public class RatingDaoImplement implements UserFeedbackDaoInterface {

	@Override
	public boolean insertFeedback(UserFeedbackClass Feedback) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
		Connection con = null;
		PreparedStatement pstmt = null;
		int pstmtvalue = 0;
		String commit = "commit";
		String query = "insert into users_feedback(user_id,booking_id,package_id,user_name,package_name,rating,describtion) values(?,?,?,?,?,?,?)";
		

		try {
			con = ConnectionUtil.getDBConnect();
			
			pstmt = con.prepareStatement(query);

//		String date1=dateFormatMDY.format(employees.getHire());
			pstmt.setInt(1, Feedback.getUserId());
			pstmt.setInt(2, Feedback.getBookingId());
			pstmt.setInt(3, Feedback.getPackageId());
			pstmt.setString(4, Feedback.getUserName());
			pstmt.setString(5, Feedback.getPackageName());
			pstmt.setFloat(6,Feedback.getRating() );
			pstmt.setString(7, Feedback.getDescribtion());
			
			
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
		Connection con = null;
		Statement stmt = null;
		
		
		UserFeedbackClass rating= null;
		
		List<UserFeedbackClass> ratings = new ArrayList<UserFeedbackClass>();

		String query = "select * from users_feedback";
		
		try {
			con = ConnectionUtil.getDBConnect();
			
			 stmt =con.createStatement();
			
			 ResultSet rs = stmt.executeQuery(query);
			
			while(rs.next()) {
				rating = new UserFeedbackClass(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getInt(4), rs.getString(5), rs.getString(6),rs.getFloat(7), rs.getString(8));
				ratings.add(rating);
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println(e.getMessage());
		} finally {
			ConnectionUtil.closeStatement(stmt, con);
		}
		
		return ratings;
		
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
