<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>TOKOKU</title>
</head>
<body>
<center>

<form:form modelAttribute="prosess" action="prosessOrders" method="post">
<h1>FORM ORDER</h1>
<hr><br>
<h3>PRODUCT ITEM</h3>
<table border="1" cellpadding="5px" width="20%">
	<tr>
		<th>NAME</th>
		<th>PRICE</th>
		<th>QTY</th>
		<th>TOTAL</th>
	</tr>
	<c:forEach items="${orderItem}" var="c">
	<tr>
		<td>
			<input type="hidden" name="id" value="<c:out value="${c.getProduct().id}"></c:out>" />
			<c:out value="${c.getProduct().name}"></c:out>
		</td>
		<td><c:out value="${c.getProduct().price}"></c:out></td>
		<td>
			<input type="hidden" name="quantity" value="<c:out value="${c.quantity}"></c:out>" />
			<c:out value="${c.quantity}"></c:out>
		</td>
		<td><c:out value="${c.totalPrice}"></c:out></td>
	</tr>
	</c:forEach>
	<tr>
		<td>Total</td>
		<td></td>
		<td></td>
		<td><c:out value="${orders.totalPrice}"></c:out></td>
	</tr>
	<tr>
		<td></td>
		<td></td>
		<td></td>
		<td>
			<a href="chooseProduct"><input type="button" name="add" id="add" value="ADD PRODUCT"></a>
		</td>
	</tr>
	<tr>
		<td></td>
		<td></td>
		<td>
		<p align="center">
			<input type="submit" value="PROCESS">
		</p>
		</td>
		<td></td>
	</tr>
</table>
	
</form:form>
</center>
</body>
</html>