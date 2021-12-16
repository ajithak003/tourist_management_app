package com.servelet;

import java.sql.SQLException;

import java.util.List;
import java.util.Scanner;

import com.daoImplement.*;
import com.module.AdminClass;
import com.module.UserClass;

public class TestMain {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		boolean flag = false;
		do {
			System.out.println("enter your choice \n 1.user register \n 2.login \n Home page");

			String temChoice = sc.nextLine();
			if (String.valueOf(temChoice).matches("[1-3]")) {
				int choice = Integer.parseInt(temChoice);
				flag = true;

				// UserTableDaoImplement userDao=new UserTableDaoImplement()
				UserTableDaoImplement userDao = null;
				AdminTableDaoImplement adminDao = null;
				try {

					switch (choice) {
					case 1:

						userDao = new UserTableDaoImplement();
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
//							if(userDao.emailvalid(email)==false){
//								System.out.println("this Email id already registered");
//							}
							if (email.matches("[A-Za-z][A-Za-z0-9]+[@][a-zA-Z]+[.][A-Za-z]{2,3}")) {

								flagemail = true;

								email = email.trim().toLowerCase();
								verifi = userDao.emailvalid(email);
								if (verifi == false) {
									System.out.println("this Email id already registered");
								}

								// System.out.println(email);
							} else {
								System.out.println("please enter correct email format like xyz23@gmail.com");
							}
							if (flagemail == verifi) {
								flagemail = false;

							}
							// System.out.println(flagemail);
						} while (flagemail);
						long mbo = 0;
						boolean flagmbo = false;
						do {
							System.out.println("enter the mobile no: ");
							String temmbo = sc.nextLine();

							if (temmbo.matches("[6-9][0-9]{9}")) {
								mbo = Long.parseLong(temChoice);
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
						// System.out.println(name);
						UserClass userinsert = new UserClass(name, email, mbo, psw);
						boolean boo = userDao.insertUser(userinsert);
						if (boo == true) {
							System.out.println("Successfully Register");
						}

					case 2:

						adminDao = new AdminTableDaoImplement();
						userDao = new UserTableDaoImplement();

						System.out.println("Login Page");
						boolean login = false;
						do {

							String emailId;
							boolean flagemailId = true;
							do {
								System.out.println("enter the email id: ");
								emailId = sc.nextLine();

								if (emailId.matches("[a-zA-z][A-Za-z0-9]+[@][a-zA-Z]+[.][A-Za-z]{2,3}")) {
									flagemailId = false;
									emailId = emailId.trim().toLowerCase();

									// System.out.println(email);
								} else {
									System.out.println("please enter correct email format like xyz23@gmail.com");
								}
							} while (flagemailId);

							if (emailId.endsWith("@admin.com")) {

								String password = null;
								boolean flagpassword = false;
								do {
									System.out.println("password must hava 8 to 15 characters only \n"
											+ "atleast one upper case \n" + "atleast one lower case \n"
											+ "atleast one number  \n" + "atleast one special character \n\n");
									System.out.println("enter the Admin password: ");
									password = sc.nextLine();
									if (password.matches(
											"^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,15}$")) {
										flagpassword = true;
										// System.out.println(password);
									} else {
										System.out.println("please enter password given pattern only\n");
									}

								} while (!flagpassword);

								AdminClass admin = adminDao.validateUser(emailId, password);
								if (admin == null) {
									System.out.println("user name and password mismatch");
									login = true;
								} else if (admin != null) {
									System.out.println("Welcom " + admin.getName());

									boolean flagadmin = true;
									do {
										System.out.println("choose your choice \n 1.show all user 2.logout");

										String temChoiceadmin = sc.nextLine();
										if (String.valueOf(temChoiceadmin).matches("[1-2]")) {
											int choiceadmin = Integer.parseInt(temChoiceadmin);
											flagadmin = false;

											switch (choiceadmin) {
											case 1:

												UserClass usershowall = new UserClass();

												List<UserClass> user = userDao.getAllUser();
												// System.out.println("second");
												for (int i = 0; i < user.size(); i++) {

													System.out.println(user.get(i));

												}

											case 2:

												break;
											}
										} else {
											System.out.println("must be a number");
										}
									} while (flagadmin);

								}
							}

							else {

								String password = null;
								boolean flagpassword = false;
								do {
									System.out.println("password must hava 8 to 15 characters only \n"
											+ "atleast one upper case \n" + "atleast one lower case \n"
											+ "atleast one number  \n" + "atleast one special character \n\n");
									System.out.println("enter the password: ");
									password = sc.nextLine();
									if (password.matches(
											"^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,15}$")) {
										flagpassword = true;
										// System.out.println(password);
									} else {
										System.out.println("please enter password given pattern only \n");
									}

								} while (!flagpassword);

								UserClass user = userDao.validateUser(emailId, password);

								if (user == null) {
									System.out.println("user name and password mismatch");
									login = true;
								} else if (user != null) {
									System.out.println("Welcom " + user.getName());
									login = false;
								}

							}
						} while (login);

					case 3:

						flag = false;

					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());
				}
			} else {
				System.out.println("must be a numbers 1-3 only");
			}
		} while (!flag);

	}

}