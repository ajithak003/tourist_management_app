<%@page import="com.ajith.model.UserClass"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

    
    <!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>wallet page</title>
<style>
    body{
        background-color: rgb(138, 238, 238);
    }
    .container{
        border: 3px solid;
        width: 400px;
        text-align: center;
        margin-left: 30%;
        margin-top: 13%;
        padding: 3%;
        border-radius: 3%;
    }
    input{
        height: 40px;
        width: 200px;
        text-align: center;
        font-size: 18px;
        font-family: 'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif;
        font-weight: bold;
        border: 2px solid;
    }
    button{
        height: 40px;
        width: 220px;
        border-radius: 25px;
        background-color: blueviolet;
        border: none;
        font-size: 15px;
        font-weight: bold;
        font-family: 'Lucida Sans', 'Lucida Sans Regular', 'Lucida Grande', 'Lucida Sans Unicode', Geneva, Verdana, sans-serif;
        color: cornsilk;
    }
</style>

</head>
<body>
        <%
        
        UserClass user = (UserClass) session.getAttribute("user");
        
        String data=(String)session.getAttribute("wallet");
        
         if(data.equals("low")){%>
         <script type="text/javascript">
         alert("Insufficient balance ! please Topup");
         session.setAttribute("wallet", "none");
         </script>
         <%} %>
         
         <form action="walletSus.jsp">
    <div class="container">
           
           <h3>Your Wallet Amount : <span><%=user.getWallet() %></span></h2></h3>
            <br>
            <h4>Topup Wallet</h4>
            <br>
            <input type="text" name="amount" id="amount" required placeholder="Rs.  Enter amount">
            <br><br><br>
            <button>PROCEED TO TOPUP</button>
    </div>
</form>

</body>
</html>