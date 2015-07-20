<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Interest Calculator</title>
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
                        <li role="presentation" class="active"><a href="${pageContext.request.contextPath}/interest">Interest Calculator</a></li>
                        <li role="presentation"><a href="${pageContext.request.contextPath}/factor">Factorizor</a></li>
                        <li role="presentation"><a href="${pageContext.request.contextPath}/lucky">Lucky Sevens</a></li>
                        <li role="presentation"><a href="${pageContext.request.contextPath}/floor">Floor Calculator</a></li>

                    </ul>    
                </div>
             </div>
        
        <!--START HERE-->
        <div class="container">
            <div class="starter-template">

                <h1>Interest Calculator</h1>
                <hr />
                <h4>Your interest is our interest</h4> <br />
                <form action="interest" method="post">
                    <div class=form-group">What amount will you deposit in the fund?<input type="text" name="originalBalance"/></div> <!--{originalBalance}-->
                    <div class=form-group">What annual interest rate did you qualify for? <input type="text" name="intRate"/></div>
                    <div class=form-group">How many years will the principal and interest stay in the fund? <input type="text" name="numYears"/></div>
                    <div class=form-group">How many times per year will the interest be compounded?<input type="text" name=" numPeriods"/> </div>

                    <input type="submit" value ="Submit" />
                </form>

            </div>
        </div><!-- /.container -->


        <!-- Bootstrap core JavaScript
        ================================================== -->
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="js/jquery-2.1.4.min.js"></script>
        <script src="js/bootstrap.min.js"></script>


    </body></html>