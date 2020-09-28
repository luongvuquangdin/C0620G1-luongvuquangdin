<%--
  Created by IntelliJ IDEA.
  User: luong
  Date: 9/25/2020
  Time: 9:51 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<form action="/calculator" method="post">
    <p>Product Description</p>
    <input type="text" name="Product" placeholder="Product Description">
    <p>List Price</p>
    <input type="text" name="Price" placeholder="List Price">
    <p>Discount Percent</p>
    <input type="text" name="Percent" placeholder="Discount Percent">
    <br>
    <input type="submit" value="Calculate Discount">
</form>
</body>
</html>
