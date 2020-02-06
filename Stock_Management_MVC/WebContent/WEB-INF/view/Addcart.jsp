<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="background-color:pink; ;">
<h1 align="center" style="color: navy; font-size: 50px;"><b><i>Items Present for Cart</b></i></h1>
<br><br>
<h3 align="center">
<a  style="color: navy;" href="search">Search Product</a> | <a  style="color: navy;" href="add">Add Product </a> | <a  style="color: navy;" href="addtocart">Items for cart</a> | <a  style="color: navy;" href="allproduct">All Products/Update</a> |  <a  style="color: navy;" href="Home">Home</a></h3>
<h1 align="center">${msg}</h1>
<h3 align="right" style="color: navy;">${user} <br><br>
 <a style="color: navy;" href="logout">LOGOUT</a></h3></h3> 
<hr>

<h3><center><table border='1' style="color: red"><tr><th>Product Name</th><th>Product Category</th><th>Company Name</th> <th>Quantity</th><th>Price</th><th>Cart</th></tr>
<c:forEach var="mdto" items="${mlist}">
<form action="cartadded" method="post">
<tr>
<input type="hidden" name="pid" value=" ${mdto.getPid() }">
<td><center><input type="text" disabled="disabled" name="pname" value="${mdto.getPname() }"></center></td>
<td><center> <input type="text" disabled="disabled" name="pcategory" value="${mdto.getPcategory() }"></center></td>
<td><center><input type="text" disabled="disabled" name="pcompany"  value="${mdto.getPcompany() }"></center></td>
<td><center><input type="text" name="pquantity" value=" " >${ mdto.getPquantity()}</center></td>
<td><center><input type="text" disabled="disabled" name="price" value="${mdto.getPrice() }"></center></td> 
<td><center><input type="submit" value="Addcart"></center></td>
</tr>
</form>
</c:forEach>
</table>
</center></h3>
</body>
</html>
