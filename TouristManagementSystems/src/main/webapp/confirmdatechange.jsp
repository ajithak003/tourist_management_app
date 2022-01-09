<%@page import="com.ajith.daoImplement.BookingTableDaoImplement"%>
<%@page import="com.ajith.daoImplement.UserTableDaoImplement"%>
<%@page import="com.ajith.model.UserClass"%>
<%@page import="com.ajith.model.FlightClass"%>
<%@page import="com.ajith.daoImplement.FlightTableDaoImplement"%>
<%@page import="com.ajith.model.BookingClass"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>plan date change</title>
<style>
body{
    background-color:ivory;
}
h1{
    text-align: center;
    margin-top: 20%;
}
h2,a{
     text-align: center;
     text-decoration: none;
}
</style>
</head>
<body>

<% UserClass users = (UserClass) session.getAttribute("user");
   UserTableDaoImplement userDao = new UserTableDaoImplement(); 
   UserClass user = userDao.getUserById(users);
   
   BookingClass booking = (BookingClass) session.getAttribute("datechangebookings");
   
   int singleBookingId =(Integer) session.getAttribute("datechangeid");
   

   int oldFlightbSeat = (Integer) session.getAttribute("oldflightbseats");
   //System.out.print("oldseats b"+oldFlightbSeat);
   int oldFlighteSeat = (Integer) session.getAttribute("oldflighteseats");
  
   
   String flightNoStr = request.getParameter("flightno");
   int flightNo = Integer.parseInt(flightNoStr);
   double flightFare = Double.parseDouble (request.getParameter("price"));
  
   
   double totalPrice = (flightFare*booking.getNoOfPerson()) + booking.getTotalPrice();
   totalPrice = totalPrice + 1000;
   totalPrice = totalPrice - booking.getTotalPrice();
   
   //System.out.println("original "+totalPrice);
   
   FlightTableDaoImplement flightDao = new FlightTableDaoImplement();
   FlightClass flight = flightDao.getSingleFlight(flightNo);
   
   int newFlightbSeat = flight.getBusinessClassSeat();
   int newFlighteSeat = flight.getEconomicClassSeat();
   
   if(booking.getFlightClass().equalsIgnoreCase("business class")){
	   newFlightbSeat = flight.getBusinessClassSeat() - booking.getNoOfPerson();
   }
   else{
	   newFlighteSeat = flight.getEconomicClassSeat() - booking.getNoOfPerson();
   }
   
   
   int days = Integer.parseInt(booking.getDaysPlan().substring(0, 1));
  
   if(user.getWallet()>=totalPrice){
	   
	   double wallet = (user.getWallet()-totalPrice);
	   
	   BookingTableDaoImplement bookingDao = new BookingTableDaoImplement();
	   
	   boolean change = bookingDao.dateChange(booking, wallet, days, newFlightbSeat, newFlighteSeat, oldFlightbSeat, oldFlighteSeat, flight.getFlightNo(), singleBookingId);
	   //System.out.println("query "+singleBookingId);
%>      


<h1>Successfully Change Your Tour Date</h1>
<br>
<h2><a href="UserPage.jsp">Go To Home</a></h2>
<%}
   else {
       session.setAttribute("wallet","low");
		response.sendRedirect("wallet.jsp");
	}

%>
   %>
</body>
</html>