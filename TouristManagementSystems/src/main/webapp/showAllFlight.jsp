<%@page import="java.util.List"%>
<%@page import="com.ajith.model.FlightClass"%>
<%@page import="com.ajith.daoImplement.FlightTableDaoImplement"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

    
    <!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title></title>

<style>
    table{
        border: 2px solid;
        border-collapse: collapse;
        background-color: silver;
    }
    tr,td,th{
        border: 1px solid;
        border-collapse: collapse;
        text-align: center;
        padding: 10px;
    }
    a{
        text-decoration: none;
    }
    h1{
        text-align: center;
        font-size: 50px;
        color:steelblue

    }
</style>

</head>
<body>

    <h1>Show All Flight</h1>
    <br><br>
    <table cellpading="30px" cellspacing="30px"    >
        <th>Flight No</th>
        <th>Flight Name</th>
        <th>Depature</th>
        <th>Destination</th>
        <th>Depature Date And Time</th>
        <th>Arrival Date And Time</th>
        <th>Business Class Fare</th>
        <th>Economic Class Fare</th>
        <th>Status</th>
        <th>Business Class Seats Status</th>
        <th>Economic Class Seat Status</th>
        <th></th>
        <th></th>
        
<%          
      String data=(String)session.getAttribute("updateflight");

      if(data.equals("true")){%>
      <script type="text/javascript">
      alert("successfully updated");
      <% } else if(data.equals("false")){ %>
      alert("can't be updated");
      
   <%  } session.setAttribute("updateflight", "none");%>
   
</script>


<%

       FlightTableDaoImplement flightDao = new FlightTableDaoImplement();
       List<FlightClass> flight = flightDao.getAllFlight();
       
       for(int i =0; i<flight.size(); i++){
    	   
    	   FlightClass singleFlight =flight.get(i);
     %>
        
        
        <tr>
            <td><%=singleFlight.getFlightNo() %></td>
            <td><%=singleFlight.getFlightName() %></td>
            <td><%=singleFlight.getDepature() %></td>
            <td><%=singleFlight.getDestination() %></td>
            <td><%=singleFlight.getDepatureDateTime() %></td>
            <td><%=singleFlight.getArrivalDateTime() %></td>
            <td><%=singleFlight.getBusinessClassFare() %></td>
            <td><%=singleFlight.getEconomicClassFare() %></td>
            <td><%=singleFlight.getStatus() %></td>
            <td><%=singleFlight.getBusinessClassSeat() %></td>
            <td><%=singleFlight.getEconomicClassSeat() %></td>
            <td><a href="updateFlight.jsp?flightno=<%=singleFlight.getFlightNo() %>">Edit</a></td>
            <td><a href="#">Delete</a></td>
        </tr>
        <%} %>
    </table>
</body>
</html>