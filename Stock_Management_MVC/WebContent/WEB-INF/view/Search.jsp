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
<h1 align="center" style="color: green; font-size: 50px;"><b><i>Searched Products</b></i></h1>
<br><br>
<h3 align="center">
<a  style="color: navy;" href="search">Search Product</a> | <a  style="color: navy;" href="add">Add Product </a> | <a  style="color: navy;" href="addtocart">Items for cart</a> | <a  style="color: navy;" href="allproduct">All Products/Update</a> |  <a  style="color: navy;" href="Home">Home</a></h3>
<h1 align="center">${msg}</h1>
<h3 align="right" style="color: navy;">${user} <br><br>
 <a style="color: navy;" href="logout">LOGOUT</a></h3></h3> 
<hr>
<form action="searchData" align="center">
<select name="searchBy" required="required">
<option value=""selected disabled>Search By</option>
<option value="pname">Product Name</option>
<option value="pcategory">Category</option>
<option value="pcompany">Company Name</option>
</select>
<input type="text" name="search">
<input type="submit" value="search">
</form>

<h3><center><table border='1' style="color: red"><tr><th> ID </th><th>Product Name</th><th>Product Category</th>
<th>Company Name</th> <th>Quantity</th><th>Price</th></tr>
<c:forEach var="mlist" items="${mlist}">
<tr>
<td><center> ${mlist.getPid() }</center></td>
<td><center> ${mlist.getPname() }</center></td>
<td><center> ${mlist.getPcategory() }</center></td>
<td><center>${mlist.getPcompany() }</center></td>
<td><center>${mlist.getPquantity() }</center></td>
<td><center>${mlist.getPrice() }</center></td> 
</tr>
</c:forEach>
</table>
</center></h3>
</body>
</html>