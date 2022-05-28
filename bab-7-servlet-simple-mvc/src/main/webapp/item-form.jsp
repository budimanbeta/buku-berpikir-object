<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Item Form</title>
</head>
<body>

<h2>.: Product :.</h2>
 <form method="post" action="cart.do?action=add-new-item">
    <table>
    <tr>
        <td>Product Code:</td>
        <td><input type="text" name="code"/></td>
    </tr>
    <tr>
        <td>Product Name:</td>
        <td><input type="text" name="name"/></td>
    </tr>
     <tr>
        <td>Product Type:</td>
        <td><input type="text" name="type"/></td>
    </tr>
     <tr>
        <td>Product Price:</td>
        <td><input type="text" name="price"/></td>
    </tr>
    <tr>
        <td>Quantity:</td>
        <td><input type="text" name="quantity"/></td>
    </tr>
    
    <tr>
        
        <td align="right"><input type="submit" value="Add Product"/></td>
    </tr>
    </table>
    </form>
</body>
</html>