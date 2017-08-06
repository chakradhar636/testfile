<%@ page import="Dao.PdfCreator" %><%--
  Created by IntelliJ IDEA.
  User: donuric
  Date: 8/5/2017
  Time: 7:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    System.out.println("entered Pdf.jsp");
    PdfCreator pdfCreator=new PdfCreator();
    pdfCreator.create(request.getParameter("rgno"));
    System.out.println("exit Pdf.jsp");
%>
</body>
</html>
