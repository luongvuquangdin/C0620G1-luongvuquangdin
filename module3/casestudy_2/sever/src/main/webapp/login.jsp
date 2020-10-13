<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Login Page - ngockhuong.com</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <style>
        /*
     * Ví dụ tạo trang đăng nhập theo mô hình MVC
     * ngockhuong.com
     */
        body{
            font-family: Arial, sans-serif;
            font-size: 11pt;
            margin-left: 2em;
            margin-right: 2em;
            width: 400px;
            border: 2px solid black;}
        h1, h2, h3, h4, h5, h6{
            color: teal;
            text-align: center; }
        label{
            float: left;
            width:10em;
            text-align: right;
            margin-bottom: .5em; }
        input{
            width: 15em;
            margin-left: .5em;
            margin-bottom: 1em;
            margin-bottom: 1em;}
        #id{
            width: 10em;
            text-align: center; }
        br{clear: both;}
    </style>
</head>
<body>
<h1> Login to </h1>
<c:if test="${message.equals('error')}">
    <h4 style="color: red;">Đăng nhập thất bại</h4>
</c:if>
<form action="/login" method="post">
    <label> Username: </label>
    <input type="text" name="username"> <br>
    <label> Password: </label>
    <input type="password" name="password"> <br>
    <label>&nbsp; </label>
    <input type="submit" value="Login" name="submit">
</form>
</body>
</html>