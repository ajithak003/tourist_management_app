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
            <li><a href="#">Home</a></li>
            <li ><a href="papularPlaces.jsp">Book Package</a></li>
            <li><a href="">Popular Places</a>
                <ul>
                <li><a href="#">Kashmir</a>
                <li><a href="#">maldives</a>
                </ul>
            </li>
            <li ><a href="#">My Booking</a></li>
            <li><a href="#">Help</a></li>
            <li><a href="index.html">Logout</a></li>
        </ul>
    </div>

   
   <br><br>
   <div class="search">
       <input type="search" name="" id="">
       <button type="submit">submit</button>
   </div>
    

</body>

</html>