<%--
  Created by IntelliJ IDEA.
  User: 94545
  Date: 2018/10/31
  Time: 23:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="../../css/background.css">
</head>
<body>
<form>
    <p>Product List</p>
    <table width="100%" border=1>
        <tr>
            <td>Name</td>
            <td>Inventory</td>
            <td>Price</td>
        </tr>
        <tr>
            <td>${product.name}</td>
            <td>${product.inventory}</td>
            <td>${product.price}</td>
            <td><a href="${pageContext.request.contextPath}/${purchaseID}/execute">Purchase</a></td>
        </tr>
    </table>
</form>
</body>
</html>
