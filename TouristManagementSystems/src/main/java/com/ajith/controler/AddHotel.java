package com.ajith.controler;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ajith.daoImplement.HotelTableDaoImplement;
import com.ajith.model.HotelClass;


@WebServlet(urlPatterns = "/addhotel")
public class AddHotel extends HttpServlet {

	
	public void service(HttpServletRequest req, HttpServletResponse res)  {
		try {
			HotelTableDaoImplement hotelDao = new HotelTableDaoImplement();
		
		String hotelname = req.getParameter("hotelname");
		System.out.println(hotelname);
		
		String hotelLocation = req.getParameter("hotellocation");
		System.out.println(hotelLocation);
		
	   double normalRoom = Double.parseDouble(req.getParameter("standardprice"));
		System.out.println(normalRoom);
		
		double premiumRoom = Double.parseDouble (req.getParameter("premiumprice"));
		System.out.println(premiumRoom);
		
		String image = req.getParameter("hotelimage");
		
		HotelClass hotel = new HotelClass(hotelname,hotelLocation,normalRoom,premiumRoom,image);
		//System.out.println(hotelDao);
		boolean hotels = hotelDao.insertHotel(hotel);
		
		HttpSession session = req.getSession();
		if(hotels==true) {
			System.out.println("insert success");
			req.getRequestDispatcher("addHotel.jsp").forward(req,res);
			session.setAttribute("addHotel", "true");
		}
		else {
			System.out.println("insert invalid");
			session.setAttribute("addHotel", "false");
		}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
}
