

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Response</h1>
        <a href ="InterestCalcServlet">Home</a>
        
        Your interest is ${newBalance}<br /> <!--EL /JAVA IN HTML-->
        ${interest}<!--bottom of servlet in RequestAttribute-->
        
        
    </body>
</html>
