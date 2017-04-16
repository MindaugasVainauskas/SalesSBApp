<!DOCTYPE html>
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>	
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>SS RAD Final Project</title>
    
    <link rel="stylesheet" href="/css/styles.css"/>
</head>
<body>
	<c:choose>
	<c:when test="${not empty error }">
		<h2>Error Creating the following Order</h2>
		<h3>"${error}"</h3>		
		<h3>"${error2}"</h3>	
	</c:when>
		<c:otherwise>
			<h2>New Order</h2>
			
			<form:form modelAttribute="order">
				<table>
					<tr>
						<td>Customer ID: </td>
						<td><form:input path="cust.cId"/></td>
						<td><form:errors path="cust.cId"></form:errors></td>
					</tr>
					<tr>
						<td>Product ID: </td>
						<td><form:input path="prod.pId"/></td>
						<td><form:errors path="prod.pId"></form:errors></td>
					</tr>
					<tr>
						<td>Quantity: </td>
						<td><form:input path="qty"/></td>
						<td><form:errors path="qty"></form:errors></td>
					</tr>
					<tr>
						<td colspan="2">
							<input type="submit" value="Order" />
						</td>
					</tr>
				</table>		
			</form:form>
		</c:otherwise>
	 </c:choose>
  	<a href="/">Home</a>
    <a href="/showCustomers">List Customers</a>
    <a href="/showProducts">List Products</a>
    
	  
	 
	    
</body>
</html>