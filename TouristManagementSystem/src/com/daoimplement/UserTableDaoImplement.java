package com.daoimplement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.connection.*;
import com.daoInterface.UserDaoInterface;
import com.connection.*;
import com.module.UserClass;

public class UserTableDaoImplement implements UserDaoInterface{

	@Override
	public void insertUser(UserClass user) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
		DateFormat dateFormatMDY = new SimpleDateFormat("dd-MM-yyyy");
		Connection con=ConnectionUtil.getDBConnect();
		String query="insert into users_table(name,email_id,mobile_no,password) values(?,?,?,?)";
		
		PreparedStatement stmt=con.prepareStatement(query);
//		String date1=dateFormatMDY.format(employees.getHire());
		stmt.setString(1,user.getName());
		stmt.setString(2,user.getEmail() );
		stmt.setLong(3, user.getMboNo());
		stmt.setString(4,user.getPassword() );
			
		System.out.println(stmt.executeUpdate()+" Row Instered");

		
	}
		
	

	@Override
	public List<UserClass> getAllUser() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void getUserById(UserClass user) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateuser(UserClass user) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteuser(UserClass user) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void validateUser(UserClass user) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
	}

	
	
                    
	
}
