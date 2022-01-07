package com.ajith.controler;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ajith.daoImplement.BookingTableDaoImplement;
import com.ajith.daoImplement.RatingDaoImplement;
import com.ajith.model.BookingClass;
import com.ajith.model.UserClass;
import com.ajith.model.UserFeedbackClass;


@WebServlet("/rating")
public class rating extends HttpServlet {

	public void service(HttpServletRequest req, HttpServletResponse res) {
		
		
		try{
			
			HttpSession session = req.getSession();
			UserClass user = (UserClass) session.getAttribute("user");
			System.out.println(user);
			RatingDaoImplement ratingDao = new RatingDaoImplement();
			
			int bookingId = Integer.parseInt(req.getParameter("bookingId"));
			System.out.println(bookingId);
			
			BookingTableDaoImplement bookingDao = new BookingTableDaoImplement();
			BookingClass booking = bookingDao.getSingleBookingById(bookingId);
			
			float rating = Float.parseFloat(req.getParameter("rate"));
			System.out.println(rating);
			
			String describrion = req.getParameter("describe");
			
			UserFeedbackClass userRating = new UserFeedbackClass(bookingId,user.getId(),booking.getPackageIid(),user.getName(),booking.getPackageName(),rating,describrion);
			boolean rate  = ratingDao.insertFeedback(userRating);
			
			if(rate==true) {
				System.out.println("successfully rated");
				session.setAttribute("rating", "true");
				req.getRequestDispatcher("showAllRating.jsp");
			}
			else {
				System.out.println("invalid");
				session.setAttribute("rating", "true");
				req.getRequestDispatcher("showAllRating.jsp");
			}
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	
}
