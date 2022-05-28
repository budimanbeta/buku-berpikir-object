<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>..: Order History :..</h1>
	<table border="1" cellpadding="5px" width="75%">
		

		<c:forEach items="${orders}" var="order">
			<tr>
				<td>Order Number : <c:out value="${order.orderNumber}"></c:out>,
					Order Date : <c:out value="${order.orderDate}"></c:out>
				</td>


			</tr>
			<tr>
				<td>
					<table border=1 width="100%">
						<tr>
							<th>Name</th>
							<th>Type</th>
							<th>Price</th>
							<th>Quantity</th>
							<th>Total</th>
						</tr>
						<c:forEach items="${order.items}" var="item">
							<tr>
								<td><c:out value="${item.name}"></c:out></td>
								<td><c:out value="${item.type}"></c:out></td>
								<td align="right"><c:out value="${item.price}"></c:out></td>
								<td align="right"><c:out value="${item.quantity}"></c:out></td>
								<td align="right"><c:out value="${item.totalPrice}"></c:out></td>
							</tr>
						</c:forEach>
					</table>
				</td>
			</tr>

			<tr>
				<td align="right">Total Price : <c:out value="${order.totalPrice}"></c:out></td>
			</tr>
			<tr>
				<td>&nbsp;&nbsp;</td>
			</tr>
		</c:forEach>

	</table>

</body>
</html>