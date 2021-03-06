<%@page import="com.ajith.model.HotelClass"%>
<%@page import="com.ajith.daoImplement.HotelTableDaoImplement"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

    <!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=, initial-scale=1.0">
    <title>update hotels</title>
    <style>
      *{
  
  margin: 0;
  padding: 0;
  box-sizing: border-box;
  text-decoration: none;
  font-family:'Gill Sans', 'Gill Sans MT', Calibri, 'Trebuchet MS', sans-serif;
  background-color:azure;
  
}

h1{
    text-align: center;
}
.addpackage{
    border: 3px solid;
    height: 580px;
    width: 45%;
    position: absolute;
    left: 27%;
    padding: 25px;

}
label{
    font-size: 20px;
    font-weight: bolder;
    font-family: 'Lucida Sans', 'Lucida Sans Regular', 'Lucida Grande', 'Lucida Sans Unicode', Geneva, Verdana, sans-serif;
}
input{
    border: 3px solid;
    height: 25px;
    width: 222px;
    font-size: 16px;
    font-weight: bold;
}
textarea{
    border: 3px solid;
}
button{
    height: 30px;
    width: 150px;
    margin-left: 70%;
    margin-top: 10px;
    border-radius: 20px;
    background-color:gold;
    font-size: 18px;
    font-family: Georgia, 'Times New Roman', Times, serif;
    font-weight: bold;
    border:none
}


    </style>
</head>
<body>

<%  response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");%>

    <h1>Update Hotels</h1>
    <br><br><br>
    
    <% int hotelId = Integer.parseInt(request.getParameter("hotelid"));
        
    HotelTableDaoImplement hotelDao = new HotelTableDaoImplement();
    HotelClass hotel = hotelDao.getSingleHotel(hotelId);
    
    %>
    
   <form action = "updatehotel" >
<div class="container">
    <div class="addpackage">
        <table cellspacing="50px" cellpadding="70px">  
            <tr>
     <td><label for="">Hotel Name : </label></td> 
     <td> <input type="text" name="hotelname" id="hotelname" value="<%=hotel.getHotelName() %>" required pattern="[aa-Zz]{2,}" title="must contain characters only" autofocus></td> 
    </tr>
     
      <tr>
     <td> <label for="">Hotel Location : </label></td>
     <td> <input type="text" name="hotellocation" id="hotellocation" value="<%=hotel.getLocation() %>" required pattern="[aa-Zz]{2,}" title="must contain characters only"></td>
     </tr>
      <tr>
<td><label for="">Standard Room One Day Price :</label></td>
     <td> <input type="text" name="standardprice" id="standardprice" value="<%=hotel.getMidRangePrice() %>" required pattern="[0-9]{2,10}" title="must contain number only maximum 10 number"></td>
      </tr>
      <tr>
     <td> <label for="">Premium Room One Day Price :</label></td>
      <td><input type="text" name="premiumprice" id="premiumprice" value="<%=hotel.getPremiumPrice() %>" required pattern="[0-9]{2,10}" title="must contain number only maximum 10 number"></td>
      </tr>
      <tr>
      <td> <label for="">Add Image URL :</label> </td>
    <td> <input type="file" name="hotelimage" id="hotelimage" value="<%=hotel.getImage()%>" required> </td>
    </tr>
    </table>
    <button name ="hotelid" value="<%=hotel.getHotelId()%>">Update hotel</button>
    </div>
</div>
</form>
</body>
</html>