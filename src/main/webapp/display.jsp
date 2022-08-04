<%--
  Created by IntelliJ IDEA.
  User: mylook
  Date: 8/4/2022
  Time: 8:44 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Product List</title>
</head>
<body>
<button><a href="product?action=creat">Creat Product</a></button>
<table border="1 solid">
    <tr>
        <td>#</td>
        <td>Product Name</td>
        <td>Price</td>
        <td>Quantity</td>
        <td>Color</td>
        <td>Mô Tả Sản Phẩm</td>
        <td>Danh Mục</td>
        <td colspan="2">Action</td>
    </tr>
    <c:forEach items="${products}" var="p">
        <tr>
            <td>${p.getId()}</td>
            <td>${p.getName()}</td>
            <td>${p.getPrice()}</td>
            <td>${p.getQuantity()}</td>
            <td>${p.getColor()}</td>
            <td>${p.getDescription()}</td>
            <td>${p.getCategory().getName()}</td>
            <td><button ><a href="/product?action=edit&id=${p.getId()}">Edit</a></button></td>
            <td><button><a href="/product?action=delete&id=${p.getId()}">Delete</a></button></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
