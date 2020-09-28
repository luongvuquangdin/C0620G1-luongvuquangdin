<%--
  Created by IntelliJ IDEA.
  User: luong
  Date: 9/25/2020
  Time: 10:01 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Discount Amount: <%= request.getAttribute("discount")%>
</h1>
<h1>Discount Price: <%= request.getAttribute("amount")%></h1>
</body>
</html>
