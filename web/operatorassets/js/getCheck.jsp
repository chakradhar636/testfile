<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="Dao.A" %><%--
  Created by IntelliJ IDEA.
  User: gundojim
  Date: 8/5/2017
  Time: 6:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%  Date date=null;
    try {
        date = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("date"));
    }catch (Exception c){
        System.out.print("get.jsp exception");
    }
    A a=new A();
    System.out.print("in jsp");
    boolean slot_available = a.checkDate(date);
    System.out.print("slot Result:"+slot_available);
    out.print(""+slot_available);
%>

</body>
</html>
