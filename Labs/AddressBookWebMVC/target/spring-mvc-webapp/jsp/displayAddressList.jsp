<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Address Book</title>
        <!-- Bootstrap core CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">

        <!-- SWC Icon -->
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/icon.png">

    </head>
    <body>
        <div class="container">
            <h1>Spring MVC Application from Archetype</h1>
            <hr/>
            <div class="navbar">
                <ul class="nav nav-tabs">
                    <li role="presentation"><a href="${pageContext.request.contextPath}/addressHome">Home</a></li>
                    <li role="presentation" ><a href="${pageContext.request.contextPath}/addressSearch">Search</a></li>
                    <li role="presentation" ><a href="${pageContext.request.contextPath}/addressStats">Stats</a></li>
                    <li role ="presentation"class="active"><a href ="${pageContext.request.contextPath}/displayAddressList">Address List</a></li>
                </ul>    
            </div>
            
        </div>
               <div class="container">
            <h1>Address Book</h1>
            <a href="displayNewAddressForm">Add a Address</a><!--linked to another JSP-->
            <hr/>
            
            <c:forEach var="addressVar" items="${addressList}"><!--import array list & sets variable ex var=addressVar-->
                <s:url value="deleteAddress" var="deleteAddress_url">
                    <s:param name="addressId" value="${addressVar.addressId}" />
                </s:url>
                <s:url value="displayEditAddressForm" var="editAddress_url">
                    <s:param name="addressId" value="${addressVar.addressId}" />
                </s:url>
                
                <c:if test="${addressVar.lastName == 'Doe'}">
                    CEO<br/>
                </c:if>
                
                Name: ${addressVar.firstName} ${addressVar.lastName} | 
                <a href="${deleteAddress_url}">Delete</a> |
                <a href="${editAddress_url}">Edit</a><br/>
                Address: ${addressVar.numberAndStreet} <br/>
                City: ${addressVar.city} <br/>
                State: ${addressVar.state} <br/>
                Zip:${addressVar.zip}<br/>
                <hr/>
                
            </c:forEach>
        </div> 
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

    </body>
</html>
