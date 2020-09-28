<%--
  Created by IntelliJ IDEA.
  User: luong
  Date: 9/28/2020
  Time: 4:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/products" method="post">
    <fieldset>
        <legend>Product Information</legend>
        <table>
                <tr>
                    <td>
                        Name
                    </td>
                    <td>
                        <input type="text" name="nameProduct">
                    </td>
                </tr>
                <tr>
                    <td>
                        Price
                    </td>
                    <td>
                        <input type="text" name="priceProduct">
                    </td>
                </tr>
                <tr>
                    <td>
                        ProductManufacturer
                    </td>
                    <td>
                        <input type="text" name="productManufacturerProduct">
                    </td>
                </tr>
                <tr>
                    <td>
                        Description
                    </td>
                    <td>
                        <input type="text" name="descriptionProduct">
                    </td>
                </tr>
                <tr>
                    <td></td>
                    <td>
                        <form action="/products" method="get">
                            <input type="hidden" name="action" value='""'>
                            <input type="submit" value="back">
                        </form>
                    </td>
                    <td>
                        <form action="/products" method="get">
                            <input type="hidden" name="action" value="create">
                            <input type="submit" value="save">
                        </form>
                    </td>
                </tr>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
