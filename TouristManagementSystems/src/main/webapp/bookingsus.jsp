<%@page import="com.ajith.daoImplement.UserTableDaoImplement"%>
<%@page import="com.ajith.daoImplement.BookingTableDaoImplement"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="com.ajith.model.FlightClass"%>
<%@page import="com.ajith.model.PackageModeClass"%>
<%@page import="com.ajith.model.UserClass"%>
<%@page import="com.ajith.model.HotelClass"%>
<%@page import="com.ajith.daoImplement.HotelTableDaoImplement"%>
<%@page import="com.ajith.model.BookingClass"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<% 
UserClass user = (UserClass) session.getAttribute("user");
BookingClass booking = (BookingClass) session.getAttribute("confirmbooking");
FlightClass flight = (FlightClass) session.getAttribute("singleflight");

int days = Integer.parseInt(booking.getDaysPlan().substring(0, 1));
System.out.println(days);

  System.out.println(user.getWallet() );
  
  
if (user.getWallet() >=booking.getTotalPrice() ) {
	UserTableDaoImplement userDao = new UserTableDaoImplement();
	BookingTableDaoImplement bookDao = new BookingTableDaoImplement();
	BookingClass bookings = null;
	
	BookingClass confirmBooking = new BookingClass(user.getId(), booking.getPackageIid(),
			booking.getFlightNo(), booking.getHotelId(), booking.getNoOfPerson(),booking.getStartDate(), booking.getTotalPrice(),
			booking.getFlightClass(),booking.getHotelRoomType(),booking.getDaysPlan(),booking.getPackageName());
	System.out.println(booking.toString1(booking));
	  int businessClassSeats = 0;
	  int economicClassSeats = 0;
	  if(booking.getFlightClass().equalsIgnoreCase("business class")){
		  businessClassSeats = flight.getBusinessClassSeat() - booking.getNoOfPerson();
	  }
	  else{
		  economicClassSeats= flight.getEconomicClassSeat() - booking.getNoOfPerson();
	  }
	
	boolean book = bookDao.insertbooking(booking, days,businessClassSeats,economicClassSeats);

	long wallet = userDao.showWalletAmount(user);
	wallet = (long) (wallet - booking.getTotalPrice());
	userDao.addWalletAmount(user.getId(), wallet);
	if (book == true) {
		System.out.println("\n \n successfully booked \n\n" + "get a amazing trip");
	}

}

else {
        session.setAttribute("wallet","low");
		response.sendRedirect("wallet.jsp");
	}

%>
        <h1>Booking Successful</h1>
</body>
</html>