<%@ page import="Entities.ServiceOrder" %>
<%@ page import="Dao.ServiceOrderDAO" %>
<%@ page import="Dao.ServiceOrderDAOImpl" %><%--
  Created by IntelliJ IDEA.
  User: gundojim
  Date: 8/5/2017
  Time: 11:01 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    System.out.println(request.getParameter("id"));
    ServiceOrderDAOImpl s=new ServiceOrderDAOImpl();
    s.addServiceOrder(request.getParameter("regno"),request.getParameter("id"));
%>
</body>
</html>
