<%@ page import="Entities.HibernateClass" %>
<%@ page import="Entities.SparePartsClass" %>
<%@ page import="Entities.ServiceOrder" %>
<%@ page import="java.util.*" %>
<%@ page import="Dao.ServiceOrderDAOImpl" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Insert title here</title>
</head>
<body>
~
<%
    response.setContentType("text/html");
    int flag=0;
    String sd = request.getParameter("num");
    System.out.println("received num issss  :  "+sd);

    System.out.println("THE SENT PARAMETER FROM AJAX  :  "+sd);
    System.out.print("Before Hibernate");
    HibernateClass HC = new HibernateClass();
    System.out.print("After Hibernate");

    ServiceOrderDAOImpl soder = new ServiceOrderDAOImpl();

    Map<String, Integer>  mp = soder.getServiceOrder(sd);
    Set set=mp.keySet();
    Iterator lt=set.iterator();

    while(lt.hasNext())
    {
        String key=(String)lt.next();
        out.println(key);
//        out.print();
//        out.println(mp.get(key));
        out.println();
    }

%>
~



</body>
</html>