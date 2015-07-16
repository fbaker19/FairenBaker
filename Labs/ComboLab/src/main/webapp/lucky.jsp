

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
            <h1>Lucky 7 </h1>
            <form action="lucky" th:action="@{/lucky}" th:object="${lucksVariable}" method="post"><!--Variable of the controller-->
            <p>Dollars: <input type="text" name="Dollars" id="dollars" /></p>
            <p><input type="submit" value="Submit" /> <input type="reset" value="Reset" /></p>
            </form>
        </div>
               <div class="navbar">
                 <ul class="nav nav-tabs">
                     <!--active = tabs active/highlighted-->
                <li role="presentation" class="active"><a href="${pageContext.request.contextPath}/InterestCalcServlet">Interest Calculator</a></li>
                <li role="presentation"><a href="${pageContext.request.contextPath}/search">Search</a></li>
                <li role="presentation"><a href="${pageContext.request.contextPath}/stats">Stats</a></li>
                <li role="presentation"><a href="${pageContext.request.contextPath}/displayContactListNoAjax">Contact List(No Ajax)</a></li>
                 </ul>    
            </div>
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

    </body>
</html>


