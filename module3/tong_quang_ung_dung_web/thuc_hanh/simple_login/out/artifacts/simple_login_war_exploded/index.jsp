<%--
  Created by IntelliJ IDEA.
  User: luong
  Date: 9/24/2020
  Time: 4:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html"%>
<html>
  <head>
    <title>Bảng đăng ký</title>
    <style type="text/css">
      .login {
        height:180px; width:230px;
        margin:0;
        padding:10px;
        border:1px #CCC solid;
      }
      .login input {
        padding:5px; margin:5px
      }
    </style>
  </head>
  <body>
  <form action="/login" method="post">
    <div class="login">
      <h2>Login</h2>
      <input type="text" name="username" size="30"  placeholder="username" />
      <input type="password" name="password" size="30" placeholder="password" />
      <input type="submit" value="Sign in"/>
    </div>
  </form>
  </body>
</html>
