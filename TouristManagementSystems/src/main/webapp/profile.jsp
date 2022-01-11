<%@page import="com.ajith.model.UserClass"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

    
    <!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Profile</title>
    <style>
        h1{
            text-align: center;
        }
       .table {
            align-items: center;
            border: 3px solid;
            margin-left: 36%;
            height: 400px;
            width: 430px;
        }
        a{
           text-decoration: none;
           margin-top: -50px;
           margin-left: 900px;
           font-size: 20px;
           font-weight: bold;
        }

    </style>
</head>
<body>
    
<h1>
    My Profile
</h1>


<a href="updateprofile.jsp">Update</a>
<br>
<br>

<%  
    UserClass user = (UserClass) session.getAttribute("user");

%>

<div class="table">
<table  cellspacing ="50px">
    <tr>
        <td><h2>Name  </h2></td>
        <td><h3><%=user.getName() %></h3></td>
    </tr>
    <tr>
        <td><h2>Email Id  </h2></td>
        <td><h3><%=user.getEmail() %></h3></td>
    </tr>

    <tr>
        <td><h2>Mobile No  </h2></td>
        <td><h3><%= user.getMboNo() %></h3></td>
    </tr>
</table>

</div>
</body>
</html>