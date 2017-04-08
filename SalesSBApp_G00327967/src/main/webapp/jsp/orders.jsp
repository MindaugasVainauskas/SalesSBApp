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

	<c:forEach items="${orderList}" var="order">
		<h2>${order.oId}</h2>
		<table>
		    <tr>
				<th>Quantity</th>
				<th>Order Date</th>
				<th>Customer ID</th>
				<th>Customer Name</th>
				<th>Product ID</th>	
				<th>Description</th>			
			</tr>				 
			<tr>
				<td>${order.qty}</td>
				<td>${order.orderDate}</td>	
				<td>${order.cust.cId}</td>
				<td>${order.cust.cName}</td>
				<td>${order.prod.pId}</td>
				<td>${order.prod.pDesc}</td>				
			</tr>		
		</table>  
	</c:forEach>  
	    <a href="/">Home</a>
	    <a href="/addOrder">Add Order</a>
	    <a href="/showProducts">List Products</a>
	    <a href="/showCustomers">List Customers</a>
	    <a href="/logout">Logout</a>
	   
	 
	
</body>
</html>