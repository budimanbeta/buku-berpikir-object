<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Shopping Cart</title>
</head>
<body>


<form:form  action="submit-order" method="post">
<h1>FORM ORDER</h1>
<hr><br>
<table border="1" cellpadding="5px" width="75%">
	<tr>
		<th>NAME</th>
		<th>PRICE</th>
		<th>QTY</th>
		<th>TOTAL</th>
	</tr>
	<c:forEach items="${cart.orderItemsDto}" var="item">
	<tr>
		<td>
			<input type="hidden" name="id" value="<c:out value="${item.id}"></c:out>" />
			<c:out value="${item.name}"></c:out>
		</td>
		<td><c:out value="${item.price}"></c:out></td>
		<td>
			<input type="hidden" name="quantity" value="<c:out value="${item.quantity}"></c:out>" />
			<c:out value="${item.quantity}"></c:out>
		</td>
		<td><c:out value="${item.totalPrice}"></c:out></td>
	</tr>
	</c:forEach>
	
	<tr>
	<td colspan = 4/>
	</tr>
	<tr>
		<td colspan = 3> Total</td>
		
		<td><c:out value="${cart.totalPrice}"></c:out></td>
	</tr>
	<tr>
		<td colspan = 3>
		<td align="center">
			<a href="choose-product"><input type="button" name="add" id="add" value="ADD PRODUCT"></a>
		</td>
	</tr>
	<tr>
		<td colspan = 3></td>	
		<td>
			<p align="center">
				<input type="submit" value="CHECK OUT">
			</p>
		</td>
		
	</tr>
</table>
	
</form:form>

</body>
</html>