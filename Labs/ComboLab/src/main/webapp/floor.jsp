<%-- 
    Document   : floorCalculator
    Created on : Jul 15, 2015, 11:32:58 PM
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
        <div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
             <div class="container">
            <h1>Company Contacts</h1> <!--Spring MVC Application from Archetype-->
            <hr/>
            <div class="navbar">
                 <ul class="nav nav-tabs">
                     <!--active = tabs active/highlighted-->
                <li role="presentation" class="active"><a href="${pageContext.request.contextPath}/InterestCalcServlet">Interest Calculator</a></li>
                <li role="presentation"><a href="${pageContext.request.contextPath}/search">Search</a></li>
                <li role="presentation"><a href="${pageContext.request.contextPath}/stats">Stats</a></li>
                <li role="presentation"><a href="${pageContext.request.contextPath}/displayContactListNoAjax">Contact List(No Ajax)</a></li>
                 </ul>    
            </div>
            <h2>Company Contacts</h2><!--HOME DISPLAY -->
            <h3>${message}</h3><!--Reference to java-->
        </div>
        </div>
    </body>
</html>
