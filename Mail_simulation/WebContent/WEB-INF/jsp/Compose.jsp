<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="background-color: pink">
<center><h1 style="color: green; font-size: 50px;">COMPOSE</h1></center>
<h3 align="right">  <a style="color: red" href="Home">Home </a> | <a style="color: red" href="logout">LOGOUT</a></h3>
<h3 align="center"><a style="color: red" href="Inbox">INBOX</a> | <a style="color: red" href="SentInbox">SENT </a> | <a style="color: red" href="deletedmsginhome">DELETED MAILS</a> | <a style="color: red" href="Draft">DRAFT</a> | <a style="color: red" href="Compose">COMPOSE</a></h3>
<hr>
<center>
<fieldset style="width:350px; background-color: orange" >
<form action="Compose"  method="post" >
<pre>


To:      <input style="width: 200px;" type="email" name="email"  value="${mdto.getMudraft()}"required="required"><br><br>

Subject:  <input  style="height: 50pxpx; width: 200px; " type="text"  name="musub" value="${mdto.getMusent()}"><br><br>
Message:  <input  style="height: 150px; width: 200px;" type="text"  name="muinbox" value="${mdto.getMuinbox()}"><br><br>

 <input style="width: 80px" type="submit" value=" Sent"></b>
</form></pre>
<h4 style="color:  blue">${draftmsg }</h4>
</center>
</body>
</html>