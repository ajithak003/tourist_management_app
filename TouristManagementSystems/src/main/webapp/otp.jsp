<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

   <style type="text/css">
   body{
       background-color:blanchedalmond
   }
   h2{
       text-align: center;
       position: relative;
       top: 130px;
   }
</head>
<body>

<form  name="otp" id="otp" action="otp">

           
            <% String error=(String)session.getAttribute("error");
            if(error!=null) {%>
            <h2><%=session.getAttribute("error") %></h2>
           
            <%} session.removeAttribute("error"); %>
            
            <% String success=(String)session.getAttribute("success");
            if(success!=null) {%>
            <h2><%=session.getAttribute("success") %></h2>
           
            <%} session.removeAttribute("success"); %>
            
            
            
    </form>

</body>
</html>