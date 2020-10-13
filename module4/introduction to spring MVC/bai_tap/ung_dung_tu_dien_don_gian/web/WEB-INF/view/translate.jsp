<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 10/13/2020
  Time: 9:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>translate</title>
</head>
<body>
<form action="/translate">
    <table>
        <tr>
            <th><label for="english">Vocabulary English: </label></th>
            <td><input type="text" name="english" id="english" value="${english}"></td>
        </tr>
        <tr>
            <th><label for="mean">VietNamese: </label></th>
            <td><input type="text" name="vietNamese" id="mean" value="${vietNamese}" readonly></td>
        </tr>
        <tr>
            <th></th>
            <td><input type="submit" value="translate"></td>
        </tr>
    </table>
</form>
</body>
</html>
