<%@page import="com.ajith.daoImplement.UserTableDaoImplement"%>
<%@page import="com.ajith.model.UserClass"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>wallet successful</title>
<style>
body{
    background-color: silver;
}
h1{
    font-size: 40px;
    font-family: Georgia, 'Times New Roman', Times, serif;
    font-weight: bold;
    color: slateblue;
    text-align: center;
    margin-top: 18%;
}
h2{
    text-align: center;
}
span{
    color:crimson;
}
</style>
</head>
<body>

<%  
    UserClass user = (UserClass) session.getAttribute("user");
   UserTableDaoImplement userDao = new UserTableDaoImplement();
   String amounts = request.getParameter("amount");
   long amount = Long.parseLong(amounts);
   long totalAmount = user.getWallet()+ amount;
   boolean wallet = userDao.addWalletAmount(user.getId(), totalAmount);
   if(wallet==true){
   UserClass newUser = userDao.getUserById(user);
   
%>

    <h1>Transaction Successful</h1>
    <h2>Your wallet Amount : <span><%=newUser.getWallet() %></span></h2>
    <br><br>
    <h2><a href="index.jsp">Go To Home</a></h2>
    <%} 
   else{
	   %>
	   <h1>Transaction failed👍</h1>
	    <h2>Your wallet Amount : <span><%=user.getWallet() %></span></h2>
	    <h2><a href="index.jsp">Go To Home</a></h2>
 <%} %>
</body>
</html>