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
    <title>Create new service</title>
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
    <a href="/home?action=service">Back to service list</a>
</p>
<form action="/service" method="post">
    <input type="hidden" name="actionService" value="create">
    <fieldset>
        <legend>Service information</legend>
        <table>
            <tr>
                <td><label for="id">Id: </label></td>
                <td><input type="text" name="idService" id="id" value='<c:out value="${service.serviceId}"/>'>
                </td>
            </tr>
            <tr>
                <td><label for="Name">Name: </label></td>
                <td><input type="text" name="nameService" id="Name" value='<c:out value="${service.serviceName}"/>'>
                </td>
            </tr>
            <tr>
                <td><label for="Area">Area: </label></td>
                <td><input type="text" name="areaService" id="Area" value='<c:out value="${service.serviceArea}"/>'>
                </td>
            </tr>
            <tr>
                <td><label for="serviceCost">service cost: </label></td>
                <td><input type="text" name="serviceCost" id="serviceCost" value='<c:out value="${service.serviceCost}"/>'>
                </td>
            </tr>
            <tr>
                <td><label for="serviceMaxPeople">Max People: </label></td>
                <td><input type="text" name="maxPeople" id="serviceMaxPeople" value='<c:out value="${service.serviceMaxPeople}"/>'>
                </td>
            </tr>
            <tr>
                <td><label for="standardRoom">Standard room: </label></td>
                <td><input type="text" name="standardRoom" id="standardRoom" value='<c:out value="${service.standardRoom}"/>'>
                </td>
            </tr>
            <tr>
                <td><label for="descriptionOtherConvenience">description other convenience: </label></td>
                <td><input type="text" name="description" id="descriptionOtherConvenience" value='<c:out value="${service.descriptionOtherConvenience}"/>'>
                </td>
            </tr>
            <tr>
                <td><label for="poolArea">pool area: </label></td>
                <td><input type="text" name="poolAreaService" id="poolArea" value='<c:out value="${service.poolArea}"/>'>
                </td>
            </tr>
            <tr>
                <td><label for="numberOfFloors">number of floors: </label></td>
                <td><input type="text" name="numberOfFloorsService" id="numberOfFloors" value='<c:out value="${service.numberOfFloors}"/>'>
                </td>
            </tr>
            <tr>
                <td><label for="rentTypeId">Rent type: </label></td>
                <td>
                    <select name="rentTypeId" id="rentTypeId">
                        <c:forEach var="rentType" items="${rentTypeList}">
                            <c:choose>
                                <c:when test="${rentType.getRentTypeId().equals(sirvice.getRentTypeId())}">
                                    <option value="<c:out value='${rentType.rentTypeId}'/>" selected><c:out value="${rentType.rentTypeName}"></c:out></option>
                                </c:when>
                                <c:otherwise>
                                    <option value="<c:out value='${rentType.rentTypeId}'/>"><c:out value="${rentType.rentTypeName}"></c:out></option>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <td><label for="serviceTypeId">Service Type: </label></td>
                <td>
                    <select name="serviceTypeId" id="serviceTypeId">
                        <c:forEach var="serviceType" items="${serviceTypeList}">
                            <c:choose>
                                <c:when test="${serviceType.getServiceTypeId().equals(sirvice.getServiceTypeId())}">
                                    <option value="<c:out value='${serviceType.serviceTypeId}'/>" selected><c:out value="${serviceType.serviceTypeName}"></c:out></option>
                                </c:when>
                                <c:otherwise>
                                    <option value="<c:out value='${serviceType.serviceTypeId}'/>"><c:out value="${serviceType.serviceTypeName}"></c:out></option>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Create service"></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>

