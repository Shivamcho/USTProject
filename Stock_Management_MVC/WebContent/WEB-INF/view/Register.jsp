<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>
<h1 style="font-size: 50px; color: blue">SIGN UP</h1>
<fieldset style="width:350px; background-color: pink">

<form action="MangerRegistration"  method="post" >
<pre>
<h3 style="font-family:Times-Roman;  color: red"><b>
User Name:	    <input style="width: 200px" type="text" name="mname"  required="required" ><br>
Mobile No.:	    <input style="width: 200px" type="tel" name="mnumber"   maxlength="10" "><br>
Email Id: 	    <input style="width: 200px"  type="email" name="email"  required="required"><br>
Password: 	    <input style="width: 200px"  type="password" name="password"  required="required"><br><br>
<input  type="submit" value="Sign Up">   |  <a style="color: green" href="Login">Login</a> 
 </b></h3> 
</pre>
</form>
<h3 align="center" style="color: red; font-size: 30px">${msg }</h3>
</fieldset>
</center>
</body>
</html>