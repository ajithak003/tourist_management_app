<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
   <meta charset="UTF-8">
   <meta http-equiv="X-UA-Compatible" content="IE=edge">
   <meta name="viewport" content="width=device-width, initial-scale=1.0">
   <title>Login Page</title>
<style>
body{
    margin: 0;
    padding: 0;
    font-family: sans-serif;
    background: url("blure.jpg");
    background-size: cover;
}


.loginbox{
    border: 2px solid;
    background-color:cornsilk;
    border-radius: 20px;
    padding:30px;
     width: 290px;
     position: absolute;
     top: 50%;
     left: 50%;
     transform: translate(-50%,-50%);
     color:black;
}
.loginbox h1{
     
    float: left;
    font-size: 40px ;
    border-bottom: 6px solid #1ef725;
    margin-bottom: 50px;
    padding: 13px 0;
}
.textbox{
    width: 100%;
    overflow: hidden;
    font-size: 20px;
    padding: 8px 0;
    margin:8px 0 ;
    border-bottom: 1px solid #1ef725;
}
.textbox input{
    border: none;
    outline: none;
    background: none;
    color: whiye;
    font-size: 18px;
    width: 80%;
    float: left;
    margin: 10px;
}
.btn{
    width: 100%;
    background: none;
    
    border: 2px solid #1ef725;
    color:blue;
    padding: 5px;
    font-size: 18px;
    }
    a{
    text-decoration: none;
    font-weight: bolder;
    
}
</style>
</head>

<%  response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");%>

<body>
   <form action="login" id="login">
      
         <div class="loginbox">
            <h1>Login</h1>

            <div class="textbox">
               <input type="email" placeholder="Email" name="loginemail" value="" required pattern="[A-Za-z0-9]+[@][a-zA-Z]+[.][A-Za-z]{2,3}" autofocus>
            </div>
            <div class="textbox">
               <input type="password" placeholder="Password" name="loginpsws" value="" required
                  pattern="^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,15}$"
                  title="Minimum eight and Minimum 8 and maximum 15 characters, at least one uppercase letter, one lowercase letter, one number and one special character">
            </div>

           
            <button class="btn" type="submit">Sign in</button>

            <div class="forget">
<!--                <p><a href="forgetpsw.html">Forget Password?</a>
 -->                 
               </p>
               <p>New User? <a href="Register.jsp" >create an account </a></p>
            </div>
            <br>
            <% String error=(String)session.getAttribute("error");
            if(error!=null) {%>
            <p ><%=session.getAttribute("error") %></p>
            <%} session.removeAttribute("error"); %>
         </div>
     
  </form>
  <script type="text/javascript" src="script.js"></script>  
</body>

</html>