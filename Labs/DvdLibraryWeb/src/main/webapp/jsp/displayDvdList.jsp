<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>DVDLibrary</title>
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet"> <!-- Bootstrap core CSS -->
        <link rel="shortcut icon" href="http://www.thesoftwareguild.com/favicons/favicon-32x32.png"> <!-- SWC Icon -->
    </head>
    <body>
        <div class="container">
            <h1>DVD Library</h1>
            <hr/>
            <div class="navbar">
                <ul class="nav nav-tabs">
                    <li role="presentation"><a href="${pageContext.request.contextPath}/dvdHome">Home</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/dvdSearch">Search</a></li>
                    <li role="presentation" class="active"><a href="${pageContext.request.contextPath}/displayDvdList">DVD List</a></li>
                </ul>    
            </div>
        </div>
        <div class="container">
            <h1>DVD Library</h1>
            <a href="displayNewDvdForm">Add a DVD</a><!--linked to another JSP-->
            <hr/>

            <c:forEach var="ll" items="${dvdList}">
                <s:url value="deleteDvd" var="deleteDvd_url">
                    <s:param name="dvdId" value="${ll.id}" />
                </s:url>
                <s:url value="displayEditDvdForm" var="editDvd_url">
                    <s:param name="dvdId" value="${ll.id}" /><!--DTO/Model-->
                </s:url>

                <c:if test="${ll.title == 'Fast&Furious'}">
                    CEO<br/>
                </c:if>

                Name: ${ll.title}|
                <a href="${deleteDvd_url}">Delete</a> |
                <a href="${editDvd_url}">Edit</a><br/>
                Director:${ll.director}  
                Release Date: ${ll.releaseDate} <br/>
                MPAA Rating: ${ll.mpaa} <br/>
                Viewer Rating: ${ll.rating} <br/>
                Studio: ${ll.studio}<br/>
                <hr/>

            </c:forEach>
        </div>
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    </body>
</html>

