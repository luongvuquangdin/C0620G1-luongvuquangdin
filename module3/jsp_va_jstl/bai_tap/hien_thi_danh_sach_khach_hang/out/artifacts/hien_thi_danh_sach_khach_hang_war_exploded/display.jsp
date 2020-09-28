<%--
  Created by IntelliJ IDEA.
  User: luong
  Date: 9/25/2020
  Time: 3:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Display customer information</title>
    <style>
        table{
            margin: auto;
            border-style: groove;
            border-color: blue;
            border-width: 5px;
        }
        table,tr,td,th{
            border-collapse: collapse;
        }
        td{
            text-align: center;
            width: 100px;
            height: 100px;
        }
        img{
            width: 100%;
            height: 100%;
        }
        td#one{
            width: 2px;
            height: 2px;
        }
    </style>
</head>
<body>
<table>
    <tr>
        <th>Tên</th>
        <th>Ngày sinh</th>
        <th>Địa chỉ</th>
        <th>Ảnh</th>
    </tr>
    <c:forEach var="customer" items="${customerInfomation}">
        <tr>
            <td id="one" colspan="4"><hr></td>
        </tr>
        <tr>
            <td><c:out value="${customer.name}"></c:out></td>
            <td><c:out value="${customer.dateOfBirth}"></c:out></td>
            <td><c:out value="${customer.address}"></c:out></td>
            <td><img src="<c:out value="${customer.img}"/>"></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
