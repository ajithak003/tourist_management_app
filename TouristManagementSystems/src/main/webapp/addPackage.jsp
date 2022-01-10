<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=, initial-scale=1.0">
    <title>add package</title>
    <style>
      *{
  
  margin: 0;
  padding: 0;
  box-sizing: border-box;
  text-decoration: none;
  font-family:'Gill Sans', 'Gill Sans MT', Calibri, 'Trebuchet MS', sans-serif;
  background-color:aquamarine;
  
}

h1{
    text-align: center;
}
.addpackage{
    border: 3px solid;
    height: 480px;
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
    width: 170px;
    margin-left: 65%;
    margin-top: 20px;
    border-radius: 20px;
    background-color: cyan;
    font-size: 18px;
    font-family: Georgia, 'Times New Roman', Times, serif;
    font-weight: bold;
    border:none
}

    </style>
</head>
<body>
<form action="addpackage">
    <h1>Add Tourist Package</h1>
  <h2><a href="AdminPage.jsp">Go To Home</a></h2>

<%          
      String data=(String)session.getAttribute("addpackages");
      System.out.println(data);
      String error = (String) session.getAttribute("addpackageerror");
      System.out.println(error);

    if(data.equals("true")){%>
         <script type="text/javascript">
         alert("successfully Added");
         </script>
         <% }
       
     else if(error!=null){ 
    	 System.out.println(error+ " if"); %>
     <script type="text/javascript">
     alert("This Product Already Added");
     </script>  
<%} %> 



    <div class="addpackage">
        <table cellspacing="20px" cellpadding="30px">  
            <tr>
     <td><label for="location">package location : </label></td> 
     <td> <input type="text" name="packagename" id="packagename" required></td> 
    </tr>
     
      <tr>
     <td> <label for="price">Package one day night price : </label></td>
     <td> <input type="text" name="packageonedayprice" id="packageonedayprice" required></td>
     </tr>
      <tr>
<td><label for="season">current season :</label></td>
     <td> <input type="text" name="season" id="season" required></td>
      </tr>
      <tr>
     <td> <label for="protocol">current tourist protocols :</label></td>
      <td><textarea name="protocol" id="" cols="30" rows="3" required></textarea></td>
      </tr>
      <tr>
     <td> <label for="description">Tourist Place Description :</label></td>
      <td><textarea name="description" id="description" cols="30" rows="3" required></textarea></td>
    </tr>
    <tr>
    <td> <label for="image">Add Images URL : </label></td>
    <td> <input type="file" name="packageimage" id="packageimage" required> </td>
    </tr>
    </table>
    <button >Add Package</button>
    </form>
    <%session.setAttribute("addpackages", null);
  session.setAttribute("addpackageerror", null);%>
</body>
</html>