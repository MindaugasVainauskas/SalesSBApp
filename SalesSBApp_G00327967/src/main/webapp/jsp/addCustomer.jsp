<!DOCTYPE html>
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>	
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>SS RAD Final Project</title>
    
    <link rel="stylesheet" href="/css/styles.css"/>
</head>
<body>
	<h2>Add New Customer</h2>
	
	<form:form modelAttribute="customer">
		<table>
			<tr>
				<td>Cust Name: </td>
				<td><form:input path="cName"/></td>
				<td><form:errors path="cName"></form:errors></td>
			</tr>			
			<tr>
				<td colspan="2">
					<input type="submit" value="Add" />
				</td>
			</tr>
		</table>
	</form:form>
	 
  	<a href="/">Home</a>
    <a href="/showOrders">List Orders</a>
    <a href="/showProducts">List Products</a>
    
	  
	 
	    
</body>
</html>