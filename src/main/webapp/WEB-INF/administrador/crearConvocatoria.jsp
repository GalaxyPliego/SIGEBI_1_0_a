<%--
  Created by IntelliJ IDEA.
  User: maste
  Date: 03/08/2021
  Time: 08:46 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:if test="${sessionScope.login == null}">
  <c:redirect url="/index.jsp"/>
</c:if>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  $END$
  </body>
</html>
