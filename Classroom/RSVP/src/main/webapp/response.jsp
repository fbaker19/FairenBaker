<%-- 
    Document   : reponse
    Created on : Jul 9, 2015, 3:57:52 PM
    Author     : apprentice
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Response</h1>
        <a href ="RSVPServlet">Home</a>
        
        Your answer was ${param.myAnswer}<br /> <!--EL /JAVA IN HTML-->
        ${message}
        
        
    </body>
</html>
