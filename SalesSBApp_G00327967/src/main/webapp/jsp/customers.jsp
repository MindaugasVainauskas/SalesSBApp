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
	<table>	 
	  <tr>
			<th>Product ID</th>
			<th>Description</th>			
		</tr>
		<tr>
			<c:forEach items="${custList}" var="customer">
				<tr>
					<td>${customer.cId}</td>
					<td>${customer.cName}</td>					
				</tr>
			</c:forEach>
		</tr>
	 
	</table>  
	  	<a href="/">Home</a>
	    <a href="/addCustomer">Add Customer</a>
	    <a href="/showProducts">List Products</a>
	    <a href="/showOrders">List Orders</a>
	    <a href="/logout">Logout</a>
	   
</body>
</html>