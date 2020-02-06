<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Forget Page</title>
</head>
<body >
<center>
<fieldset style="width:350px; background-color: pink">
<h1 style="font-size: 50px; color: green">Forgot Password</h1>
<form action="forgetpassword"  method="post" >
<pre>
<h3 style="font-family:Arial; color: red"><b>

Email Id: 	      <input style="width: 200px"  type="email" name="email"  required="required"><br>
Security Question:<select style="width: 200px"  type="text" name="squestion"  required="required">
 <option value="selected disabled"> Select Question</option>
 <option value="whats your school name"> whats your school name</option>
 <option value="whats your college name"> whats your college name</option>
  <option value="whats your pet name"> whats your pet name</option>
 </select><br>
Security Answer:  <input style="width: 200px"  type="text" name="sanswer"  required="required"><br>
New Password:	  <input style="width: 200px"  type="text" name="newpassword"  required="required"><br>
Confirm Password: <input style="width: 200px"  type="text" name="confirmpassword"  required="required"><br>


<input  type="submit" value="Change Password">  |  <a href="Login">Login</a> 

</pre>
</form>
${msg }
</fieldset>
</center>
</body>
</html>