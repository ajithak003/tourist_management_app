package com.daoImplement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.connection.ConnectionUtil;
import com.daoInterface.AdminDaoInterface;
import com.module.AdminClass;

public class AdminTableDaoImplement implements AdminDaoInterface {

	@Override
	public boolean insertUser(AdminClass user) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<AdminClass> getAllUser() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void getUserById(AdminClass user) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateuser(AdminClass user) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteuser(AdminClass user) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public AdminClass validateUser(String emailId, String password)  {
		// TODO Auto-generated method stub
		String validateQuery = "select * from Admins_table where email_id='"+emailId+"' and password='"+password+"'";
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

	

	

}
