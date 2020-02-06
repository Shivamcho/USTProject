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

<center><h1 style="color: aqua; font-size: 50px;">SENT MAILS</h1></center>

<h3 align="right">  <a style="color: maroon;" href="Home">Home </a> | <a style="color: maroon;" href="logout">LOGOUT</a></h3>
<h3 align="center"><a style="color: maroon;" href="Inbox">INBOX</a> | <a style="color: maroon;" href="SentInbox">SENT </a> | <a style="color: maroon;" href="deletedmsginhome">DELETED MAILS</a> | <a style="color: maroon;" href="Draft">DRAFT</a> | <a style="color: maroon;" href="Compose">COMPOSE</a></h3>
<hr>
<h3 align="center"><center><table border='1' style="color: olive;"><tr><th>Sent To</th><th>Messages</th> <th>Delete</th></tr>
<c:forEach var="mdto" items="${mlist}">
<tr><td><center>${mdto.getMuto() }</center></td>
<td><center><a style="color: green;" href="fullinbox?ibid=${mdto.getInfid() }" >${mdto.getMuinbox() }</a></center></td> 
<td><center>&nbsp&nbsp <a style="color: green;" href="deletemsg?msgid=${mdto.getInfid()}"> Delete</a>&nbsp&nbsp </center></td>
</tr>
</c:forEach>
</table>

</body>
</html>