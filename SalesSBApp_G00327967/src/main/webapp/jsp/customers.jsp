<!DOCTYPE html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>SS RAD Final Project</title>
    
    <link rel="stylesheet" href="/css/styles.css"/>
</head>
<body>
<h2>List of Customers</h2>
	<c:forEach items="${custList}" var="customer">
	<h2>${customer.cId} ${customer.cName}</h2>
	<h3>${customer.cName}'s Orders</h3>
	<table>	 
	    <tr>
			<th>Order ID</th>
			<th>Quantity</th>
			<th>Product ID</th>
			<th>Description</th>			
		</tr>	
		<c:forEach items="${customer.orders}" var="order">		
		<tr>
			<td>${order.oId}</td>
			<td>${order.qty}</td>
			<td>${order.prod.pId}</td>
			<td>${order.prod.pDesc}</td>					
		</tr>
		</c:forEach>		
	</table>  
	</c:forEach>
	  	<a href="/">Home</a>
	    <a href="/addCustomer">Add Customer</a>
	    <a href="/showProducts">List Products</a>
	    <a href="/showOrders">List Orders</a>
	    <a href="/logout">Logout</a>
	   
</body>
</html>