<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>register Form</title>
<Style>
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
</Style>
</head>
<body>
<form action="register" id="register"onsubmit="return resetpsw()" method="post">
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
              <input type="password" placeholder="Password" name="regpsw" value="" id="psw" required pattern="^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,15}$"
                title="Minimum eight and Minimum 8 and maximum 15 characters, at least one uppercase letter, one lowercase letter, one number and one special character">
          </div>
         <!--  <div class="textbox">
              <input type="password" placeholder="Confirm Password" name="regcpsw" value="" id="cpsw" required pattern="^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,15}$"
                title="Minimum eight and Minimum 8 and maximum 15 characters, at least one uppercase letter, one lowercase letter, one number and one special character">
          </div> -->

            <button class="btn" type="submit">Sign up</button>
            <br>
             <% String notallow=(String)session.getAttribute("notallow");
            if(notallow!=null) {%>
            <h4><%=session.getAttribute("notallow") %></h4>
           
            <%} session.removeAttribute("notallow"); %>
            <% String error=(String)session.getAttribute("error");
            if(error!=null) {%>
            <h4><%=session.getAttribute("error") %></h4>
           
            <%} session.removeAttribute("error"); %>
            

          <div>
          </div>
      </div>
  </form>
  
<!-- <script>

    function resetpsw() {
     var psw = document.getElementById("psw");
     console.log(psw)
     var cpsw = document.getElementById("cpsw");
     console.log(cpsw)
     console.log("hi");
     if (psw.value.trim() != cpsw.value.trim()) {
          console.log("false");
          alert("please enter the correct password");
          return false;
     }
     else if(psw.value.trim() == cpsw.value.trim()){
                return true;
     }
    }
</script>  -->

</body>
 
</html>
