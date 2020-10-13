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
<h1>Create new contract</h1>
<p>
    <c:if test='${message!= null}'>
        <span class="message">${message}</span>
    </c:if>
</p>
<p>
    <a href="/home?action=contract">Back to contract list</a>
</p>
<form action="/contract" method="post">
    <input type="hidden" name="actionContract" value="create">
    <fieldset>
        <legend>Contract information</legend>
        <table>
            <tr>
                <td><label for="StartDate">Start Date: </label></td>
                <td><input type="date" name="StartDate" id="StartDate" value='<c:out value="${contract.contractStartDate}"/>'>
                </td>
            </tr>
            <tr>
                <td><label for="EndDate">End Date: </label></td>
                <td><input type="date" name="EndDate" id="EndDate" value='<c:out value="${contract.contractEndDate}"/>'>
                </td>
            </tr>
            <tr>
                <td><label for="Deposit">Deposit: </label></td>
                <td><input type="text" name="Deposit" id="Deposit" value='<c:out value="${contract.contractDeposit}"/>'>
                </td>
            </tr>
            <tr>
                <td><label for="TotalMoney">Total Money: </label></td>
                <td><input type="text" name="TotalMoney" id="TotalMoney" value='<c:out value="${contract.contractTotalMoney}"/>'>
                </td>
            </tr>
            <tr>
                <td><label for="employeeId">employee name: </label></td>
                <td>
                    <select name="employeeIdContract" id="employeeId">
                        <c:forEach var="employee" items="${employeeList}">
                            <c:choose>
                                <c:when test="${employee.employeeId.equals(contract.employeeId)}">
                                    <option value="<c:out value='${employee.employeeId}'/>" selected><c:out value="${employee.employeeName}"></c:out></option>
                                </c:when>
                                <c:otherwise>
                                    <option value="<c:out value='${employee.employeeId}'/>"><c:out value="${employee.employeeName}"></c:out></option>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <td><label for="customerId">customer Name</label></td>
                <td>
                    <select name="customerIdContract" id="customerId">
                        <c:forEach var="customer" items="${customerList}">
                            <c:choose>
                                <c:when test="${customer.customerId.equals(contract.customerId)}">
                                    <option value="<c:out value='${education.customerId}'/>" selected><c:out value="${customer.customerName}"></c:out></option>
                                </c:when>
                                <c:otherwise>
                                    <option value="<c:out value='${customer.customerId}'/>"><c:out value="${customer.customerName}"></c:out></option>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <td><label for="serviceId">service name: </label></td>
                <td>
                    <select name="serviceIdContract" id="serviceId">
                        <c:forEach var="service" items="${serviceList}">
                            <c:choose>
                                <c:when test="${service.serviceId.equals(contract.serviceId)}">
                                    <option value="<c:out value='${service.serviceId}'/>" selected><c:out value="${service.serviceName}"></c:out></option>
                                </c:when>
                                <c:otherwise>
                                    <option value="<c:out value='${service.serviceId}'/>"><c:out value="${service.serviceName}"></c:out></option>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Create contract"></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>

