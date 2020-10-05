<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 10/1/2020
  Time: 8:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Trang chủ</title>
    <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css"
          integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous"/>
    <link rel="stylesheet" href="bootstrap413/css/bootstrap.min.css" />
    <link rel="stylesheet" href="datatables/css/dataTables.bootstrap4.min.css" />
    <style>
        #head {
            font-size: 13px;
            height: 20%;
        }

        #border-1 {
            border-top-color: green;
            border-width: 5px 1px 1px 1px;
            border-style: solid;
        }
        #bodyfurama{
            background-image: url("https://furamavietnam.com/wp-content/uploads/2019/07/Vietnam_Danang_Furama_Resort_Exterior_Ocean-Pool-6.jpg");
            background-repeat: no-repeat;
            background-size: 100%;
            height: 90%;
        }
    </style>
</head>
<body>
<%--head--%>
<div class="container-fluid">
    <div class="row pt-lg-2 border border-dark" id="head">
        <div class="col-lg-3 text-center">
            <a href="/home"><img src="https://furamavietnam.com/wp-content/uploads/2018/08/logo@2x.png"
                                 height="100%"></a>
        </div>
        <div class="col-lg-2">
            <div class="pb-lg-4 pt-lg-4 pl-lg-5" id="border-1">
                <div class="row" style="height: 15%">
                    <div class="col-lg-12">
                        <img src="https://smartdata.tonytemplates.com/bestel/wp-content/uploads/2018/05/widget-tripadvisor-logo.png"
                             height="100%">
                    </div>
                </div>
                <div class="row" style="height: 15%">
                    <div class="col-lg-12">
                        <img src="https://furamavietnam.com/wp-content/uploads/2018/08/widget-tripadvisor-rating.png"
                             height="100%">
                    </div>
                </div>
                <div class="row">
                    <div class="col-lg-12" style="height: 30%">
                        2,746 Reviews
                    </div>
                </div>
            </div>

        </div>
        <div class="col-lg-3" style="height: 100%">
            <div class="row">
                <div class="col-lg-2 pr-lg-0 text-right"><i class="fas fa-map-marker-alt"></i></div>
                <div class="col-lg-10">
                    <p>103 – 105 Đường Võ Nguyên Giáp, Phường Khuê Mỹ, Quận Ngũ hành Sơn, Tp. Đà Nẵng, Việt Nam</p>
                    <p>7.0 km từ Sân bay Quốc tế Đà Nẵng</p>
                </div>
            </div>
        </div>
        <div class="col-lg-4" style="height: 100%">
            <i class="fas fa-phone-alt"></i>
            <span>84-236-3847 333/888</span>
            <br>
            <i class="fas fa-envelope"></i>
            <span>reservation@furamavietnam.com</span>
        </div>
    </div>


<%--    Thanh home--%>
    <div class="row bg-light border border-dark">
        <div class="col-lg-12">
            <ul class="nav justify-content-between bg-light">
                <li class="nav-item">
                    <a class="nav-link text-dark" href="/home?action=home">Home</a>
                </li>
                <li class="nav-item active">
                    <a class="nav-link text-dark" href="/home?action=customer">Customer</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link  text-dark" href="/home?action=employee">Employee</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link  text-dark" href="/home?action=service">Service</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link  text-dark" href="/home?action=contract">Contract</a>
                </li>
            </ul>
        </div>
    </div>

<%--    body--%>
    <div class="row" id="bodyfurama">
        <div class="col-lg-1 border border-dark">
            <nav class="nav flex-column">
                <a class="nav-link  text-white" href="#">Item 1</a>
                <a class="nav-link  text-white" href="#">Item 2</a>
                <a class="nav-link  text-white" href="#">Item 3</a>
                <a class="nav-link  text-white" href="#">Item 4</a>
                <a class="nav-link  text-white" href="#">Item 5</a>
                <a class="nav-link  text-white" href="#">Item 6</a>
                <a class="nav-link  text-white" href="#">Item 7</a>
                <a class="nav-link  text-white" href="#">Item 8</a>
                <a class="nav-link  text-white" href="#">Item 9</a>
                <a class="nav-link  text-white" href="#">Item 10</a>
                <a class="nav-link  text-white" href="#">Item 11</a>
            </nav>
        </div>
        <div class="col-lg-11">
            <c:choose>
                <c:when test="${action.equals('customer')}">
                        <div class="row">
                            <div class="col-lg-12">
                                <h2>
                                    <a href="/customers?actionCustomer=create">Add New Customer</a>
                                </h2>
                                <form action="/customers" method="post">
                                    <input type="hidden" name="actionCustomer" value="find">
                                    <input type="text" name="customerName" placeholder="Enter to customer name">
                                    <input type="submit" value="Search">
                                </form>
                                <table id="tableCustomer" class="table table-bordered table-light border border-dark text-dark" style="width:100%">
                                    <thead>
                                    <h2>List of Cusomter</h2>
                                    <tr>
                                        <th>ID</th>
                                        <th>Name</th>
                                        <th>Birthday</th>
                                        <th>Gender</th>
                                        <th>IdCard</th>
                                        <th>Phone</th>
                                        <th>Email</th>
                                        <th>Address</th>
                                        <th>TypeId</th>
                                        <th></th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach var="customers" items="${customerList}">
                                        <tr>
                                            <td><c:out value='${customers.customerId}'/></td>
                                            <td><c:out value='${customers.customerName}'/></td>
                                            <td><c:out value='${customers.customerBirthday}'/></td>
                                            <td><c:out value="${customers.customerGender}"/></td>
                                            <td><c:out value="${customers.customerIdCard}"/></td>
                                            <td><c:out value="${customers.customerPhone}"/></td>
                                            <td><c:out value="${customers.customerEmail}"/></td>
                                            <td><c:out value="${customers.customerAddress}"/></td>
                                            <td><c:out value="${customers.customerTypeId}"/></td>
                                            <td>
                                                <a href="/customers?actionCustomer=edit&idCustomer=${customers.customerId}">Edit</a>
                                                <a href="#" onclick="customerSetId('${customers.customerId}')" data-toggle="modal" data-target="#deleteModel">Delete</a>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </table>
                </c:when>
                <c:when test="${action.equals('employee')}">
                    <div class="row">
                        <div class="col-lg-12">
                            <h2>
                                <a href="/employees?actionEmployee=create">Add New Employee</a>
                            </h2>
                            <form action="/employees" method="post">
                                <input type="hidden" name="actionEmployee" value="find">
                                <input type="text" name="employeeName" placeholder="Enter to employee name">
                                <input type="submit" value="Search">
                            </form>
                            <table id="tableEmployee" class="table table-bordered table-light border border-dark text-dark" style="width:100%">
                                <thead>
                                <h2>List of Employee</h2>
                                <tr>
                                    <th>Name</th>
                                    <th>Birthday</th>
                                    <th>Id Card</th>
                                    <th>Salary</th>
                                    <th>Phone</th>
                                    <th>Email</th>
                                    <th>Address</th>
                                    <th>position</th>
                                    <th>education
                                        Degree</th>
                                    <th>division</th>
                                    <th>userName</th>
                                    <th></th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach var="employees" items="${employeeList}">
                                    <tr>
                                        <td><c:out value='${employees.employeeName}'/></td>
                                        <td><c:out value='${employees.employeeBirthday}'/></td>
                                        <td><c:out value="${employees.employeeIdCard}"/></td>
                                        <td><c:out value="${employees.employeeSalary}"/></td>
                                        <td><c:out value="${employees.employeePhone}"/></td>
                                        <td><c:out value="${employees.employeeEmail}"/></td>
                                        <td><c:out value="${employees.employeeAddress}"/></td>
                                        <td><c:out value="${employees.positionId}"/></td>
                                        <td><c:out value="${employees.educationDegreeId}"/></td>
                                        <td><c:out value="${employees.divisionId}"/></td>
                                        <td><c:out value="${employees.userName}"/></td>
                                        <td>
                                            <a href="/employees?actionEmployee=edit&idEmployee=${employees.employeeId}">Edit</a>
                                            <a href="#" onclick="employeeSetId('${employees.employeeId}','${employees.employeeName}')" data-toggle="modal" data-target="#deleteModel">Delete</a>
                                        </td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                    </table>
                </c:when>
                <c:when test="${action.equals('service')}">
                    <div class="row">
                        <div class="col-lg-12">
                            <h2>
                                <a href="/service?actionService=create">Add New Service</a>
                            </h2>
                            <table id="tableService" class="table table-bordered table-light border border-dark text-dark" style="width:100%">
                                <thead>
                                <h2>List of Service</h2>
                                <tr>
                                    <th>ID</th>
                                    <th>Name</th>
                                    <th>Area</th>
                                    <th>Cost</th>
                                    <th>MaxPeople</th>
                                    <th>standard Room</th>
                                    <th>description Other Convenience</th>
                                    <th>pool Area</th>
                                    <th>number Of Floors</th>
                                    <th>rent Type Name</th>
                                    <th>service Type Name</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach var="service" items="${serviceList}">
                                    <tr>
                                        <td><c:out value='${service.serviceId}'/></td>
                                        <td><c:out value='${service.serviceName}'/></td>
                                        <td><c:out value='${service.serviceArea}'/></td>
                                        <td><c:out value="${service.serviceCost}"/></td>
                                        <td><c:out value="${service.serviceMaxPeople}"/></td>
                                        <td><c:out value="${service.standardRoom}"/></td>
                                        <td><c:out value="${service.descriptionOtherConvenience}"/></td>
                                        <td><c:out value="${service.poolArea}"/></td>
                                        <td><c:out value="${service.numberOfFloors}"/></td>
                                        <td><c:out value="${service.rentTypeId}"/></td>
                                        <td><c:out value="${service.serviceTypeId}"/></td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                    </table>
                </c:when>
                <c:otherwise>
                    <h1>Welcome to Furama</h1>
                </c:otherwise>
            </c:choose>
            <form action="/customers" method="post" id="deleteCustomer">
                <input type="hidden" name="actionCustomer" value="delete">
                <input type="hidden" name="idCustomer" id="idCustomer">
            </form>
            <form action="/employees" method="post" id="deleteEmployee">
                <input type="hidden" name="actionEmployee" value="delete">
                <input type="hidden" name="idEmployee" id="idEmployee">
            </form>
        </div>
    </div>
</div>
<!-- Modal -->
<div class="modal fade" id="deleteModel" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <input type="text" id="modelId" size="50" disabled style="border: none;background: white">
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                <button type="button" class="btn btn-primary" onclick="submitDelete('${action}')">Delete</button>
            </div>
        </div>
    </div>
</div>
<%--<script src="jquery/jquery-3.5.1.min.js"></script>--%>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
<script src="datatables/js/jquery.dataTables.min.js"></script>
<script src="datatables/js/dataTables.bootstrap4.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
<script>
    $(document).ready(function() {
        $('#tableCustomer').dataTable( {
            "dom": 'lrtip',
            "lengthChange": false,
            "pageLength": 5
        } );
    } );
    $(document).ready(function() {
        $('#tableEmployee').dataTable( {
            "dom": 'lrtip',
            "lengthChange": false,
            "pageLength": 5
        } );
    } );
    $(document).ready(function() {
        $('#tableService').dataTable( {
            "dom": 'lrtip',
            "lengthChange": false,
            "pageLength": 5
        } );
    } );

</script>
<script>
    function customerSetId(id) {
        document.getElementById("idCustomer").value=id;
        document.getElementById("modelId").value="Do you want delete Customer Id: "+id;
    }
    function submitDelete(action) {
        if (action==='customer') {
            document.getElementById("deleteCustomer").submit();
        }
        else if (action==='employee'){
            document.getElementById("deleteEmployee").submit();
        }

    }
    function editCustomer(id) {
        document.getElementById(id).disabled=false;
    }

    // Employee

    function employeeSetId(id,name) {
        document.getElementById("idEmployee").value=id;
        document.getElementById("modelId").value="Do you want delete employee name: "+name;
    }

</script>
</body>
</body>
</html>
