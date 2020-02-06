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
<center><h1 style="color: blue; font-size: 50px;">DELETED MAILS</h1></center>

<h3 align="right">  <a style="color: orange" href="Home">Home </a> | <a style="color: orange" href="logout">LOGOUT</a></h3>
<h3 align="center"><a style="color: orange" href="Inbox">INBOX</a> | <a style="color: orange" href="SentInbox">SENT </a> | <a style="color: orange" href="deletedmsginhome">DELETED MAILS</a> | <a style="color: orange" href="Draft">DRAFT</a> | <a style="color: orange" href="Compose">COMPOSE</a></h3>
<hr>

<h3><center><table border='1' style="color: green"><tr><th> Subject </th><th>Deleted Mails</th><th>Sent To</th> <th>Sent From</th><th>Delete</th></tr>
<c:forEach var="mdto" items="${mlist}">
<tr>
<td><center> ${mdto.getMusub() }</center></td>
<td><center>${mdto.getMuinbox() }</center></td>
<td><center>${mdto.getMuto() }</center></td>
<td><center>${mdto.getMusent() }</center></td> 
<td><center><a href="permanentdelete?did=${mdto.getInfid() }"> Delete</a></center></td> 
</tr>
</c:forEach>
</table>
</center></h3>
</body>
</html>