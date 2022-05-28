<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <h1>.: Shoping Cart :.</h1>
 
 <a href="cart.do?action=item-form-view">[Add Product]</a>
 <br/> <br/>  
 <table border="1" cellpadding="5px" width="50%">
 	<tr>
		<th>Name</th>
		<th>Type</th>
		<th>Price</th>
		<th>Quantity</th>
		<th>Total</th>
	</tr>
	
	<c:forEach items="${cart.items}" var="item">
	<tr>
		<td>
			<input type="hidden" name="code" value="<c:out value="${item.code}"></c:out>" />
			<c:out value="${item.name}"></c:out>
		</td>
		<td><c:out value="${item.type}"></c:out></td>
		<td align="right"><c:out value="${item.priceFmt}"></c:out></td>
		<td>
			<c:out value="${item.quantity}"></c:out>
		</td>
		<td align="right"><c:out value="${item.totalPriceFmt}"></c:out></td>
	</tr>
	</c:forEach>
	<tr>
		<td colspan="4">Total</td>
		
		<td align="right"><c:out value="${cart.totalPrice}"></c:out></td>
	</tr>
 </table>
 
   <table width="50%">
   
	   <tr>
	   		<td align="right">
	   		 <form  action="cart.do?action=place-order" method="post">
				<input type="submit" value="Place Order (Checkout)">
			</form>
	   		</td>
	   </tr>
    </table>
  
   
</body>
</html>