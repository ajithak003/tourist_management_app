package com.controler;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import com.daoImplement.AdminTableDaoImplement;
import com.daoImplement.UserTableDaoImplement;
import com.model.AdminClass;
import com.model.UserClass;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(urlPatterns = {"/register", "/otp"})


public class UserRegister extends HttpServlet {

	Scanner sc = new Scanner(System.in);

	public void doPost(HttpServletRequest req, HttpServletResponse res) {

		try {

			UserTableDaoImplement userDao = new UserTableDaoImplement();
			PrintWriter pw = res.getWriter();

			String name = req.getParameter("FullName");
			System.out.println(name);

			String email = req.getParameter("regemail");
			System.out.println(email);
			email = email.trim().toLowerCase();
			
			// System.out.println(email);

			long mboilNo = Long.parseLong(req.getParameter("regmobile"));
			System.out.println(mboilNo);

			String password = req.getParameter("regpsw");
			System.out.println(password);

			HttpSession session = req.getSession();
			
				boolean verifi = true;
				verifi = userDao.emailvalid(email);

				if (verifi == false) {
					userDao.reRegister(email);
					System.out.println("your accout is activated! \n "
							+ "if you want to change mobile no or password login and update your accout");
					res.sendRedirect("otp.jsp");
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
			if (boo == true) {
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
