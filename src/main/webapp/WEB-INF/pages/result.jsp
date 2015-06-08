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
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Selected menu:</title>
</head>
<body>
<table>
    <tread>
        <tr>
            <td>Name</td>
            <td>Price</td>
        </tr>
    </tread>
    <c:forEach var="eat" items="${select.order11}">
        <tr>
        <td>${eat}</td>
        <%--<td>${eat.price}</td>--%>
        </tr>
    </c:forEach>

</table>
</body>
</html>
