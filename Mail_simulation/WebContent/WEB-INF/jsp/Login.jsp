<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>
<h1 style="font-size: 50px; color: red">LOGIN</h1>
<fieldset style="width:350px; background-color: pink">
<form action="UserLogin"  method="post" >
<pre>
<h3 style="font-family:Arial; color: orange"><b>
Email Id:  <input type="email" name="email"  required="required"><br>
Password:  <input type="password" name="password"  required="required"><br><br>
<input  type="submit" value="Login"> | <a style="color: red" href="Register">Register</a></b></h3> </b></h3>
 <h4 style="font-size: 20px;"><a href="forget">Forget Password</a></b></h4> 
</pre>
</form>
</fieldset>
<br><br>
<h3 align="center" style="color: green; font-size: 50px">${msg}</h3>
</center>
</body>
</html>