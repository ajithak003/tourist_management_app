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
  background-color:silver;
  
}

h1{
    text-align: center;
}
.addpackage{
    border: 3px solid;
    height: 450px;
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
}
textarea{
    border: 3px solid;
}


    </style>
</head>
<body>
    <h1>Update Tourist Package</h1>
    <br><br><br>

    <div class="addpackage">
        <table cellspacing="20px" cellpadding="30px">  
            <tr>
     <td><label for="location">package location : </label></td> 
     <td> <input type="text" name="packagename" id="packagename" required></td> 
    </tr>
     
      <tr>
     <td> <label for="price">Package one day night price : </label></td>
     <td> <input type="text" name="packageonedayprice" id="packageonedayprice"></td>
     </tr>
      <tr>
<td><label for="season">current season :</label></td>
     <td> <input type="text" name="season" id="season"></td>
      </tr>
      <tr>
     <td> <label for="protocol">current tourist protocols :</label></td>
      <td><textarea name="" id="" cols="30" rows="3"></textarea></td>
      </tr>
      <tr>
     <td> <label for="description">Tourist Place Description :</label></td>
      <td><textarea name="description" id="description" cols="30" rows="3"></textarea></td>
    </tr>
    </table>
    </div>
</body>
</html> 