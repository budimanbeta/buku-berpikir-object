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

<h1>PRODUCT ITEM</h1>
<hr>
<form:form modelAttribute="orderItemDto" action="select-product" method="POST">
	<table>
		<tr>
			<td>Product</td>
		</tr>
		<tr>
			<td>
				<select name="id">
					<option>CHOOSE PRODUCT</option>
					
					<c:forEach items="${products}" var="c">				
					<option value="<c:out value="${c.id}"></c:out>">
						<c:out value="${c.id} - ${c.name} - Rp.${c.price}"></c:out>
					</option>
					</c:forEach>
					
				</select>
			</td>
		</tr>
		<tr>
			<td>Quantity</td>
		</tr>
		<tr>
			<td><form:input path="quantity"/></td>
		</tr>		
		<tr>
			<td>
				<input type="submit" value="ADD">
			</td>
		</tr>
	</table>
</form:form>

</center>
</body>
</html>