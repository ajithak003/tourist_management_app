<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>user Login</title>

    <link rel="stylesheet" href="userPage.css">


</head>

<body>
       <h1>Tourist Management</h1><span>welcome  
       <% String error=(String)session.getAttribute("welcom");
            if(error!=null) {%>
           <%=session.getAttribute("welcom") %>
           
            <%} session.removeAttribute("welcom"); %>
       </span>
       <br>

    <div id="link">
        <ul>
            <li><a href="index.jsp">Home</a></li>
            <li ><a href="papularPlaces.jsp">Book Package</a></li>
            <li><a href="papularPlaces.jsp">Popular Places</a>
            </li>
            <li >><a href="showAllBooking.jsp">My Booking</a></li>
            <li >><a href="#">More</a>
            <ul>
            <a href="profile.jsp"><li>Profile</li></a>
           <a href="wallet.jsp"> <li>Wallet Topup</li></a>
            </ul>
            </li>
            <li><a href ="showAllRating.jsp">Ratings</a></li>
            <li><a href="index.jsp">Logout</a></li>
        </ul>
    </div>

   
   <br><br>
   
    

</body>

</html>