<%-- 
    Document   : displayNewContactForm
    Created on : Jul 19, 2015, 12:15:04 AM
    Author     : apprentice
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Address Book</title>
        <!-- Bootstrap core CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">

        <!-- SWC Icon -->
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/icon.png">

        <!--meta http-equiv="Content-Type" content="text/html; charset=UTF-8"-->
    </head>

    <body>
        <div class="container">
            <h1>Address Book</h1>
            <hr/>            
        </div>
        <div class="container">
            <h1>New Address Form</h1>
            <a href="displayAddressList">Address Book List</a> <br /><!--linked to another JSP-->
            <hr />

            <form class="form-horizontal"
                  role="form"
                  action="addNewAddress"
                  method="POST">

                <div class="form-group">
                    <label for="add-first-name" class="col-md-4 control-label">First Name:</label>
                    <div class="col-md-8">
                        <input type="text"
                               class="form-control"
                               id="add-first-name"
                               name="firstName"
                               placeholder="First Name" />
                    </div>
                </div>
                <div class="form-group">
                    <label for="add-last-name" class="col-md-4 control-label">Last Name:</label>
                    <div class="col-md-8">
                        <input type="text"
                               class="form-control"
                               id="add-last-name"
                               name="lastName"
                               placeholder="Last Name" />
                    </div>
                </div>
               
                <div class="form-group">
                    <label for="add-number-and-street" class="col-md-4 control-label">Address and Street Name:</label>
                    <div class="col-md-8">
                        <input type="text"
                               class="form-control"
                               id="add-number-and-street"
                               name="number-and-street"
                               placeholder="Address and Street Name" />
                    </div>
                </div>

                <div class="form-group">
                    <label for="add-city" class="col-md-4 control-label">City:</label>
                    <div class="col-md-8">
                        <input type="text"
                               class="form-control"
                               id="add-phone"
                               name="city"
                               placeholder="City" />
                    </div>
                </div>
                
                <div class="form-group">
                    <label for="add-state" class="col-md-4 control-label">State:</label>
                    <div class="col-md-8">
                        <input type="text"
                               class="form-control"
                               id="add-state"
                               name="state"
                               placeholder="State" />
                    </div>
                </div>
                
                <div class="form-group">
                    <label for="add-zip" class="col-md-4 control-label">Zip:</label>
                    <div class="col-md-8">
                        <input type="text"
                               class="form-control"
                               id="add-zip"
                               name="zip"
                               placeholder="Zip" />
                    </div>
                </div>

                <div class="form-group">
                    <div class="col-md-offset-4 col-md-8">
                        <button type="submit"
                                id="add-button"
                                class="btn btn-default">Add New Address</button>
                    </div>
                </div>
            </form>

        </div>
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    </body>
</html>
