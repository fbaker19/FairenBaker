<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
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
            <h1>Address Book</h1>
            <hr/>
        </div>
        
        <div class="container">
            <h1>Edit Address Form</h1>
            <a href="displayAddressList">Address List</a><br/>
            <hr/>
            <sf:form class="form-horizontal" role="form" modelAttribute="address" action="editAddress" method="post">
                <div class="form-group">
                    <label for="add-first-name" class="col-md-4 control-label">First Name: </label>
                    <div class="col-md-8">
                        <sf:input type="text" class="form-control" id="add-first-name" path="firstName" placeholder="First Name" />
                        <sf:errors path="firstName" cssclass="error"></sf:errors>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="add-last-name" class="col-md-4 control-label">Last Name: </label>
                        <div class="col-md-8">
                        <sf:input type="text" class="form-control" id="add-last-name" path="lastName" placeholder="Last Name" />
                        <sf:errors path="lastName" cssclass="error"></sf:errors>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="add-number-and-street"class="col-md-4 control-label">Address and Street: </label>
                        <div class="col-md-8">
                        <sf:input type="text" class="form-control" id="add-number-and-street" path="numberAndStreet" placeholder="Address and Street" />
                        <sf:errors path="numberAndStreet" cssclass="error"></sf:errors>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="add-city" class="col-md-4 control-label">City: </label>
                        <div class="col-md-8">
                        <sf:input type="text" class="form-control" id="add-city" path="city" placeholder="City" />
                        <sf:errors path="city" cssclass="error"></sf:errors>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="add-state" class="col-md-4 control-label">State: </label>
                        <div class="col-md-8">
                        <sf:input type="text" class="form-control" id="add-state" path="state" placeholder="State" />
                        <sf:errors path="state" cssclass="error"></sf:errors>
                        <sf:hidden path="addressId" /> <!-- the sf:hidden field is used to retain the contact id number for the contact when it goes back to the controller -->
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="add-zip" class="col-md-4 control-label">Zip: </label>
                        <div class="col-md-8">
                        <sf:input type="text" class="form-control" id="add-zip" path="phone" placeholder="Zip" />
                        <sf:errors path="zip" cssclass="error"></sf:errors>
                        </div>
                    </div>

                    <div class="form-group">
                        <div class="col-md-offset-4 col-md-8">
                            <button type="submit" id="add-button" class="btn btn-default">Edit Address</button>
                        </div>
                    </div>

            </sf:form>
        </div>

        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

    </body>
</html>
