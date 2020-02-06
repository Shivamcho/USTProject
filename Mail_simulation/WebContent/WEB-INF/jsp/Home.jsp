<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="background-color: pink">
<h1 align="center" style="color: red; font-size: 50px;"><b><i>Welcome To My Gmail App</b></i></h1>
<br><br>
<h3 align="right" style="color: navy;">${user} <br><br>
<a style="color: fuchsia;" href="changepass">Change Password</a> | <a style="color: fuchsia;" href="logout">LOGOUT</a></h3></h3> 
<hr>

<h3 align="center">
<a  style="color: fuchsia;" href="Inbox">INBOX</a> | <a  style="color: fuchsia;" href="SentInbox">SENT </a> | <a  style="color: fuchsia;" href="deletedmsginhome">DELETED MAILS</a> | <a  style="color: fuchsia;" href="Draft">DRAFT</a> | <a  style="color: fuchsia;" href="Compose">COMPOSE</a></h3>
<h1 align="center">${msg}</h1>
</body>
</html>