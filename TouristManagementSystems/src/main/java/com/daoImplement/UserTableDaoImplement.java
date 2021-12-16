package com.daoImplement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.connection.ConnectionUtil;
import com.daoInterface.UserDaoInterface;
import com.module.AdminClass;
import com.module.UserClass;

public class UserTableDaoImplement implements UserDaoInterface {

	@Override
	public boolean insertUser(UserClass user) {
		// TODO Auto-generated method stub
//		DateFormat dateFormatMDY = new SimpleDateFormat("dd-MM-yyyy");
		Connection con = ConnectionUtil.getDBConnect();
		PreparedStatement pstmt = null;
		int pstmtvalue = 0;
		String commit = "commit";
		String query = "insert into users_table(name,email_id,mobile_no,password) values(?,?,?,?)";

		try {
			pstmt = con.prepareStatement(query);

//		String date1=dateFormatMDY.format(employees.getHire());
			pstmt.setString(1, user.getName());
			pstmt.setString(2, user.getEmail());
			pstmt.setLong(3, user.getMboNo());
			pstmt.setString(4, user.getPassword());

			pstmtvalue = pstmt.executeUpdate();
			//System.out.println(user.getEmail());
			pstmt.executeQuery(commit);

			// System.out.println( stmt.executeUpdate()+" Row Instered");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pstmtvalue > 0;

	}

	

	@Override
	public void getUserById(UserClass user) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateuser(UserClass user) {

		Connection con = ConnectionUtil.getDBConnect();
		String query = "update users_table set name=?,mobile_no=?,password=? where email_id='" + user.getEmail() + "'";
		System.out.println(query);
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(query);

//		String date1=dateFormatMDY.format(employees.getHire());
			pstmt.setString(1, user.getName());
			// stmt.setString(2,user.getEmail() );
			pstmt.setLong(2, user.getMboNo());
			pstmt.setString(3, user.getPassword());

			System.out.println(pstmt.executeUpdate() + " updated");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void deleteuser(UserClass user) {
		// TODO Auto-generated method stub

	}
	
	@Override
	public List<UserClass> getAllUser() {

		// TODO Auto-generated method stub
		List<UserClass> userList = new ArrayList<UserClass>();
		Connection con = ConnectionUtil.getDBConnect();
		//System.out.println("connection");
		String query = "select * from users_table";

		Statement stmt;
		try {
			stmt = con.createStatement();
		
		ResultSet rs = stmt.executeQuery(query);
		
		while (rs.next()) {

			UserClass user = new UserClass(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getLong(4), rs.getString(5));

			userList.add(user);
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userList;
	}



	public UserClass validateUser(String emailId, String password) {
		// TODO Auto-generated method stub

		String validateQuery = "select * from users_table where email_id='"+emailId+"' and password='"+password+"'";
		Connection con = ConnectionUtil.getDBConnect();
		//System.out.println(validateQuery);
		UserClass UserClass=null;
		
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(validateQuery);
			if (rs.next()) {

             UserClass=new UserClass(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getLong(4),rs.getString(5));
				
				//System.out.println("login successful");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Statement error");
		}

		return UserClass;

	}
	
	public boolean emailvalid(String emailverifi) {
		Connection con = ConnectionUtil.getDBConnect();
		UserClass UserClass=null;
		String query = "select email_id from users_table where email_id='"+emailverifi+"'";
		
		boolean flag = true;
		
		 
		Statement stmt;
		try {
			stmt = con.createStatement();
		
		ResultSet rs = stmt.executeQuery(query);
		if (rs.next()) {
			
			 UserClass=new UserClass(rs.getString(1));
			 flag =false;
			
		}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return flag;
	}

	
}
