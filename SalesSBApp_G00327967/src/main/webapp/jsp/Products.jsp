<!DOCTYPE html>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>SS RAD Final Project</title>
    
    <link rel="stylesheet" href="/css/styles.css"/>
</head>
<body>
	<h2>List of Products</h2>
	
	<table>	  
		
		<tr>
			<th>Product ID</th>
			<th>Description</th>
			<th>Quantity in Stock</th>
		</tr>
		<tr>
			<c:forEach items="${prodList}" var="product">
				<tr>
					<td>${product.pId}</td>
					<td>${product.pDesc}</td>
					<td>${product.qtyInStock}</td>
				</tr>
			</c:forEach>
		</tr>
		</table>
	 
	  	<a href="/">Home</a>
	    <a href="/addProduct">Add Product</a>
	    <a href="/showCustomers">List Customers</a>
	    <a href="/showOrders">List Orders</a>
	    <a href="/logout">Logout</a>
	  
	 
	    
</body>
</html>