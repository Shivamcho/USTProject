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

<center><h1 style="color: gray; font-size: 50px;">INBOX</h1></center>
<h3 align="right">  <a style="color: aqua" href="Home">Home </a> | <a style="color: aqua" href="logout">LOGOUT</a></h3>
<h3 align="center"><a style="color: aqua" href="Inbox">INBOX</a> | <a style="color: aqua" href="SentInbox">SENT </a> | <a style="color: aqua" href="deletedmsginhome">DELETED MAILS</a> | <a style="color: aqua" href="Draft">DRAFT</a> | <a style="color: aqua" href="Compose">COMPOSE</a></h3>
<hr>

<h3><center><table border='1' style="color: teal;"><tr><th>Send By</th> <th>Subject</th>  <th>Messages</th><th>Delete</th></tr>
<c:forEach var="mdto" items="${mlist }">
<tr>
<td><center>${mdto.getMusent() }</center></td>
<td><center>${mdto.getMusub() }</center></td> 
<td><center><a style="color: red;" href="fullinbox?ibid=${mdto.getInfid() }" >${mdto.getMuinbox() }</a></center></td>
<td><center>&nbsp&nbsp <a style="color: green;" href="deletemsg?msgid=${mdto.getInfid()}"> Delete</a>&nbsp&nbsp </center></td>
</tr>
</c:forEach>

</table>
</center>

</center></h3>
</body>
</html> 