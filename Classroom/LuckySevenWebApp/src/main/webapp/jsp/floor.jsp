<%-- 
    Document   : floorCalculator
    Created on : Jul 15, 2015, 11:32:58 PM
    Author     : apprentice
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Hello Controller Page</title>
        <!-- Bootstrap core CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">

        <!-- SWC Icon -->
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/icon.png">

    </head>
    <body>

        <div class="container">
            <div class="navbar">
                <ul class="nav nav-tabs">
                    <!--active = tabs active/highlighted-->
                    <li role="presentation"><a href="${pageContext.request.contextPath}/interest">Interest Calculator</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/factor">Factorizor</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/lucky">Lucky Sevens</a></li>
                    <li role="presentation"class="active"><a href="${pageContext.request.contextPath}/floor">Floor Calculator</a></li>

                </ul>    
            </div>
         </div>

    <!--START HERE-->
    <div class="container">
        <div class="starter-template">
            <h1>Flooring Calculator</h1> <!--Spring MVC Application from Archetype-->
            <hr />
            <h4>You will be <strong>Floored</strong> This Really Works! (Really!)</h4> <br />
            <form action="floor" method="post">
                <div class=form-group">Enter the length of room: <input type="text" name="length"/></div> <!--{originalBalance}-->
                <div class=form-group">Enter the width of room:  <input type="text" name="width"/></div>
                <input type="submit" value ="Submit" />
            </form>

        </div>
    </div><!-- /.container -->
</body>
</html>
