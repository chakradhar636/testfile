<%@page import="Dao.*" %>
<%@page import="Entities.*" %>

<html>
<head></head>
<body>                    <%
                        String u = request.getParameter("username");
                        String p = request.getParameter("password");
                        int valid = 0;
                        AdminDaoImpl admin = new AdminDaoImpl();
                        if(admin.validate(new Admin(u, p))) {
                          %>

                                    <jsp:forward page="OperatorMainPage.html" />
                        <%}

                        else {

                            out.print("Invalid username or password");
                        %>  <jsp:include page="firstpage.html" />
                           <% }

                        out.println("");

                    %>
                </center>

</body>
</html>