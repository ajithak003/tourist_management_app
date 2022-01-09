package com.ajith.controler;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/logout")
public class Logout extends HttpServlet {

	public void service (HttpServletRequest req,HttpServletResponse res) {
		
		
		//System.out.println("logout");
		
	       req.getSession().invalidate();
	       
	       try {
	    	   
			res.sendRedirect("index.jsp");
			
		} catch (Exception e) {
			
			System.out.println(e.getMessage());
		}
	       
	       
	       
	}
	
}
