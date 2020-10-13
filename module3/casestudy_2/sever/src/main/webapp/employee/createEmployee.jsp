<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 10/3/2020
  Time: 11:59 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create new Employee</title>
    <style>
        .message{
            color:green;
        }
    </style>
</head>
<body>
<h1>Create new Employee</h1>
<p>
    <c:if test='${message!= null}'>
        <span class="message">${message}</span>
    </c:if>
</p>
<p>
    <a href="/home?action=employee">Back to employee list</a>
</p>
<form action="/employees" method="post">
    <input type="hidden" name="actionEmployee" value="create">
    <fieldset>
        <legend>Employee information</legend>
        <table>
            <tr>
                <td><label for="Name">Name: </label></td>
                <td><input type="text" name="nameEmployee" id="Name" value='<c:out value="${employee.employeeName}"/>'>
                </td>
            </tr>
            <tr>
                <td><label for="Birthday">Birthday: </label></td>
                <td><input type="date" name="birthdayEmployee" id="Birthday" value='<c:out value="${employee.employeeBirthday}"/>'>
                </td>
            </tr>
            <tr>
                <td><label for="IdCard">IdCard: </label></td>
                <td><input type="text" name="idCardEmployee" id="IdCard" value='<c:out value="${employee.employeeIdCard}"/>'>
                </td>
            </tr>
            <tr>
                <td><label for="Salary">Salary: </label></td>
                <td><input type="text" name="salary" id="Salary" value='<c:out value="${employee.employeeSalary}"/>'>
                </td>
            </tr>
            <tr>
                <td><label for="Phone">Phone: </label></td>
                <td><input type="text" name="phoneEmployee" id="Phone" value='<c:out value="${employee.employeePhone}"/>'>
                </td>
            </tr>
            <tr>
                <td><label for="Email">Email: </label></td>
                <td><input type="text" name="emailEmployee" id="Email" value='<c:out value="${employee.employeeEmail}"/>'>
                </td>
            </tr>
            <tr>
                <td><label for="Address">Address: </label></td>
                <td><input type="text" name="addressEmployee" id="Address" value='<c:out value="${employee.employeeAddress}"/>'>
                </td>
            </tr>
            <tr>
                <td><label for="positionId">position Id: </label></td>
                <td>
                    <select name="positionId" id="positionId">
                        <c:forEach var="position" items="${positionList}">
                            <c:choose>
                                <c:when test="${position.getPositionId().equals(employee.getPositionId())}">
                                    <option value="<c:out value='${position.positionId}'/>" selected><c:out value="${position.positionName}"></c:out></option>
                                </c:when>
                                <c:otherwise>
                                    <option value="<c:out value='${position.positionId}'/>"><c:out value="${position.positionName}"></c:out></option>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <td><label for="educationDegreeId">educationDegree Id: </label></td>
                <td>
                    <select name="educationDegreeId" id="educationDegreeId">
                        <c:forEach var="education" items="${educationDegreeList}">
                            <c:choose>
                                <c:when test="${education.getEducationDegreeId().equals(employee.getEducationDegreeId())}">
                                    <option value="<c:out value='${education.educationDegreeId}'/>" selected><c:out value="${education.educationDegreeName}"></c:out></option>
                                </c:when>
                                <c:otherwise>
                                    <option value="<c:out value='${education.educationDegreeId}'/>"><c:out value="${education.educationDegreeName}"></c:out></option>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <td><label for="divisionId">division Id: </label></td>
                <td>
                    <select name="divisionId" id="divisionId">
                        <c:forEach var="division" items="${divisionList}">
                            <c:choose>
                                <c:when test="${division.getDivisionId().equals(employee.getDivisionId())}">
                                    <option value="<c:out value='${division.divisionId}'/>" selected><c:out value="${division.divisionName}"></c:out></option>
                                </c:when>
                                <c:otherwise>
                                    <option value="<c:out value='${division.divisionId}'/>"><c:out value="${division.divisionName}"></c:out></option>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <td><label for="userName">user Name: </label></td>
                <td>
                    <select name="userName" id="userName">
                        <c:forEach var="user" items="${userList}">
                            <c:choose>
                                <c:when test="${user.getUserName().equals(employee.getUserName())}">
                                    <option value="<c:out value='${user.userName}'/>" selected><c:out value="${user.userName}"></c:out></option>
                                </c:when>
                                <c:otherwise>
                                    <option value="<c:out value='${user.userName}'/>"><c:out value="${user.userName}"></c:out></option>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Create employee"></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>

