<%--
  Created by IntelliJ IDEA.
  User: Svetlana
  Date: 30-Jul-15
  Time: 11:40 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Additional</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
    <style>
        div {
            margin-top: 5%; /* Отступ сверху */
        }
    </style>
</head>
<body>
<div class="container">
    <td><span style=";font-family:Monotype Corsiva;font-size:22px;color:blue;">Additional</span></td>
    <form class="form-inline" role="form" action="/main/select" method="post">
        <table class="table table-striped">
            <thead>
            <tr>
                <td><b>Selected</b></td>
                <td><b>Name</b></td>
                <td><b>Price</b></td>
                <td><b>Cuisines</b></td>
            </tr>
            </thead>
            <c:forEach items="${order44}" var="ordr">
                <tr>
                    <td><input type="checkbox" name="selected" value="${ordr.id}"></td>
                    <td>${ordr.name}</td>
                    <td>${ordr.price}</td>
                    <td>Additional</td>
                </tr>
            </c:forEach>
        </table>
        <table><tr>
            <td> <input type="submit" class="btn btn-default" value="Select">
        </table>
    </form>
    <form class="form-inline" role="form" action="/main/show_order_list" method="post">
        <input type="submit" class="btn btn-default" value="Order List">
    </form>
</div>
</body>
</html>
