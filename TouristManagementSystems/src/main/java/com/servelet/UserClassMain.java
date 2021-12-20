package com.servelet;

import java.util.Scanner;

import com.daoImplement.UserTableDaoImplement;
import com.model.UserClass;

public  class UserClassMain {
	
	
	public void  Update() {
		
		Scanner sc = new Scanner (System.in);
		
		UserClass user = new UserClass();
		UserTableDaoImplement userDao= new UserTableDaoImplement();
		String name = null;
		boolean flagName = true;
		do {
			System.out.println("Enter full Name:");
			name = sc.nextLine();

			if (name.trim().matches("[A-Za-z ]{3,100}")) {
				name = name.trim();
				flagName = false;
			} else {
				System.out.println("name must be have atleast 3 character and not allowed white space");
			}
		} while (flagName);
		String email;
		boolean flagemail = true;
		boolean verifi = false;
		do {
			System.out.println("enter the email: ");
			email = sc.nextLine();
//			if(userDao.emailvalid(email)==false){
//				System.out.println("this Email id already registered");
//			}
			if (email.matches("[A-Za-z][A-Za-z0-9]+[@][a-zA-Z]+[.][A-Za-z]{2,3}")) {

				flagemail = false;

				email = email.trim().toLowerCase();

			} else {
				System.out.println("please enter correct email format like xyz23@gmail.com");
			}
			// System.out.println(flagemail);
		} while (flagemail);
		long mbo = 0;
		boolean flagmbo = false;
		do {
			System.out.println("enter the mobile no: ");
			String temmbo = sc.nextLine();

			if (temmbo.matches("[6-9][0-9]{9}")) {
				mbo = Long.parseLong(temmbo);
				flagmbo = true;
			} else {
				System.out.println(
						"mobile number start with 6-9 and should be contain 10 numbers only not allowed character and space");
			}
		} while (!flagmbo);

		String psw = null;
		boolean flagpsw = false;
		do {
			System.out.println("password must hava 8 to 15 characters only \n"
					+ "atleast one upper case \n" + "atleast one lower case \n"
					+ "atleast one number  \n" + "atleast one special character \n\n");
			System.out.println("enter the password: ");
			psw = sc.nextLine();
			if (psw.matches(
					"^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,15}$")) {
				flagpsw = true;
				// System.out.println(psw);
			} else {
				System.out.println("please enter password given pattern only");
			}

		} while (!flagpsw);
		
		
		boolean update = userDao.updateuser(name, email, mbo, psw);
		if(update==true) {
			System.out.println("update successfully");
		}
		else {
			System.out.println("unable to update your profile");
		}
	}
	
	public void delete(UserClass deleteuser) {
		
		
		
	}
	
	
	

}
