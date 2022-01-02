<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.sql.ResultSet" %>
<%@page import="com.ajith.daoImplement.PackageModeClassDaoImplement" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>
        <!DOCTYPE html>
        <html lang="en">

        <head>
            <meta charset="UTF-8">
            <meta http-equiv="X-UA-Compatible" content="IE=edge">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <title>Document</title>
            <style>
            *{
  
    margin: 0;
    padding: 0;
    box-sizing: border-box;
    text-decoration: none;
    font-family: Arial, sans-serif;
    
}
body{
        
   background-color:rgb(248, 237, 221);
}


.slideimg {
    position: sticky;
    width: 80%;
    height: 400px;
    left: 10%;
}
.prev{
    position: absolute;
    left: 12%;
    top: 150px;
    font-size: x-large;
}
.next{
    position: absolute;
    left: 86%;
    top: 150px;
    right: 20px;
    font-size: x-large;
}
.next:hover,.prev:hover{
    height: 15x;
    width: 10px;
    background-color: gray;
}
h1{
    position: absolute;
    top: 300px;
    left: 30%;
    background-color:black;
    border-radius: 25%;
    color: white;
}
.firsrrow{
    padding-left: 20%;
}

.firstrowimg{
    
   
     top: 400px;
      width: 300px; 
      height: 350px; 
      border-radius: 10px;

}
.table{
    left: 10px;
}
h2{
    text-align: center;
    font-weight: bold;
    font-size: 35px;
    font-family:Verdana, Geneva, Tahoma, sans-serif;
}
second{
 border: 3px solid;

}

            </style>
        </head>

<body>

    

<div class="second">
    <table cellspacing="30px" cellpadding ="1000px" class="table">

       <%
     PackageModeClassDaoImplement packageDao = new PackageModeClassDaoImplement();
		ResultSet rs = packageDao.getAllPackage();
		
					for(int i=1; rs.next();i++){
			%>

        <%if(i%5==0) {%>
        <tr>
        <%} %>
        
              
            <td>
                <div class="firstrow">
                    <a href="singlePackage.jsp?location=<%=rs.getString(2) %>">
                        <img class="firstrowimg" src="/images/kerala/1.png" alt="">
                    </a>
                    <h2 name="location"><%=rs.getString(2) %></h2>
                </div>
            </td>

<%} %>
       
    </table>

 </div>
    <body>

    </body>

</html>