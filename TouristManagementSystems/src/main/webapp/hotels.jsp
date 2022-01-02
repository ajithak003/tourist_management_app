<%@page import="com.ajith.daoImplement.FlightTableDaoImplement"%>
<%@page import="com.ajith.model.FlightClass"%>
<%@page import="com.ajith.model.HotelClass"%>
<%@page import="java.util.List"%>
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
    <title>Document</title>
</head>
<style>
    body{
        background-color:rgb(243, 221, 167);
    }
    h1{
        text-align: center;
        font-size: 40px;
        font-family: Verdana, Geneva, Tahoma, sans-serif;
        font-weight: bold;
        color:yellowgreen;
    }
    .container{
        border:3px;
        border-style:solid;
        border-radius: 30px;
        padding: 35px;
        height: 350px;
    }

    img{
        position: relative;
        height: 350px;
        width: 400px;
    }
    .name{
        position: relative;
        margin-left: 450px;
        margin-top: -325px;
    }
    .hotelname{
        position: relative;
        margin-left: 300px;
        margin-top: -37px;
    }
    .location{
        position: relative;
        margin-left: 455px;
        margin-top: 60px;
    }
    .locationname{
        position: relative;
        margin-left: 300px;
        margin-top: -37px;
    }
    
    .radio  {
         position: relative;
         top: 50px;
         margin-left: 450px;
         font-size: 20px;
         font-weight: bold;
        }
   span{
       color:orangered;
   }
   #Premium{
       position: relative;
       left: 50px;
   }
   button{
       position: relative;
       top: 70px;
       margin-left: 1050px;
       height: 50px;
       width: 130px;
       background-color: royalblue;
       border-radius: 50px;
       border:none;
       font-size: 18px;
       color: white;
       font-family: monospace;
       font-weight: bold;
   }
   


</style>
<body>
   <form action="booking.jsp">
        <h1>Hotels</h1>
    <br><br>
    
    <% BookingClass booking =(BookingClass) session.getAttribute("bookings"); 
        String flightNoStr = request.getParameter("flightno");
        int flightNo = Integer.parseInt(flightNoStr);
        
        double flightFare = Double.parseDouble (request.getParameter("price"));
        System.out.println(flightFare);
        
        
        FlightTableDaoImplement flightDao = new FlightTableDaoImplement();
        FlightClass flight = flightDao.getSingleFlight(flightNo);
        session.setAttribute("singleflight", flight);
       // System.out.println(flight);
       double totalPrice = (booking.getTotalPrice()+flightFare) * booking.getNoOfPerson();
       
       System.out.println(totalPrice);
       
        session.setAttribute("flight", flight);
       
        HotelTableDaoImplement hotelDao = new HotelTableDaoImplement();
        List<HotelClass> hotels = hotelDao.getHotelByNo(booking.getPackageName());
        
        String hotelRoomType = null;
        
for (int i = 0; i < hotels.size(); i++) {
			
			
	HotelClass hotel = hotels.get(i);
			
        
    %>
    
    <div class="container">
    <div>
<img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRGnVg5ts-PU7WOv2_i3N2e88vjVnRhAGiNXQ&usqp=CAU" alt="">
<div class="name">
    <h3>Hotel Name : </h3>
    <h3 class="hotelname"><%=hotel.getHotelName()%></h3>
</div>
<div class="location">
    <h3>Location : </h3>
    <h3 class="locationname"> <%=hotel.getHotelName() %></h3>
</div>
<div class="radio">
    <p>
    <%  {
            	
            	 hotelRoomType = "mid range room"; 
            %>
        <input type="radio" name="hotelprice" id="Normal" value="<%=hotel.getMidRangePrice() %>"><label for="">Normal Room <span><%=hotel.getMidRangePrice()%></span></label>
        <%} 
                { 
                	 
                	hotelRoomType = "premimum room";
                %>
        <input type="radio" name="hotelprice" id="Premium" value="<%=hotel.getPremiumPrice() %>"><label for="" id="Premium">Premium Room<span><%=hotel.getPremiumPrice()%></span></label>
       <%} %>
    </p>    
</div>
<button id="button" name= "hotelid" value="<%=hotel.getHotelId() %>">Book hotel</button>
    </div>

    </div>
        <br><br>
    <%}%>
			 <% 
			 
			 
			// System.out.println(totalPrice);
      BookingClass bookings = new  BookingClass( booking.getUserId(),booking.getPackageIid(),booking.getFlightNo(),0,booking.getNoOfPerson(),booking.getStartDate(),totalPrice,booking.getFlightClass(),hotelRoomType,booking.getDaysPlan(),booking.getPackageName()); 
		session.setAttribute("bookingsflight",bookings);
		
		System.out.println("hotelpage "+bookings); %>
		
		</form>
</body>
</html>