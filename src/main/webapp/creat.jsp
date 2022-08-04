<%--
  Created by IntelliJ IDEA.
  User: mylook
  Date: 8/4/2022
  Time: 8:58 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Creat</title>
</head>
<body>
<form action="/product?action=creat" method="post">
  <table border="1 solid">
    <tr>
      <th>Name</th>
      <td><input type="text" name="name"></td>
    </tr>
    <tr>
      <th>Price</th>
      <td><input type="text" name="price"></td>
    </tr>
    <tr>
      <th>Quantity</th>
      <td><input type="text" name="quantity"></td>
    </tr>
    <tr>
      <th>Color</th>
      <td><input type="text" name="color"></td>
    </tr>
    <tr>
      <th>Category</th>
      <td>
        <select name="category" id="">
          <c:forEach items="${categories}" var="c">
            <option value="${c.getId()}">${c.getName()}</option>
          </c:forEach>
        </select>
      </td>
    </tr>
    <tr>
      <th>Description</th>
      <td><input type="text" name="description"></td>
    </tr>
  </table>
  <button type="submit">Tạo Mới</button>
  <button><a href="/product?action=display">Back</a></button>
</form>
</body>
</html>
