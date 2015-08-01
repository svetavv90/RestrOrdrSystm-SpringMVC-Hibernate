<%--
  Created by IntelliJ IDEA.
  User: Svetlana
  Date: 04-Jun-15
  Time: 12:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Selected menu:</title>
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
    <td><span style=";font-family:Monotype Corsiva;font-size:22px;color:blue;">All of that you have selected:</span></td>
    <form class="form-inline" role="form" action="/main/deleted" method="post">
        <table class="table table-striped">
            <thead>
            <tr>
                <td><b>Del</b></td>
                <td><b>Name</b></td>
                <td><b>Price</b></td>
            </tr>
            </thead>
            <c:forEach items="${res}" var="r">
                <tr>
                    <td><input type="checkbox" name="deleteRecords" value="${r.id}"></td>
                    <td>${r.name}</td>
                    <td>${r.price}</td>
                    <c:set var="pr" scope="session" value="${r.price + pr}"/>
                </tr>
            </c:forEach>
            <p align="right">In generally:<input type="text" class="btn btn-default" value= "${pr}"></p>
            <c:set var="pr" scope="session" value="${0}"/>
        </table>
        <table><tr>

        </table>
        <table><tr>
            <td> <input type="submit" class="btn btn-default" value="Delete"></td>
        </tr>
        </table>
    </form>
    <form class="form-inline" role="form" action="/main/" method="post">
        <input type="submit" class="btn btn-default" value="Add new Meal">
    </form>
    <form class="form-inline" role="form" action="/main/commit" method="post">
        <input type="submit" class="btn btn-default" value="Commit">
    </form>
</div>
</body>
</html>
