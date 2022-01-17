package com.ajith.daoImplement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.ajith.connection.ConnectionUtil;
import com.ajith.daoInterface.AdminDaoInterface;
import com.ajith.model.AdminClass;
import com.ajith.model.UserClass;

public class AdminTableDaoImplement implements AdminDaoInterface {

	
	@Override
	public AdminClass validateAdmin(String emailId, String password)  {
		// TODO Auto-generated method stub
		String validateQuery = "select * from admin_details where email_id='"+emailId+"' and password='"+password+"'";
		Connection con = ConnectionUtil.getDBConnect();
		//System.out.println(validateQuery);
		AdminClass AdminClass=null;
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(validateQuery);
			if (rs.next()) {
				//System.out.println(rs.getString(2));
				AdminClass=new AdminClass(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getLong(4),rs.getString(5));
				
				//System.out.println("login successful");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Statement error");
		}

		return AdminClass;
		
		
	}

	

	public UserClass getUserById(int userId) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstmt = null;
		UserClass userById=null;
		
			String query ="select * from user_details where user_id ="+userId;
			System.out.println(query);

		try {
		 con = ConnectionUtil.getDBConnect();
		 pstmt = con.prepareStatement(query);
		 
		
		 
		 ResultSet rs = pstmt.executeQuery(query);
		
		 
		 if (rs.next()) {

			 userById=new UserClass(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getLong(4),rs.getString(5),rs.getLong(6));
				
			}} catch (SQLException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				System.out.println(e.getMessage());
			} finally {
				ConnectionUtil.closePreparedStatement(pstmt, con);
			}
		 return userById;

	}

	

}
