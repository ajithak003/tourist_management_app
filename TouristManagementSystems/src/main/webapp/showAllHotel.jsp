<%@page import="com.ajith.model.HotelClass"%>
<%@page import="java.util.List"%>
<%@page import="com.ajith.daoImplement.HotelTableDaoImplement"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  
  <!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>ahowAllHotels</title>

<style>
    table{
        border: 2px solid;
        border-collapse: collapse;
        background-color:rgb(235, 206, 194);
        margin-left: 20%;
        
    }
    tr,td,th{
        border: 2px solid;
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
      String data=(String)session.getAttribute("hotel");
       System.out.print(data);
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
  alert("can't be deleted");
   </script> 
<%  }
  session.setAttribute("hotel", "none");%> 
<h2><a href="AdminPage.jsp">Go To Home</a></h2>

    <h1>Show All Hotels</h1>
     
    <br><br>
    
    <table cellpading="30px" cellspacing="30px"    >
        
        <th>Hotel Id</th>
        <th>Hotel Name</th>
        <th>Hotel Location</th>
        <th>Standard Room Price</th>
        <th>Premium Room Price</th>
       
        
        <%  HotelTableDaoImplement hotelDao = new HotelTableDaoImplement();
        List<HotelClass> hotels = hotelDao.getAllHotel();
        
        for(int i =0 ; i<hotels.size(); i++){
        	
        	HotelClass hotel = hotels.get(i);
    %>

        <tr>
            <td><%=hotel.getHotelId() %></td>
            <td><%=hotel.getHotelName() %></td>
            <td><%=hotel.getLocation() %></td>
            <td><%=hotel.getMidRangePrice() %></td>
            <td><%=hotel.getPremiumPrice() %></td>
            <td><a href="updateHotel.jsp?hotelid=<%=hotel.getHotelId() %>">Edit</a></td>
            <td><a href="deleteHotel.jsp?hotelid=<%=hotel.getHotelId() %>">Delete</a></td>
        </tr>
        <%} %>
    </table>
    
</body>
</html>