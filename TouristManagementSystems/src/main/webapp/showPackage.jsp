<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.model.PackageModeClass"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>popularPlaces</title>
<style>
    *{
    margin: 0;
    padding: 0;
    box-sizing: border-box;
    text-decoration: none;
    font-family: Arial, sans-serif;
    
}
body{
    background-color:cornsilk;
}
.place{
    border: 3px solid;
    position: absolute;
    width: 99%;
    padding-left: 40px;
    padding: 25px;
    height: 500px;
}
.firstrowimg{
    position: absolute;
    width: 300px;
    height: 400px;
}
h2{
    position: absolute;
    top: 450px;
    left: 85px;
    font-size: 30px;
    font-family:'Trebuchet MS', 'Lucida Sans Unicode', 'Lucida Grande', 'Lucida Sans', Arial, sans-serif;
}
.hr{
    border: 3px solid;
    position: absolute;
    height: 500px;
    width: 400px;
    border-bottom: none;
    border-top: none;
    border-left: none;
}
.box{
    border: 3px solid;
    position: absolute;
    height: 500px;
    width: 900px;
    left: 400px;
    border-bottom: none;
    border-top: none;
    border-left: none;
    border-right: none;
    
   
    
}
.details{
    position: absolute;
    left: 420px;
}
p{
    font-weight: bold;
}
h3{
    font-weight: bold;
}
</style>

</head>
<body>

        <%
		List<PackageModeClass> packages = (List<PackageModeClass>)req.getAttribute("package");
		if (packages != null) {
		%>
       
    <table cellspacing="29px" class="table">
    
    <%
					int i = 0;
					for (PackageModeClass pack : packages) {
						i++;
				%>

        <!-- firstrow images -->
        <div class="place">
        <tr>
            <td>
                
                    <a href="#">
                        <img class="firstrowimg" src="/images/kerala/1.png" alt="">
                       
                    </a>
                    
            </td>
        </div>
            <div class="hr"></div>
            <div class="box">
                <table class="details" cellspacing="30px" cellpadding="">
         <tr>   
            <td>
                <h3>Location : </h3>
            </td>
            <td><p><%=pack.getName()%></p></td>
            </tr>
            <tr>
            <td>
                <h3>One Day night <br> Package Place  </h3>
            </td>
            <td><p><%=pack.getPriceOneDays()%></p></td>
            </tr>
            <tr>
            <td>
                <h3>Season : </h3>
            </td>
            <td><p><%=pack.getSeason()%></p></td>
            </tr>
            <tr>
            <td>
                <h3>Tourist Protocols : </h3>
            </td>

            <td><p><%=pack.getProtocols()%></p></td>
            </tr>
            <tr>
            <td>
                <p><%=pack.getDescription()%></p>
            </td>
            </tr>
        </table>
        </div>
            <tr>
                <h2>Kashmir</h2>  
            </tr>
        <% } %>
        <%} %>
       
            </table>

</body>
</html>