<%--
  Created by IntelliJ IDEA.
  User: luong
  Date: 9/28/2020
  Time: 4:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Danh sách sản phẩm</title>
    <style>
        table, tr, th, td {
            border: 1px solid black;
            border-collapse: collapse;
        }

        table {
            margin: 0px auto;
        }

        tr, th, td {
            width: 200px;
            height: 200px;
        }
    </style>
</head>
<body>
<h1 style="text-align: center">Danh sách sản phẩm</h1>
<form action="/products" method="get">
    <input type="hidden" value="create" name="action">
    <input type="submit" value="Create New Product">
</form>
<table>
    <tr>
        <th>name</th>
        <th>price</th>
        <th>productManufacturer</th>
    </tr>
    <c:forEach var="products" items="${productList}">
        <tr>
            <td>
                <c:out value="${products.name}"></c:out>
            </td>
            <td>
                <c:out value="${products.price}"></c:out>
            </td>
            <td>
                <c:out value="${products.productManufacturer}"></c:out>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
