package com.ajith.controler;

import java.time.LocalDate;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ajith.daoImplement.BookingTableDaoImplement;
import com.ajith.daoImplement.FlightTableDaoImplement;
import com.ajith.daoImplement.UserTableDaoImplement;
import com.ajith.model.BookingClass;
import com.ajith.model.FlightClass;
import com.ajith.model.UserClass;


//@WebServlet("/cancelbooking")
//public class cancelBooking extends HttpServlet {
//   
//	public void service (HttpServletRequest req, HttpServletResponse res) {
//		
//		HttpSession session = req.getSession();
//		
//		
//	
//		try { 
//			String booking = req.getParameter("bookingid");
//			
//			int bookingId = Integer.parseInt(booking);
//			System.out.println("booking id :"+bookingId);
//			BookingTableDaoImplement cancel = new BookingTableDaoImplement();
//		    BookingClass book = cancel.getSingleBookingById(bookingId);
//		    
//		    UserTableDaoImplement userDao = new UserTableDaoImplement(); 
//		    UserClass  userDetails= (UserClass) session.getAttribute("user");
//		    UserClass user = userDao.getUserById(userDetails);
//			System.out.println(user);
//		
//			if(book.getStatus().equalsIgnoreCase("cancel")) {
//				System.out.println("this package already canceled");
//				session.setAttribute("cancelerror", "Your Booking Already Canceled");
//				session.setAttribute("refunderror", "please wait! Your Payment Refund within 3 working days ");
//				req.getRequestDispatcher("cancelTrip.jsp");
//			}
//			else {
//			
//			double refundPrice =  user.getWallet()+ book.getTotalPrice();
//			refundPrice = (refundPrice/100)*10;
//			
//			FlightTableDaoImplement flightDao = new FlightTableDaoImplement();
//		    FlightClass flight = flightDao.getSingleFlight(book.getFlightNo());
//		    int businessSeats = flight.getBusinessClassSeat() ;
//		    int economicSeats =flight.getEconomicClassSeat();
//		    if(book.getFlightClass().equalsIgnoreCase("business class")) {
//		    	businessSeats += book.getNoOfPerson();
//		    }
//		    else {
//		    	economicSeats += +book.getNoOfPerson();
//		    }
//		    
//			boolean cancelBooking = cancel.updatebooking(user.getId(),book.getStartDate(),refundPrice,businessSeats,economicSeats,book.getFlightNo());
//			
//			
//			if(cancelBooking==true) {
//				
//				System.out.println("successfully canceled");
//				session.setAttribute("cancel", "Cancel Successful");
//				session.setAttribute("refund", "Your Payment Refund within 3 working days ");
//				req.getRequestDispatcher("cancelTrip.jsp");
//			}
//			else {
//				System.out.println("unable to cancel your booking please try again later");
//			}
//			
//			
//			
//			
//			
//		}
//		}catch(Exception e) {
//			System.out.println(e.getMessage());
//		}
//		
//	
//	}		
//	
//}
