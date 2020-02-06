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
<center><h1 style="color: orange; font-size: 50px;">DRAFT MAILS</h1></center>

<h3 align="right">  <a style="color: green" href="Home">Home </a> | <a style="color: green" href="logout">LOGOUT</a></h3>
<h3 align="center"><a style="color: green" href="Inbox">INBOX</a> | <a style="color: green" href="SentInbox">SENT </a> | <a style="color: green" href="deletedmsginhome">DELETED MAILS</a> | <a style="color: green" href="Draft">DRAFT</a> | <a style="color: green" href="Compose">COMPOSE</a></h3>
<hr>


<h3><center><table border='1' style="color: red"><tr><th>Draft Messages</th><th>Draft Emails</th><td>Edit</td><td>Delete</td></tr>
<c:forEach var="mdto" items="${mlist}">

<tr><td><center>${mdto.getMuinbox() }</center></td>
<td><center>${mdto.getMudraft() }</center></td>


 
 
<td><a href="Composedraft?ibid=${mdto.getInfid() }">${mdto.getMuinbox() }</a></td>

<td><center>&nbsp&nbsp <a href="deletemsg?msgid=${mdto.getInfid()}"> Delete</a>&nbsp&nbsp </center></td>
</tr>
</c:forEach>
</table>


</body>
</html>