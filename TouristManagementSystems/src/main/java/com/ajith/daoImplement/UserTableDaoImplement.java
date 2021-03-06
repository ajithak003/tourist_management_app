package com.ajith.daoImplement;

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

import com.ajith.connection.ConnectionUtil;
import com.ajith.daoInterface.UserDaoInterface;
import com.ajith.model.AdminClass;
import com.ajith.model.UserClass;

public class UserTableDaoImplement implements UserDaoInterface {

	@Override
	public boolean insertUser(UserClass user) {
		// TODO Auto-generated method stub
//		DateFormat dateFormatMDY = new SimpleDateFormat("dd-MM-yyyy");
		Connection con = null;
		PreparedStatement pstmt = null;
		int pstmtvalue = 0;
		String commit = "commit";
		String query = "insert into user_details(name,email_id,mobile_no,password) values(?,?,?,?)";
		//System.out.println(user.getName());
		

		try {
			con = ConnectionUtil.getDBConnect();
			
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
			//e.printStackTrace();
			System.out.println(e.getMessage());
		} finally {
			ConnectionUtil.closePreparedStatement(pstmt, con);
		}
		return pstmtvalue > 0;

	}

	

	

	@Override
	public boolean updateuser( String name, String email, long mobileNo, String password) {

		Connection con = null;
		int update=0;
		String commit = "commit";
		String query = "update user_details set name=?,mobile_no=?,password=? where email_id=?";
		PreparedStatement pstmt = null;
		try {
			con = ConnectionUtil.getDBConnect();
			pstmt = con.prepareStatement(query);
			

//		String date1=dateFormatMDY.format(employees.getHire());
			UserClass user = new UserClass(name,email,mobileNo,password);
			pstmt.setString(1, user.getName());
			pstmt.setLong(2, user.getMboNo());
			pstmt.setString(3, user.getPassword());
			pstmt.setString(4,user.getEmail() );

		    update = pstmt.executeUpdate();
			 pstmt.executeQuery(commit);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println(e.getMessage());
		} finally {
			ConnectionUtil.closePreparedStatement(pstmt, con);
			
		}
           return update>0;
	}

	@Override
	public boolean deleteuser(UserClass user) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstmt =null;
		int del=0;
		String query = "update user_details set status =? where email_id=?";
		String commit = "commit";
		
		try {
			
			con = ConnectionUtil.getDBConnect();
			pstmt = con.prepareStatement(query);
           
            pstmt.setString(1, "inactive");
            pstmt.setString(2, user.getEmail());
			
            del = pstmt.executeUpdate();
            pstmt.executeUpdate(commit);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println(e.getMessage());
		} finally {
			ConnectionUtil.closePreparedStatement(pstmt, con);
		}
		return del>0;

	}
	
	@Override
	public UserClass getUserById(UserClass user) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstmt = null;
		UserClass userById=null;
		
		
		String query ="select * from user_details where email_id='"+user.getEmail()+"'";
		
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
	
	@Override
	public List<UserClass> getAllUser() {

		// TODO Auto-generated method stub
		List<UserClass> userList = new ArrayList<UserClass>();
		Connection con = null;
		//System.out.println("connection");
		String query = "select * from user_details";

		Statement stmt = null;
		try {
			con = ConnectionUtil.getDBConnect();
			stmt = con.createStatement();
		
		ResultSet rs = stmt.executeQuery(query);
		
		while (rs.next()) {

			UserClass user = new UserClass(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getLong(4), rs.getString(5),rs.getLong(6));
			 
			userList.add(user);
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println(e.getMessage());
		}
		finally {
			ConnectionUtil.closeStatement(stmt, con);
		}

		return userList;
	}



	public UserClass validateUser(String emailId, String password) {
		// TODO Auto-generated method stub

		String validateQuery = "select * from user_details where email_id='"+emailId+"' and password='"+password+"' and status='"+"active"+"'";
		Connection con = null;
		Statement stmt = null;
		//System.out.println(validateQuery);
		UserClass UserClass=null;
		
		try {
			con = ConnectionUtil.getDBConnect();
			 stmt = con.createStatement();
			 
			 
			ResultSet rs = stmt.executeQuery(validateQuery);
			if (rs.next()) {

             UserClass=new UserClass(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getLong(4),rs.getString(5),rs.getLong(6));
				
				//System.out.println("login successful");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("Statement error");
		} finally {
			ConnectionUtil.closeStatement(stmt, con);
		}

		return UserClass;

	}
	
	public boolean emailvalid(String emailverifi) {
		Connection con = null;
		UserClass UserClass=null;
		String query = "select email_id from user_details where email_id='"+emailverifi+"'";
		
		boolean flag = true;
		
		 
		Statement stmt = null;
		try {
			con = ConnectionUtil.getDBConnect();
			stmt = con.createStatement();
		
		ResultSet rs = stmt.executeQuery(query);
		if (rs.next()) {
			
			 UserClass=new UserClass(rs.getString(1));
			 flag =false;
			
		}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println(e.getMessage());
		} finally {
			ConnectionUtil.closeStatement(stmt, con);
		}
		
		
		return flag;
	}
	
	public long showWalletAmount(UserClass user) {
		
		Connection con = null;
		long wallet=0;
		String query = "select wallet from user_details where email_id='"+user.getEmail()+"'";
		//System.out.println(query);
		Statement stmt = null;
		try {
			con = ConnectionUtil.getDBConnect();
			stmt = con.createStatement();
		
		ResultSet rs = stmt.executeQuery(query);
		if (rs.next()) {
			
			 wallet =rs.getLong(1);
			//System.out.println(wallet); 
			
		}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println(e.getMessage());
		} finally {
			ConnectionUtil.closeStatement(stmt, con);
		}
		return wallet;
		
	}
	
	public boolean addWalletAmount(int userId,long amount) {
		
		Connection con = null;
		int wallet=0;
		String query = "update user_details set wallet="+amount+" where user_id="+userId;
		String commit ="commit";
		//System.out.println(query);
		PreparedStatement pstmt = null;
		try {
			con = ConnectionUtil.getDBConnect();
			pstmt = con.prepareStatement(query);
			wallet = pstmt.executeUpdate();
			 pstmt.executeQuery(commit);
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println(e.getMessage());
		} finally {
			ConnectionUtil.closePreparedStatement(pstmt, con);;
		}
		return wallet>0;
		
	}
	
	public UserClass reRegister(String email) {
		Connection con = null;
		PreparedStatement pstmt =null;
		 UserClass user = null;
		int del=0;
		String query = "select * user_details from  where email_id=?";
		String commit = "commit";
		
		try {
			
			con = ConnectionUtil.getDBConnect();
			pstmt = con.prepareStatement(query);
           
           
            pstmt.setString(1, email);
			
            ResultSet rs = pstmt.executeQuery(query);
    		
   		 
   		 if (rs.next()) {

   			user = new UserClass(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getLong(4),rs.getString(5),rs.getLong(6));
   				
   			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println(e.getMessage());
		} finally {
			ConnectionUtil.closePreparedStatement(pstmt, con);
		}
		return user;

	}
	
	public UserClass getSingleUserById(int userId) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstmt = null;
		UserClass userById=null;
		
		
		String query ="select * from user_details where user_id='"+userId+"'";
		
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
