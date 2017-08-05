<%@ page import="javax.persistence.criteria.CriteriaBuilder" %>
<%@ page import="Entities.HibernateClass" %>
<%@ page import="Entities.Address" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="Dao.CustomerDAOImpl" %><%--
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
    String hno = request.getParameter("f1houseno");
    String street = request.getParameter("f1streetname");
    String city = request.getParameter("f1city");
    String state = request.getParameter("f1state");
    int pin = Integer.parseInt(request.getParameter("f1pin"));
    System.out.println("HOUSE NO  :  "+hno);
    System.out.println("Street  :  "+street);
    System.out.println("City  :  "+city);
    System.out.println("State  :  "+state);
    System.out.println("PIN  :  "+pin);
    System.out.println("Before Hibernate in AddDetails");
    CustomerDAOImpl HC = new CustomerDAOImpl();
    System.out.println("After Hibernate in AddDetails");
    Address add =new Address(hno,street,city,state,pin);
HC.addAddress(add);
    //FETCH CUSTOMER DETAILS

    String vehId = request.getParameter("f1firstname");
    String name = request.getParameter("f1lastname");
    long mobile = Long.parseLong(request.getParameter("f1aboutyourself"));
    String email = request.getParameter("f1email1");
    Date date = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("f1date"));

    boolean validCustomer = HC.addCustomer(vehId,name,date,mobile,email,add);


%>
</body>
</html>
