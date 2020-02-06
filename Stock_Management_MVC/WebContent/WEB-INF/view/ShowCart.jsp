<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="background-color:silver; ;">
<h1 align="center" style="color: green; font-size: 50px;"><b><i>Orders in Cart</b></i></h1>
<br><br>
<h3 align="center">
<a  style="color: navy;" href="search">Search Product</a> | <a  style="color: navy;" href="add">Add Product </a> | <a  style="color: navy;" href="addtocart">Items for cart</a> | <a  style="color: navy;" href="allproduct">All Products/Update</a> |  <a  style="color: navy;" href="Home">Home</a></h3>
<h1 align="center">${msg}</h1>
<h3 align="right" style="color: navy;">${user} <br><br>
 <a style="color: navy;" href="logout">LOGOUT</a></h3></h3> 
<hr>

<h3><center><table border='1' style="color: red"><tr><th>Order ID</th><th>Product Name</th><th>Product Category</th><th>Company Name</th> <th>Quantity</th><th>Price</th><th>Total Price</th><th>Total Price With GST</th></tr>
<c:forEach var="mmdto" items="${olist}">
<c:forEach var="mdto" items="${mmdto.getMlist()}">
<tr><td><center>${mmdto.getOid()}</center></td>
<td><center>${mdto.getPname() }</center></td>
<td><center> ${mdto.getPcategory() }</center></td>
<td><center>${mdto.getPcompany() }</center></td>
<td><center>${mmdto.getTprice()/mdto.getPrice() }</center></td>
<td><center>${mdto.getPrice() }</center></td> 

</c:forEach>
<td><center>${mmdto.getTprice() }</center></td> 
<td><center>${mmdto.getTpricegst() }</center></td> </tr>
</c:forEach>
</table>
</center></h3>
</body>
</html>
