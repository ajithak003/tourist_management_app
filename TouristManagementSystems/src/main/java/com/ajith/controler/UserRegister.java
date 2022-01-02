package com.ajith.controler;

import java.io.IOException;
import java.util.Scanner;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ajith.daoImplement.UserTableDaoImplement;
import com.ajith.model.UserClass;




@WebServlet(urlPatterns = {"/register", "/otp"})


public class UserRegister extends HttpServlet {

	Scanner sc = new Scanner(System.in);

	public void service(HttpServletRequest req, HttpServletResponse res) {

		try {

			UserTableDaoImplement userDao = new UserTableDaoImplement();
			

			String name = req.getParameter("FullName");
		//	System.out.println(name);

			String email = req.getParameter("regemail");
			//System.out.println(email);
			email = email.trim().toLowerCase();
			
			// System.out.println(email);

			long mboilNo = Long.parseLong(req.getParameter("regmobile"));
			//System.out.println(mboilNo);

			String password = req.getParameter("regpsw");
			//System.out.println(password);

			HttpSession session = req.getSession();
			
				boolean verifi = true;
				verifi = userDao.emailvalid(email);

				if (verifi == false) {
					userDao.reRegister(email);
					System.out.println("your accout is activated! \n "
							+ "if you want to change mobile no or password login and update your accout");
					//res.sendRedirect("otp.jsp");
					session.setAttribute("error", "your accout is activated! \n "
							+ "if you want to change mobile no or password login and update your accout");
					req.getRequestDispatcher("otp.jsp");
					
					//res.sendRedirect("login.jsp");

				}
			else {
				System.out.println("enter a correct otp");
				
			UserClass userinsert = new UserClass(name, email, mboilNo, password);
			System.out.println(userinsert);
			boolean boo = userDao.insertUser(userinsert);
			if (boo) {
				System.out.println("Successfully Register");
				res.sendRedirect("otp.jsp");
				session.setAttribute("success", "Successfully Register");
				req.getRequestDispatcher("otp.jsp");
				
				
			}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
