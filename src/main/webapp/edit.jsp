<%--
  Created by IntelliJ IDEA.
  User: mylook
  Date: 8/4/2022
  Time: 10:10 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/product?action=edit" method="post">
    <table>
        <tr>
            <td><label for="id">ID</label></td>
            <td><input type="text" name="id" id="id" value="${p.getId()}" size="20" readonly></td>
        </tr>
        <tr>
            <td><label for="name">Name</label></td>
            <td><input type="text" name="name" id="name" value="${p.getName()}"></td>
        </tr>
        <tr>
            <td><label for="price">Price</label></td>
            <td><input type="text" name="price" id="price" value="${p.getPrice()}"></td>
        </tr>
        <tr>
            <td><label for="quantity">Quantity</label></td>
            <td><input type="text" name="quantity" id="quantity" value="${p.getQuantity()}"></td>
        </tr>
        <tr>
            <td><label for="color">Color</label></td>
            <td><input type="text" name="color" id="color" value="${p.getColor()}"></td>
        </tr>
        <tr>
            <td><label for="description">Description</label></td>
            <td><input type="text" name="description" id="description" value="${p.getDescription()}"></td>
        </tr>
        <tr>
            <td><label for="category">Category</label></td>
            <td>
                <select name="category" id="category">
                    <c:forEach items="${categories}" var="c">
                        <option value="${c.getId()}">${c.getName()}</option>
                    </c:forEach>
                </select>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <button type="submit">Update</button>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
