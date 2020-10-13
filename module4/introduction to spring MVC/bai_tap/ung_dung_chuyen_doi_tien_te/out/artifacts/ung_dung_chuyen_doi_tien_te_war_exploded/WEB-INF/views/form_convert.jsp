<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 10/13/2020
  Time: 4:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Form convert</title>
</head>
<body>
<form action="/convert">
    <table>
        <tr>
            <th><label for="vietNam">Việt Nam đồng: </label></th>
            <td><input type="text" name="vietNam" id="vietNam" value="${vietNam}"></td>
        </tr>
        <tr>
            <th><label for="usd">USD: </label></th>
            <td><input type="text" name="usd" id="usd" value="${usd}"></td>
        </tr>
        <tr>
            <th></th>
            <td><input type="text" readonly value="${resultFinal}" style="border: none" size="40"></td>
        </tr>
        <tr>
            <th></th>
            <td>
                <input type="submit" value="Convert">
            </td>
        </tr>
    </table>

</form>
</body>
</html>
