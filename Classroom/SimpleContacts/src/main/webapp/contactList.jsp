<%-- 
    Document   : contactList
    Created on : Jul 10, 2015, 9:35:17 AM
    Author     : apprentice
--%>

<!--taglib = "c"--> <!---->
<%@taglib  prefix = "c" uri="http://java.sun.com/jsp/jstl/core"%><!--ADDED IN, formats data and html-->
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!--JSP = view/ what is seen directly on the webpage-->

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Contact List</title>
    </head>
    <body>
        <h1>Contact List</h1>

        <c:forEach var = "contact" items = "${contactList}"><!--FOR LOOP-->
        <c:out value = "${contact.name}"/> <br />
        <c:out value = "${contact.phone}"/> <br />
        <c:out value = "${contact.email}"/> <br />
         <br/>
        </c:forEach>
        
    </body>
</html>
