package com.servelet;

import java.sql.SQLException;
import java.util.Scanner;

import com.daoimplement.UserTableDaoImplement;
import com.module.UserClass;

public class TestMain {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner (System.in);
		System.out.println("enter your name:");
		String name = sc.next();
		System.out.println("enter your email:");
		String email = sc.next();
		System.out.println("enter your mboile no:");
		long mbo=sc.nextLong();
		System.out.println("enter your password:");
		String psw = sc.next();
		
		UserClass user = new UserClass(name,email,mbo,psw);
		UserTableDaoImplement userDao= new UserTableDaoImplement();
		
		userDao.insertUser(user);

	}

}
