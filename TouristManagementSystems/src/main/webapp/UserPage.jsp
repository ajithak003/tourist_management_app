<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>user Page</title>

<script>
    history.forward();
</script>

    <style>
    *{
    margin: 0;
    padding: 0;
    box-sizing: border-box;
    text-decoration: none;
    font-family: Arial, sans-serif;
    
}
body{
        
    background-image:  url("Assets/home.png.jpg") ;
      background-repeat: no-repeat;
}
h1{
   
    color:rgb(241, 11, 57);
    text-align: center;
    font-weight: bold;
    font-size: 50px;
    font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
   
}
#link{
    width: 100%;
    background: black;
    height: 75px;

}

ul{
   
    list-style: none;
    padding: 0;
    margin: 0;
    float: left;
    position: relative;
    left:50px;
}

ul li{
    float: left;
    margin-top: 10px;
    
     }

ul li a{
    width: 180px;
    color: white;
    display: block;
    text-decoration: none;
    font-size: 20px;text-align: center;
    padding: 10px;
    border-radius: 10px;
    font-family:'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
    font-weight: bold;
    text-align: center;
}
a:hover{
    background: cornsilk;
    color:mediumblue;
}

ul li ul{
    background: #000033;
}


ul li ul li{
    float: none;
    position: relative;
    left: 0px;
}
ul li ul{
   display: none;
   position: relative;
   left: 0px;
}

ul li:hover ul {
    display: block;
    
}

span{
    position: absolute;
    right: 100px;
    color: bisque;
   font-size: 20px;

   top: 30px;
   font-weight: bold;
   font-family: Verdana, Geneva, Tahoma, sans-serif;
}

    
    
    </style>

</head>

<body>

<%  response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");%>

       <h1>Tourist Management</h1><span>welcome
      <% String error=(String)session.getAttribute("welcom");
            if(error!=null) {%>
           <%=session.getAttribute("welcom") %>
           
            <%} %>
       </span>
       <br>

    <div id="link">
        <ul>
            <li><a href="#">Home</a></li>
            <li ><a href="papularPlaces.jsp">Book Package</a></li>
            <li><a href="papularPlaces.jsp">Popular Places</a>
            </li>
            <li ><a href="showAllBooking.jsp">My Booking</a></li>
            <li ><a >More</a>
            <ul>
           <li> <a href="profile.jsp">Profile</a></li>
           <li><a href="wallet.jsp"> Wallet Topup</a><li>
           
            </ul>
            </li>
            <li><a href ="userRating.jsp">Ratings</a></li>
            <li><a href="logout.jsp">Logout</a></li>
        </ul>
    </div>

   
   <br><br>
   
    

</body>

</html>