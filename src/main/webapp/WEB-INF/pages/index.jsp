<%--
  Created by IntelliJ IDEA.
  User: Svitlana
  Date: 28-May-15
  Time: 8:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%--<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome!</title>
    <style>
        div {
            background: #fc3; /* Цвет фона */
            border: 2px solid black; /* Параметры рамки */
            padding: 20px; /* Поля вокруг текста */
            margin-top: 20%; /* Отступ сверху */
        }
    </style>
</head>
<body>
<div class="container">
    <form class="form-inline" role="form" action="/main/Polish_cuisines" method="post">
        <center><input type="submit" class="btn btn-default" value="Polish cuisines"></center>
    </form>
    <form class="form-inline" role="form" action="/main/Italian_cuisines" method="post">
        <center><input type="submit" class="btn btn-default" value="Italian cuisines"></center>
    </form>
    <form class="form-inline" role="form" action="/main/Mexican_cuisines" method="post">
        <center><input type="submit" class="btn btn-default" value="Mexican cuisines"></center>
    </form>
    <form class="form-inline" role="form" action="/main/additional_page" method="post">
        <center><input type="submit" class="btn btn-default" value="Additional page"></center>
    </form>
</div>
</body>
</html>
