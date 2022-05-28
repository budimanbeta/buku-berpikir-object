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

<form:form modelAttribute="newProduct" action="save-product" method="POST">
<h1>NEW PRODUCT</h1>
<hr><br>
	<table>
		<tr>
			<td>CODE</td>
		</tr>
		<tr>
			<td><form:input path="code"/></td>
		</tr>
		<tr>
			<td>NAME</td>
		</tr>
		<tr>
			<td><form:input path="name"/></td>
		</tr>
		<tr>
			<td>TYPE</td>
		</tr>
		<tr>
			<td>			
			<form:select path="type">
				<form:option value="makanan">MAKANAN</form:option>
				<form:option value="minuman">MINUMAN</form:option>
				<form:option value="atk">ATK</form:option>
				<form:option value="art">ART</form:option>
			</form:select>
			</td>
		</tr>
		<tr>
			<td>PRICE</td>
		</tr>
		<tr>
			<td><form:input path="price"/></td>
		</tr>
		<tr>
			<td><input type="submit" value="SAVE"></td>
		</tr>
	</table>
</form:form>

</center>
</body>
<script type="text/javascript">

</script>
</html>