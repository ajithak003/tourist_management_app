<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

    
    <!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>terms and condition</title>
<style>
body{
    background-color:ivory;
}
.box{
    text-align: center;
    margin-top: 100px;
    font-size: 20px;
}
.btn{
    height: 40px;
    width: 70px;
    background-color: rgb(99, 99, 243);
    font-size: 20px;
    color: white;
    border-radius: 20px;
    border: none;
}
</style>
</head>
<body>
    <form action="dateChangeflight.jsp">
    <%  int bookingId = Integer.parseInt(request.getParameter("bookingid"));
  //  System.out.println("trip page  "+bookingId);
        session.setAttribute("datechangeid", bookingId);
    %>
    <div class="box">
   <h4> Notes : if you want to change tour date 1000 will be detected</h4>

    <h4><input type="checkbox" name="yes" id="yes" value="accept" required>accept terms and policy</h4>
    <h3>change Date : <input type="date" name="changedate" id="changedate" required> </h3> 
    <button class="btn" id="btn">Ok</button>
</div>
</form>
<script>
today();
function today(){
    var today = new Date();
    var dd = String(today.getDate()).padStart(2, '0');
    var mm = String(today.getMonth() + 1).padStart(2, '0'); //January is 0!
    var yyyy = today.getFullYear();
    var max = today.setMonth( today.getMonth() + 1 );
maxdate = today.getFullYear() + '-' + 0+(today.getMonth() + 1) + '-'+ 0+today.getDate()  ;
mindate =yyyy + '-' + mm + '-'+ dd ;
document.getElementById("changedate").setAttribute("max",maxdate);
console.log(maxdate);
console.log(mindate);
document.getElementById("changedate").setAttribute("min",mindate);
}  
</script>
</body>
 

</html>