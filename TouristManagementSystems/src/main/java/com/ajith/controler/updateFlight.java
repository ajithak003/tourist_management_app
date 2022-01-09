package com.ajith.controler;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ajith.daoImplement.FlightTableDaoImplement;
import com.ajith.daoImplement.PackageModeClassDaoImplement;
import com.ajith.daoImplement.UserTableDaoImplement;
import com.ajith.model.FlightClass;
import com.ajith.model.UserClass;


@WebServlet(urlPatterns = "/updateflight")
public class updateFlight extends HttpServlet {
	
	public void service(HttpServletRequest req, HttpServletResponse res)  {
		try {
			
			DateTimeFormatter formatter =
		            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		PackageModeClassDaoImplement packageDao = new PackageModeClassDaoImplement();
		
		String flightName = req.getParameter("flightname");
		//System.out.println(flightName);
		
		String depature = req.getParameter("Depature");
		//System.out.println(depature);
		
		String destination = req.getParameter("destination");
		//System.out.println(destination);
		
		String depatureDate = req.getParameter("DepatureDate");
		LocalDateTime depatureTimeDate = LocalDateTime.parse(depatureDate);
		//System.out.println(depatureTimeDate);
		
		String ArrivalDate = req.getParameter("ArrivalDate");
		LocalDateTime arrivalTimeDate = LocalDateTime.parse(ArrivalDate);
		//System.out.println(arrivalTimeDate);
		
		double businessClassFare = Double.parseDouble(req.getParameter("businessclassfare"));
		//System.out.println(businessClassFare);
		
		double economicClassFare = Double.parseDouble(req.getParameter("economicclassfare"));
		//System.out.println(economicClassFare);
		
		String status = req.getParameter("status");
		//System.out.println(status);
		
		int businessClassSeat = Integer.parseInt(req.getParameter("businessclassseat"));
		//System.out.println(businessClassSeat);
		
		int economicClassSeat = Integer.parseInt(req.getParameter("economicclassseat"));
		//System.out.println(economicClassSeat);
		
		int flightno = Integer.parseInt(req.getParameter("flightno"));
		//System.out.println(flightno);
		
		FlightTableDaoImplement flightDao = new FlightTableDaoImplement();
		FlightClass flight = new FlightClass(flightno,flightName,depature, destination, depatureTimeDate, arrivalTimeDate,
				businessClassFare, economicClassFare,status,businessClassSeat,economicClassSeat);
		 
		//System.out.println(flight);
		
		boolean flights = flightDao.updateFlight(flight);
		
		HttpSession session = req.getSession();
		if(flights==true) {
			//System.out.println("update success");
			session.setAttribute("updateflight", "true");
			req.getRequestDispatcher("showAllFlight.jsp").forward(req,res);
			
		}
		else {
			//System.out.println("insert invalid");
			session.setAttribute("updateflight", "false");
		}
			req.getRequestDispatcher("showAllFlight.jsp").forward(req,res);
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
}
