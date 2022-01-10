package com.ajith.controler;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ajith.daoImplement.HotelTableDaoImplement;
import com.ajith.exception.UserDefineException;
import com.ajith.model.HotelClass;


@WebServlet(urlPatterns = "/addhotel")
public class AddHotel extends HttpServlet {

	
	public void service(HttpServletRequest req, HttpServletResponse res)  {
		try {
			HotelTableDaoImplement hotelDao = new HotelTableDaoImplement();
		
		String hotelname = req.getParameter("hotelname");
		//System.out.println(hotelname);
		
		String hotelLocation = req.getParameter("hotellocation");
		//System.out.println(hotelLocation);
		
	   double normalRoom = Double.parseDouble(req.getParameter("standardprice"));
		//System.out.println(normalRoom);
		
		double premiumRoom = Double.parseDouble (req.getParameter("premiumprice"));
		//System.out.println(premiumRoom);
		
		String image = req.getParameter("hotelimage");
		
		
		HotelClass hotel = new HotelClass(hotelname,hotelLocation,normalRoom,premiumRoom,image);
		//System.out.println(hotelDao);
		boolean hotels;
		
			hotels = hotelDao.insertHotel(hotel);
		
		HttpSession session = req.getSession();
		if(hotels==true) {
			//System.out.println("insert success");
			
			session.setAttribute("addHotel", "true");
			
			try {
				req.getRequestDispatcher("addHotel.jsp").forward(req,res);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		else {
			//System.out.println("insert invalid");
			throw new UserDefineException();
		}
		} catch (UserDefineException e) {
			// TODO Auto-generated catch block
			HttpSession session = req.getSession();
			//System.out.println("error");
			session.setAttribute("addHotelerror", e.addhotel());
			try {
				res.sendRedirect("addHotel.jsp");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	
	
	}

}
