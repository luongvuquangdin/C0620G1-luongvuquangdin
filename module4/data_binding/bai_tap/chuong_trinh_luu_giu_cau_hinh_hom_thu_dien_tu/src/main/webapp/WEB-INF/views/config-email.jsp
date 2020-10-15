<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>Create a new employee</title>
</head>
<body>
<form:form method="POST" action="/config" modelAttribute="email">
    <h2>Settings</h2>
    <table>
        <tr>
            <th>Languages</th>
            <td colspan="4">
                <form:select path="language">
                    <form:option value="English">English</form:option>
                    <form:option value="Vietnamese">Vietnamese</form:option>
                    <form:option value="Japanese">Japanese</form:option>
                    <form:option value="Chinese">Chinese</form:option>
                </form:select>
            </td>
        </tr>
        <tr>
            <th>Page size</th>
            <td>Show</td>
            <td>
                <form:select path="pageSize">
                    <form:option value="5">5</form:option>
                    <form:option value="10">10</form:option>
                    <form:option value="15">15</form:option>
                    <form:option value="20">20</form:option>
                    <form:option value="50">50</form:option>
                    <form:option value="100">100</form:option>
                </form:select>
            </td>
            <td colspan="2">Emails per page</td>
        </tr>
        <tr>
            <th>Spams filter</th>
            <td><form:checkbox path="spamFilter" value="Enable spams filter"></form:checkbox></td>
            <td colspan="3"><form:label path="spamFilter">Enable spams filter</form:label></td>
        </tr>
        <tr>
            <th>Signature</th>
            <td colspan="4">
                <form:textarea path="signature"></form:textarea>
            </td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="Update"></td>
            <td></td>
            <td><input type="button" value="Cancel" onclick="submitCancel()"></td>
            <td></td>
        </tr>
    </table>
</form:form>
<script>
    function submitCancel() {
            let formEmail=document.getElementById("email");
            formEmail.reset();
            formEmail.submit();
    }
</script>
</body>
</html>