<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>SS RAD Final Project</title>
    
    <link rel="stylesheet" href="/css/styles.css"/>
</head>
<body>
<h2>List of Orders</h2>
	<table>
	  <tr>
			<th>Order ID</th>
			<th>Quantity</th>
			<th>Order Date</th>
			<th>Customer</th>
			<th>Product</th>			
		</tr>
		<tr>
			<c:forEach items="${orderList}" var="order">
				<tr>
					<td>${order.oId}</td>
					<td>${order.qty}</td>	
					<td>${order.orderDate}</td>
					<td>${order.cust.cId}</td>
					<td>${order.prod.pId}</td>				
				</tr>
			</c:forEach>
		</tr>
		</table>    
	    <a href="/">Home</a>
	    <a href="/addOrder">Add Order</a>
	    <a href="/showProducts">List Products</a>
	    <a href="/showCustomers">List Customers</a>
	    <a href="/logout">Logout</a>
	   
	 
	
</body>
</html>