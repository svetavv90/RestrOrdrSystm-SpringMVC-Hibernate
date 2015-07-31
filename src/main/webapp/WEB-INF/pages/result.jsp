<%@ page import="test.sprng.OrderDaoImpl" %>
<%@ page import="test.sprng.MainController" %>
<%@ page import="org.springframework.web.servlet.ModelAndView" %>
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
</head>
<body>
<div class="container">
    <h3>All of that you have selected:</h3>
    <form class="form-inline" role="form" action="/main/commit" method="post">
        <table class="table table-striped">
            <thead>
            <tr>
                <td><b>Name</b></td>
                <td><b>Price</b></td>
            </tr>
            </thead>
            <c:forEach items="${res}" var="r">
                <tr>
                    <td>${r.name}</td>
                    <td>${r.price}</td>
                    <c:set var="pr" scope="session" value="${r.price + pr}"/>
                </tr>
            </c:forEach>
        </table>
        <table><tr>
            <td> <input type="text" class="btn btn-default" value= "${pr}">
                <c:set var="pr" scope="session" value="${0}"/>
        </table>
        <table><tr>
            <td> <input type="submit" class="btn btn-default" value="Commit">
        </table>
    </form>
    <form class="form-inline" role="form" action="/main/" method="post">
        <input type="submit" class="btn btn-default" value="Add new Meal">
    </form>
</div>
</body>
</html>
