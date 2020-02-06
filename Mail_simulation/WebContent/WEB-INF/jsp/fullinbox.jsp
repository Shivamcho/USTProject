<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>INBOX</title>
</head>
<body style="background-color: pink">
<center><h1 style="color: red; font-size: 50px;">INBOX</h1></center>
<h3 align="right" >  <a href="Home" style="color: white;">Home </a> | <a href="logout" style="color: white;">LOGOUT</a></h3>
<h3 align="center"> <a href="Inbox" style="color: white;">INBOX</a> | <a href="SentInbox" style="color: white;">SENT </a> | <a href="deletedmsginhome" style="color: white;">DELETED MAILS</a> | <a href="Draft" style="color: white;">DRAFT</a> | <a href="Compose" style="color: white;">COMPOSE</a></h3>
<hr>
<center>


<fieldset style="width:350px; background-color: orange" >
<pre>
TO:  	<input  style="width: 250px;" type="text" value="${mdto.getMuto()}">


FROM:   <input   style="width: 250px;" type="text" value="${mdto.getMusent()}">

MESSAGE:  <input   style="height: 150px; width: 200px;" type="text" value="${mdto.getMuinbox()}"><br><br>

</pre>
</fieldset>
</center>
</body>
</html>