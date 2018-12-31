<%--
  Created by IntelliJ IDEA.
  User: 94545
  Date: 2018/10/18
  Time: 15:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="../../css/background.css">
    <title>Product List</title>
</head>
<body>
    <form>
        <p>Product List</p>
        <table width="100%" border=1>
            <tr>
                <td>PurchaseID</td>
                <td>ProductID</td>
                <td>Name</td>
                <td>Price</td>
                <td>StartTime</td>
                <td>EndTime</td>
                <td>CreateTime</td>
            </tr>
            <c:forEach items="${list}" var="item">
                <tr>
                    <td>${item.purchaseID}</td>
                    <td>${item.productID}</td>
                    <td>${item.name}</td>
                    <td>${item.price}</td>
                    <td>${item.startTime}</td>
                    <td>${item.endTime}</td>
                    <td>${item.createTime}</td>
                    <td><a href="${pageContext.request.contextPath}/${item.productID}/detail.action">Purchase</a></td>
                </tr>
            </c:forEach>
        </table>
    </form>
</body>
</html>
