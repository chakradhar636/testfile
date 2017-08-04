<%@ page import="javax.persistence.criteria.CriteriaBuilder" %>
<%@ page import="Entities.HibernateClass" %>
<%@ page import="Entities.Address" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %><%--
  Created by IntelliJ IDEA.
  User: bholar
  Date: 8/4/2017
  Time: 5:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%System.out.println("Hello in adddetails");%>
<%
    String hno = request.getParameter("f1-house-no");
    String street = request.getParameter("f1-street-name");
    String city = request.getParameter("f1-city");
    String state = request.getParameter("f1-state");
    int pin = Integer.parseInt(request.getParameter("f1-pin"));
    System.out.println("HOUSE NO  :  "+hno);
    System.out.println("Street  :  "+street);
    System.out.println("City  :  "+city);
    System.out.println("State  :  "+state);
    System.out.println("PIN  :  "+pin);
    System.out.println("Before Hibernate in AddDetails");
    HibernateClass HC = new HibernateClass();
    System.out.println("After Hibernate in AddDetails");
    Address add = HC.addAddress(hno,street,city,state,pin);

    //FETCH CUSTOMER DETAILS

    String vehId = request.getParameter("f1-first-name");
    String name = request.getParameter("f1-last-name");
    long mobile = Integer.parseInt(request.getParameter("f1-about-yourself"));
    String email = request.getParameter("f1-email1");
    Date date = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("f1-date"));

    boolean validCustomer = HC.addCustomer(vehId,name,date,mobile,email,add);


%>
</body>
</html>
