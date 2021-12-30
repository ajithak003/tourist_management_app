<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>AdminPage</title>

    <link rel="stylesheet" href="userPage.css">
  
    
</head>
<body>
  <h1 >Tourist Management</h1><span>welcome
  <% String error=(String)session.getAttribute("welcom");
            if(error!=null) {%>
           <%=session.getAttribute("welcom") %>
           
            <%} session.removeAttribute("welcom"); %>
  </span>
  <br>
<div id="link" >
<ul>
<li><a href="#">Home</a>
</li>
<li><a href="#" >Popular Places</a></li>
<li ><a href="#" >Package</a>
<ul class="list"> 
  <li><a href="">Add Package</a></li>
  <li><a href="">update package</a></li>
  <li><a href="">delete package</a></li>
  <li><a href="">show all package</a></li>
</ul></li>


<li ><a href="#" >flights</a>
  <ul class="list">
    <li><a href="">Add flight</a></li>
    <li><a href="">update flight</a></li>
    <li><a href="">delete flight</a></li>
    <li><a href="">show all flight</a></li>
  </ul></li>
  <li></li>
  <li><a href="">Hotels</a>
    <ul class="list">
    <li><a href="">Add hotel</a></li>
    <li><a href="">update hotel</a></li>
    <li><a href="">delete hotel</a></li>
    <li><a href="">show all hotel</a></li>
  </ul>
  </li>
  <li ><a href="#" >More</a>
    <ul class="list">
      <li><a href="">View User List</a></li>
      <li><a href="">view all booking</a></li>
      <li><a href="">view all feedback</a></li>
    </ul></li>
<li><a href="index.html" >Logout</a></li>

</ul>



</div>

    
</body>
</html>