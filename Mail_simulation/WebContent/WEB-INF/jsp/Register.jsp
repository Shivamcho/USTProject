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

<form action="UserRegistration"  method="post" >
<pre>
<h3 style="font-family:Times-Roman;  color: red"><b>
User Name:	    <input style="width: 200px" type="text" name="mun"  required="required" ><br>
Mobile No.:	    <input style="width: 200px" type="tel" name="mnum"   maxlength="10" "><br>
Email Id: 	    <input style="width: 200px"  type="email" name="email"  required="required"><br>
Password: 	    <input style="width: 200px"  type="password" name="password"  required="required"><br>
Security Question:<select name="squestion">
 <option value="selected disabled"> Select Question</option>
 <option value="whats your school name"> whats your school name</option>
 <option value="whats your college name"> whats your college name</option>
  <option value="whats your pet name"> whats your pet name</option>
 </select><br>
Security Answer:  <input style="width: 200px"  type="text" name="sanswer"  required="required"><br>
<input  type="submit" value="Sign Up">   |  <a style="color: green" href="Login">Login</a> 

 </b></h3> 
</pre>
</form>
<h3 align="center" style="color: red; font-size: 50px">${msg }</h3>
</fieldset>
</center>
</body>
</html>