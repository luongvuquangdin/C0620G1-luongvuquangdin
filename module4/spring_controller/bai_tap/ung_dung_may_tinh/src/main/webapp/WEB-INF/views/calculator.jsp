<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 10/14/2020
  Time: 3:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>danh sach gia vi</title>
</head>
<body>
<form action="/result" id="count">
    <input type="hidden" id="calculation" name="calculation">
    <table>
        <tr>
            <th>Calculator</th>
            <th></th>
            <th></th>
            <th></th>
        </tr>
        <tr>
            <td colspan="2"><input type="text" name="number1" value="${number1}"/></td>
            <td colspan="2"><input type="text" name="number2" value="${number2}"/></td>
        </tr>
        <tr>
            <td><button type="button"  value="addition" onclick="resultScrip('addition')">Addition(+)</button></td>
            <td><button type="button"  value="subtraction" onclick="resultScrip('subtraction')">Subtraction(-)</button></td>
            <td><button type="button"  value="multiplication" onclick="resultScrip('multiplication')">Multiplication(x)</button></td>
            <td><button type="button"  value="division" onclick="resultScrip('division')">Division()/</button></td>
        </tr>
        <tr>
            <td colspan="4"><c:out value="${result}"/></td>
        </tr>
    </table>
</form>
<script>
 function resultScrip(variable) {
        document.getElementById("calculation").value=variable;
        document.getElementById("count").submit();
 }
</script>
</body>
</html>
