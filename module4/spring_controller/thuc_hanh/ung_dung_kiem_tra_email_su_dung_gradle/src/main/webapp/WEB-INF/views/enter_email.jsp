<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 10/14/2020
  Time: 1:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Nhập email</title>
</head>
<body>
<form action="/check_email">
    <table>
        <tr>
            <th><label for="email">Enter Email to check :</label></th>
            <td><input type="text" id="email" name="email" value="<c:out value='${email}'/>"></td>
        </tr>
        <tr>
            <th></th>
            <td>
                <c:out value="${message}"/>
            </td>
        </tr>
        <tr>
            <th></th>
            <td><input type="submit" value="Check"></td></tr>
    </table>
</form>
</body>
</html>
