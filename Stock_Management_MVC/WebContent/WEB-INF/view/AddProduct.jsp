<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<h3>
<a  style="color: red;" href="search">Search Product</a> | <a  style="color: red;" href="add">Add Product </a> | <a  style="color: red;" href="addtocart">Items for cart</a> | <a  style="color: red;" href="allproduct">All Products/Update</a> | <a  style="color: red;" href="Home">Home </a></h3>
<body>
<h3 align="right" style="color: navy;">${user} <br><br>
 <a style="color: red;" href="logout">LOGOUT</a></h3></h3> 
<hr>
<center>
<pre>
<h1 style="font-size: 50px; color: blue">Add Product</h1>
<fieldset style="width:350px; background-color: pink">
<form action="addproduct"  method="post" >
<pre>
<h3 style="font-family:Times-Roman;  color: red"><b>
  Name:	   	 <input style="width: 200px" type="text" name="pname"  required="required" ><br>
Category:	    <input style="width: 200px" type="text" name="pcategory"   required="required"><br>
Company: 	    <input style="width: 200px" type="text" name="pcompany"  required="required"><br>
Quantity: 	    <input style="width: 200px" type="text" name="pquantity"  required="required"><br>
  Price:		<input style="width: 200px" type="number" name="price"  required="required"><br><br>
<input type="submit" value="Add Product">    
 </b></h3> 
</pre>
</form>
<h3 align="center" style="color: red; font-size: 30px">${msg }</h3>
</fieldset>
</center>
</body>
</html> 