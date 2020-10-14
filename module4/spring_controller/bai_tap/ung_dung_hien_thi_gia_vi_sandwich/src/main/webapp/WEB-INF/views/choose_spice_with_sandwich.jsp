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
<form action="/spice">
    <input type="checkbox" name="condiment" value="Lettuce" id="Lettuce"><label for="Lettuce">Lettuce</label>
    <input type="checkbox" name="condiment" value="Tomato" id="Tomato"><label for="Tomato">Tomato</label>
    <input type="checkbox" name="condiment" value="Mustard" id="Mustard"><label for="Mustard">Mustard</label>
    <input type="checkbox" name="condiment" value="Sprouts" id="Sprouts"><label for="Sprouts">Sprouts</label>
    <input type="submit" value="Save">
</form>
</body>
</html>
