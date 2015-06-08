<%--
  Created by IntelliJ IDEA.
  User: Svitlana
  Date: 28-May-15
  Time: 8:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Welcome!</title>
      <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
      <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
  </head>
  <body>
  <div class="container">
          <form>
          <tr><td><b><p>-----------------------------------Polish-------------------------------------------</p></b></td></tr>
          <tr><td><b><p>Main</p></b></td></tr>
      <table class="table table-striped">
          <thead>
          <tr>
              <td><b>Name</b></td>
              <td><b>Price</b></td>
          </tr>
          </thead>
          <%--display the result, which divide menu on cuisines and type of meal--%>
          <c:forEach items="${order11}" var="ordr">
              <tr><%--@param name - my attempt to save result in list or array or some other--%>
                  <td><form:checkbox path="order11"  value="${ordr}" label="${ordr.name}"  name = "select"/></td>
                  <td><c:out value="${ordr.price}" /></td>
              </tr>
          </c:forEach>

          <td>Dessert </td>
          <thead>
          <tr>
              <td><b>Name</b></td>
              <td><b>Price</b></td>
          </tr>
          </thead>
      <c:forEach items="${order12}" var="ordr">
          <tr>
              <td><form:checkbox path="order12" value="${ordr}" label="${ordr.name}"/></td>
              <td><c:out value="${ordr.price}" /></td>

          </tr>
      </c:forEach>

      <td>Drink</td>

          <thead>
          <tr>
              <td><b>Name</b></td>
              <td><b>Price</b></td>
          </tr>
          </thead>
          <c:forEach items="${order13}" var="ordr">
              <tr>
                  <td><form:checkbox path="order13" value="${ordr}" label="${ordr.name}" /></td>
                  <td><c:out value="${ordr.price}" /></td>
              </tr>
          </c:forEach>

          <tr><td>----------------------------------------------Mexican---------------------------------</td></tr>
          <tr><td>Main</td></tr>

          <thead>
          <tr>
              <td><b>Name</b></td>
              <td><b>Price</b></td>
          </tr>
          </thead>
          <c:forEach items="${order21}" var="ordr">
              <tr>
                  <td><form:checkbox path="order21" value="${ordr}" label="${ordr.name}" /></td>
                  <td><c:out value="${ordr.price}" /></td>
              </tr>
          </c:forEach>

      <td>Dessert</td>

          <thead>
          <tr>
              <td><b>Name</b></td>
              <td><b>Price</b></td>
          </tr>
          </thead>
          <c:forEach items="${order22}" var="ordr">
              <tr>
                  <td><form:checkbox path="order22" value="${ordr}" label="${ordr.name}" /></td>
                  <td><c:out value="${ordr.price}" /></td>
              </tr>
          </c:forEach>

      <td>Drink</td>

          <thead>
          <tr>
              <td><b>Name</b></td>
              <td><b>Price</b></td>
          </tr>
          </thead>
          <c:forEach items="${order23}" var="ordr">
              <tr>
                  <td><form:checkbox path="order23" value="${ordr}" label="${ordr.name}" /></td>
                  <td><c:out value="${ordr.price}" /></td>
              </tr>
          </c:forEach>

          <tr><td>-------------------------------------------Italian-------------------------------------</td></tr>
          <tr><td>Main</td></tr>

          <thead>
          <tr>
              <td><b>Name</b></td>
              <td><b>Price</b></td>
          </tr>
          </thead>
          <c:forEach items="${order31}" var="ordr">
              <tr>
                  <td><form:checkbox path="order31" value="${ordr}" label="${ordr.name}" /></td>
                  <td><c:out value="${ordr.price}" /></td>
              </tr>
          </c:forEach>

      <td>Dessert</td>

          <thead>
          <tr>
              <td><b>Name</b></td>
              <td><b>Price</b></td>
          </tr>
          </thead>
          <c:forEach items="${order32}" var="ordr">
              <tr>
                  <td><form:checkbox path="order32" value="${ordr}" label="${ordr.name}" /></td>
                  <td><c:out value="${ordr.price}" /></td>
              </tr>
          </c:forEach>

      <td>Drink</td>

          <thead>
          <tr>
              <td><b>Name</b></td>
              <td><b>Price</b></td>
          </tr>
          </thead>
          <c:forEach items="${order33}" var="ordr">
              <tr>
                  <td><form:checkbox path="order33" value="${ordr}" label="${ordr.name}" /></td>
                  <td><c:out value="${ordr.price}" /></td>
              </tr>
          </c:forEach>

          <tr><td>-------------------------------------Additional---------------------------------------------</td></tr>

          <thead>
          <tr>
              <td><b>Name</b></td>
              <td><b>Price</b></td>
          </tr>
          </thead>
          <c:forEach items="${order44}" var="ordr">
              <tr>
                  <td><form:checkbox path="order44" value="${ordr}" label="${ordr.name}" /></td>
                  <td><c:out value="${ordr.price}" /></td>
              </tr>
          </c:forEach>
      </table>
      </form>
          <form method="post" action="/main/result/">
              <td><input type="submit" name="submit" value="Submit"></td>
          </form>
  </div>
  </body>
</html>
