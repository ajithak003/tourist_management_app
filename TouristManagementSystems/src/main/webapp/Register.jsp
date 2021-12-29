<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>register Form</title>
<link rel="stylesheet" href="login.css">
<link rel="stylesheet" href="login.css">
</head>
<body>
<form action="register" id="register" method = "post">
      <div class="loginbox">
          <h1>Register</h1>
          <div class="textbox">
            <input type="text" placeholder="FullName" name="FullName" value="" required autofocus>
          </div>
          <div class="textbox">
             <input type="email" placeholder="Email" name="regemail" value="" required  pattern="[A-Za-z0-9]+[@][a-zA-Z]+[.][A-Za-z]{2,3}">
          </div>
          <div class="textbox">
              <input type="text" placeholder="Mobile No" name="regmobile" value="" required pattern="[6-9][0-9]{9}" title="Must contain 10 numbers only"> 
          </div >
          
          <div class="textbox">
              <input type="password" placeholder="Password" name="regpsw" value="" required pattern="^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,15}$"
                title="Minimum eight and Minimum 8 and maximum 15 characters, at least one uppercase letter, one lowercase letter, one number and one special character">
          </div>
          <div class="textbox">
              <input type="password" placeholder="Confirm Password" name="regcpsw" value="" required pattern="^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,15}$"
                title="Minimum eight and Minimum 8 and maximum 15 characters, at least one uppercase letter, one lowercase letter, one number and one special character">
          </div>

            <button class="btn" type="submit">Sign up</button>

          <div>
          </div>
      </div>
  </form>

</body>
</html>
