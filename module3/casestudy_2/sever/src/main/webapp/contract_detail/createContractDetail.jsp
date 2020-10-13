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
<h1>Create new contract detail</h1>
<p>
    <c:if test='${message!= null}'>
        <span class="message">${message}</span>
    </c:if>
</p>
<p>
    <a href="/home?action=contractDetail">Back to contract detail list</a>
</p>
<form action="/contractDetail" method="post">
    <input type="hidden" name="actionContractDetail" value="create">
    <fieldset>
        <legend>Contract Detail information</legend>
        <table>
            <tr>
                <td><label for="quantity">Quantity: </label></td>
                <td><input type="text" name="quantity" id="quantity" value='<c:out value="${contractDetail.quantity}"/>'>
                </td>
            </tr>
            <tr>
                <td><label for="contractId">contract Id: </label></td>
                <td>
                    <select name="contractId" id="contractId">
                        <c:forEach var="contract" items="${contractList}">
                            <c:choose>
                                <c:when test="${contract.contractId.equals(contractDetail.contractId)}">
                                    <option value="<c:out value='${contract.contractId}'/>" selected><c:out value="${contract.contractId}"></c:out></option>
                                </c:when>
                                <c:otherwise>
                                    <option value="<c:out value='${contract.contractId}'/>"><c:out value="${contract.contractId}"></c:out></option>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <td><label for="attachServiceId">attachService Name</label></td>
                <td>
                    <select name="attachServiceId" id="attachServiceId">
                        <c:forEach var="attachService" items="${attachServiceList}">
                            <c:choose>
                                <c:when test="${attachService.attachServiceId.equals(contractDetail.attachServiceId)}">
                                    <option value="<c:out value='${attachService.attachServiceId}'/>" selected><c:out value="${attachService.attachServiceName}"></c:out></option>
                                </c:when>
                                <c:otherwise>
                                    <option value="<c:out value='${attachService.attachServiceId}'/>"><c:out value="${attachService.attachServiceName}"></c:out></option>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Create contract detail"></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>

