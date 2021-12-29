<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
   <meta charset="UTF-8">
   <meta http-equiv="X-UA-Compatible" content="IE=edge">
   <meta name="viewport" content="width=device-width, initial-scale=1.0">
   <title>Login Page</title>
   <link rel="stylesheet" href="login.css">

</head>

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
               <p><a href="forgetpsw.html">Forget Password?</a>
                 
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