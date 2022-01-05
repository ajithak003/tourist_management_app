<%@page import="java.text.Format"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.ajith.model.FlightClass"%>
<%@page import="com.ajith.model.HotelClass"%>
<%@page import="com.ajith.daoImplement.HotelTableDaoImplement"%>
<%@page import="com.ajith.daoImplement.FlightTableDaoImplement"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="com.ajith.model.BookingClass"%>
<%@page import="java.util.List"%>
<%@page import="com.ajith.daoImplement.BookingTableDaoImplement"%>
<%@page import="com.ajith.model.UserClass"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

    <!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Show all bookings</title>

<style>
  
    body{
        background-color: rgb(229, 236, 236);
       
    }
    h1{
        text-align: center;
        font-size: 40px;
        font-family:'Gill Sans', 'Gill Sans MT', Calibri, 'Trebuchet MS', sans-serif;
        font-weight: bold;
        color: red;
    }
    .box{
        border: 3px solid;
        height: 460px;
        width: 750px;
        margin-left: 290px; 
        border-radius: 20px;
    }
    
    .title{
        margin-left: 220px;
        font-size: 30px;
        font-family:'Gill Sans', 'Gill Sans MT', Calibri, 'Trebuchet MS', sans-serif;
        font-weight: bold;
        color:black;
        margin-top: -20px;
    }
    .status{
        color: rgb(3, 194, 3);
        font-size: 20px;
        font-family: 'Times New Roman', Times, serif;
        float: right;
        position: relative;
        right: 100px;
        top: -100px;
    }
    .textdate{
        font-size: 20px;
        font-family: Cambria, Cochin, Georgia, Times, 'Times New Roman', serif;
        margin-left: 20px;
        margin-top: -50px;
        color:blue;
    }
    #dd{
        margin-left: 60px;
        font-family: 'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif;
        font-size: 40px;
        font-weight: bold;
        margin-top: -20px;
        color: darkgoldenrod;
    }
    #mm{
        margin-left: 55px ;
        font-size: 30px;
        margin-top: -30px;
        color: red;
    }
    #yyyy{
        margin-left: 50px;
        font-size: 30px;
        font-family: 'Gill Sans', 'Gill Sans MT', Calibri, 'Trebuchet MS', sans-serif;
        margin-top: -20px;
        color:green;
    }
    .location{
        margin-left: 180px;
        margin-top: -160px;
        font-size: 30px;
        font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        color:darkred;
    }
    .hotel{
        margin-left: 200px;
        font-size: 20px;
        
    }
    .price{
        margin-left: 200px;
        font-size: 20px;
        
    }
    .days{
        margin-left: 200px;
        font-size: 20px;
       color: green;
    }
    .cancel{
        height: 40px;
        width: 120px;
       margin-left: 70px; 
       margin-top: 20px;
       border-radius: 15px;
       background-color: red;
       color: floralwhite;
       font-size: 20px;
       font-weight: bold;
       border: none;
    }
    a{
        text-decoration: none;
        color: floralwhite;
    }
    .datechange{
        height: 40px;
        width: 150px;
        margin-left: 340px;
        border-radius: 15px;
        background-color:midnightblue;
        color: floralwhite;
        font-size: 20px;
        font-weight: bold;
    }


</style>

</head>
<body>
<div class="container"> 
              
        <div>
              <h1 >My Trips</h1>
              <br><br>

<%   
     DateTimeFormatter month = DateTimeFormatter.ofPattern("MMM");
    UserClass user = (UserClass) session.getAttribute("user");
    BookingTableDaoImplement bookingDao = new BookingTableDaoImplement();
    List<BookingClass> booking = bookingDao.getAllbooking(user);
    
    for(int i=0; i<booking.size(); i++){
    	
    	BookingClass singlebooking = booking.get(i);
    	
    	FlightTableDaoImplement flightDao = new FlightTableDaoImplement();
    	FlightClass flight = flightDao.getSingleFlight(singlebooking.getFlightNo());
    	
    	HotelTableDaoImplement hotelDao = new HotelTableDaoImplement();
        HotelClass hotel = hotelDao.getSingleHotel(singlebooking.getHotelId());
%>
    <form action="showallbooking">
       
               <div class="box">
                <div class="title">
                    <h2 ><%=singlebooking.getPackageName() %> Trip</h2>
                </div>   
                <div class="status">
                    <h3><%=singlebooking.getStatus() %></h3>
                </div>
                <div class="textdate">
                    <h2>Start Date</h2>
                </div>
               <div class="date">
                <h2 id="dd"><%=singlebooking.getStartDate().getDayOfMonth() %></h2>
                    <h2 id="mm"><%=singlebooking.getStartDate().format(month) %></h2>
                    <h2 id="yyyy"><%=singlebooking.getStartDate().getYear()%></h2>
               </div>
               
                <div class="location">
                    <h2><%=flight.getDepature() %>  - <%=flight.getDestination() %></h2>
                </div>
               <div class="hotel">
                 
                 <h2>Hotel Name : <span><%=hotel.getHotelName() %></span></h2>
               </div>
                <div class="price">
                   
                    <h2>No Of Days : <span><%=singlebooking.getDaysPlan()%><span></h2>
                </div>
                <div class="days">
                   <h2>Total price  &nbsp;: <span><%=singlebooking.getTotalPrice() %></span></h2>
                </div>
            </table>
           
            <div >
            
                 <button class="cancel"  ><a href="cancelTrip.jsp?bookingid=<%=singlebooking.getBookingId()%>"> Cancel</a></button>
                <button class="datechange"><a href="terms.jsp?bookingid=<%=singlebooking.getBookingId() %>">Change Date</a></button>
            </div>
        </div>
           <br><br>
       <%} %> 
       </form>
       </div>


</body>
</html>