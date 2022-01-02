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
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Confirm Booking</title>

    <style>
        body{
            background-color:rgb(252, 250, 250);
        }
        .container{
           
            margin-left: 30%;
            height: 1550px;
        }
        h1{
            text-align: center;
            color: brown;
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            font-weight: bold;
        }
        h2{
            color:rgb(26, 87, 202);
            font-family: 'Gill Sans', 'Gill Sans MT', Calibri, 'Trebuchet MS', sans-serif;
        }
        td{
            font-weight: bold;
            font-family: 'Trebuchet MS', 'Lucida Sans Unicode', 'Lucida Grande', 'Lucida Sans', Arial, sans-serif;
        }
        h3{
            color:darkgreen;
        }
        button{
            width: 200px;
            height: 40px;
            background-color:red;
            color: rgb(252, 250, 250);
            border-radius: 25px;
            font-size: 16px;
            font-weight: bold;
            font-family: Verdana, Geneva, Tahoma, sans-serif;
            border: none;
            margin-left: 350px;
            margin-top: 20px;

        }
    </style>
</head>
<body>
<form action="bookingsus.jsp">

    <h1>Booking Details</h1>
    
   <%  DateTimeFormatter formatter =
		     DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
   
   BookingClass booking =(BookingClass) session.getAttribute("bookingsflight"); 
   
        String hotelId = request.getParameter("hotelid");
        System.out.println(hotelId);
        
            
        double hotelPrice = Double.parseDouble(request.getParameter("hotelprice"));
        
        double totalPrice = booking.getTotalPrice()+hotelPrice;
        System.out.println(totalPrice);
        
        int days = Integer.parseInt(booking.getDaysPlan().substring(0, 1));
    	System.out.println(days);
        
        HotelTableDaoImplement hotelDao = new HotelTableDaoImplement();
        HotelClass hotel = hotelDao.getSingleHotel(Integer.parseInt(hotelId));
       // System.out.println(hotel);
        session.setAttribute("singlehotel", hotel);
        
        UserClass user = (UserClass) session.getAttribute("user");
      //  System.out.println(user);
      System.out.println(user.getWallet());
        
        PackageModeClass packages = (PackageModeClass) session.getAttribute("singlepackages");
      //  System.out.println(packages);
        
        FlightClass flight = (FlightClass) session.getAttribute("singleflight");
       // System.out.println(flight);
        
        double flightFare = Double.parseDouble (request.getParameter("hotelprice"));
       // System.out.println(flightFare);
        
        %>
    
    
    
<div class="container">
    <table cellpadding="10px" cellspacing ="10px">
       <tr>
       <th> <h2>User Details</h2></th>
    </tr>
       <br>
 
            <td>User Name : </td>
            <td><%=user.getName() %></td>
        
        <tr>
            <td>User Emailid : </td>
            <td><%=user.getEmail() %></td>
            
        </tr>
            
                <tr>
                    <th><h2>Package Details</h2></th>
                    </tr>
             <br>
            <td>Tour place : </td>
            <td><%=packages.getName() %></td>
        </tr>
        <tr>
            <td>one Day Night Price / person : </td>
            <td><%=packages.getPriceOneDays() %></td>
        </tr>
        <tr>
            <td>No Of Person : </td>
            <td><%=booking.getNoOfPerson() %></td>
        </tr>
        <tr>
            <td>No Of Days in Night : </td>
            <td><%=booking.getDaysPlan() %></td>
        </tr>
        <tr>
            <td>Tour Start Date : </td>
            <td><%=booking.getStartDate() %></td>
        </tr>
        
        <tr>
           <th> <h2>Flight Details</h2></th>
           </tr>
           <br>
            <td>Flight Name : </td>
            <td><%=flight.getFlightName() %></td>
        </tr>
        <tr>
            <td>depature place : </td>
            <td><%=flight.getDepature() %></td>
        </tr>
        <tr>
            <td>destination place : </td>
            <td><%=flight.getDestination() %></td>
        </tr>
        <tr>
            <td>Depature Date And Time Name : </td>
            <td><%=flight.getDepatureDateTime().format(formatter) %></td>
        </tr>
        <tr>
            <td>Arrival Date And Time Name : </td>
            <td><%=flight.getArrivalDateTime().format(formatter) %></td>
        </tr>
        <tr>
            <td>Class : </td>
            <td><%=booking.getFlightClass() %></td>
        </tr>
        <tr>
            <td>Ticket Price : </td>
            <td><%=flightFare%></td>
        </tr>
        
        <tr>
          <th>  <h2>Hotel Details</h2></th>
          </tr>
            <td>Hotel Name : </td>
            <td><%=hotel.getHotelName() %></td>
        </tr>
        <tr>
      <td>Hotel Location : </td>
         <br>
            <td><%=hotel.getLocation() %></td>
        </tr>
        <tr>
            <td>Room Type : </td>
            <td><%=booking.getHotelRoomType() %></td>
        </tr>
        <tr>
            <td>Hotel One Day Night Price : </td>
            <td><%=hotelPrice %></td>
        </tr>
        <tr>
            <td><h3>Package Total Price</h3> </td>
            <td><h3><%=totalPrice %></h3></td>
        </tr>
    </table>
<button >Confirm Booking</button>


<% 
 // System.out.println(seats);
if (user.getWallet() >=totalPrice ) {
	UserTableDaoImplement userDao = new UserTableDaoImplement();
	BookingTableDaoImplement bookDao = new BookingTableDaoImplement();
	BookingClass bookings = null;
	
	booking = new BookingClass(user.getId(), packages.getPackageId(),
			flight.getFlightNo(), hotel.getHotelId(), booking.getNoOfPerson(),booking.getStartDate(), totalPrice,
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
	wallet = (long) (wallet - totalPrice);
	userDao.addWalletAmount(user.getId(), wallet);
	if (book == true) {
		System.out.println("\n \n successfully booked \n\n" + "get a amazing trip");
	} else {

		System.out.println("\n unable to booking \n please try again");
	}
} 
%>
</div>
</form>
</body>
</html>