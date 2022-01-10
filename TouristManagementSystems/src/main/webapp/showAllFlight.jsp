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
    <title>showAllFlight</title>

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
<%          
      String data=(String)session.getAttribute("updateflight");

       if(data.equals("true")){%>
         <script type="text/javascript">
         alert("successfully updated");
         
         </script>
         <%} 
     else if(data.equals("false")){ %>
     <script type="text/javascript">
     alert("can't be updated");
     </script> 
  <%  } else if(data.equals("delete")){%>
  <script type="text/javascript">
  alert("successfully deleted");
  </script><%} else if(data.equals("canotdelete")){ %>
  <script>
  alert("can't be deleted");
   </script> 
<%  }%> 

    <h1>Show All Flight</h1>
     <h2><a href="AdminPage.jsp">Go To Home</a></h2>
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
            <td><a href="deleteFlight.jsp?flightno=<%=singleFlight.getFlightNo() %>">Delete</a></td>
        </tr>
        <%
       }%>
    </table>
  <%session.setAttribute("updateflight", null);
  session.removeAttribute("updateflight");%>
   
</body>
</html>