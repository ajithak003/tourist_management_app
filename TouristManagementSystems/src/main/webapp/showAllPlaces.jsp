<%@page import="com.ajith.model.PackageModeClass"%>
<%@page import="java.util.List"%>
<%@page import="com.ajith.daoImplement.PackageModeClassDaoImplement"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

   <!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>showAllPlaces</title>
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

    <%  response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");%>

<div class="second">
<h3><a href="AdminPage.jsp">Go To Home</a></h3>
    <table cellspacing="30px" cellpadding ="1000px" class="table">

       <%
     PackageModeClassDaoImplement packageDao = new PackageModeClassDaoImplement();
       List<PackageModeClass> packages = packageDao.getAllPackage();
		
					for(int i=0; i<packages.size();i++){
						
						PackageModeClass rs = packages.get(i);
			%>

        <%if(i%4==0) {%>
        <tr>
        <%} %>
        
              
            <td>
                <div class="firstrow">
                    
                        <img class="firstrowimg" src="Assets/<%=rs.getImage() %>" alt="">
                    
                    <h2 name="location"><%=rs.getName()%></h2>
                </div>
            </td>

<%} %>
       
    </table>

 </div>
    <body>

    </body>

</html>