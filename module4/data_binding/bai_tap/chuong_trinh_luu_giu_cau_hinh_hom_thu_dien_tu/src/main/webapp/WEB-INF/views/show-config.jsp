<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>Infor</title>
</head>
<body>
<h2>Config Email</h2>
<table>
    <tr>
        <td>Languages :</td>
        <td id="Languages">${email.language}</td>
    </tr>
    <tr>
        <td>Page size :</td>
        <td>${email.pageSize}</td>
    </tr>
    <tr>
        <td>Spams filter :</td>
        <td>${email.spamFilter}</td>
    </tr>
    <tr>
        <td>Signature :</td>
        <td>${email.signature}</td>
    </tr>
    <tr>
        <td></td>
        <td><input type="button" onclick="document.getElementById('email').submit()" value="Edit"/></td>
    </tr>
</table>
<form:form action="/edit" modelAttribute="email" style="display: none">
    <form:input path="language"/>
    <form:input path="pageSize"/>
    <form:input path="spamFilter"/>
    <form:input path="signature"/>
</form:form>
</body>
</html>