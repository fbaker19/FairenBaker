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
            <h1>Address Book</h1> <!--Spring MVC Application from Archetype-->
            <hr/>
            <div class="navbar">
                 <ul class="nav nav-tabs">
                <li role="presentation" ><a href="${pageContext.request.contextPath}/addressHome">Home</a></li>
                <li role="presentation" class="active"><a href="${pageContext.request.contextPath}/addressSearch">Search</a></li>
                <!--active = tabs active/highlighted-->
                <li role="presentation" ><a href="${pageContext.request.contextPath}/addressStats">Stats</a></li>
                <li role="presentation"><a href="${pageContext.request.contextPath}/displayAddressList">Address List</a></li>
                 </ul>    
            </div>
                  <div class="row">
                    <div class="col-md-6">
                        <h2>My Contacts</h2>
                        <table id="contactTable" class="table table-hover">
                            <tr>
                                <th width="40%">Contact Name</th>
                                <th width="30%">Address</th>
                                <th width="15%"></th>
                                <th width="15%"></th>
                            </tr>
                            <tbody id="contentRows"></tbody>
                        </table>
                    </div>
                    <div class="col-md-6">
                        <h2> Search Address</h2>
                        <form class="form-horizontal" role="form">
                            <div class="form-group">
                                <label for="search-first-name" class="col-md-4 control-label">
                                    First Name:
                                </label>
                                <div class="col-md-8">
                                    <input type="text" class="form-control" id="search-first-name" placeholder="First Name" />
                                </div>
                            </div>
                           
                            <div class="form-group">
                                <label for="search-last-name" class="col-md-4 control-label">
                                    Last Name:
                                </label>
                                <div class="col-md-8">
                                    <input type="text" class="form-control" id="search-last-name" placeholder="Last Name" />
                                </div>
                            </div>
                           
                            <div class="form-group">
                                <label for="search-number-and-street" class="col-md-4 control-label">
                                    Address:
                                </label>
                                <div class="col-md-8">
                                    <input type="text" class="form-control" id="search-number-and-street" placeholder="Address" />
                                </div>
                            </div>
                           
                            <div class="form-group">
                                <label for="search-city" class="col-md-4 control-label">
                                    City:
                                </label>
                                <div class="col-md-8">
                                    <input type="text" class="form-control" id="search-city" placeholder="City" />
                                </div>
                            </div>
                          
                            <div class="form-group">
                                <label for="search-state" class="col-md-4 control-label">
                                    State:
                                </label>
                                <div class="col-md-8">
                                    <input type="text" class="form-control" id="search-state" placeholder="State" />
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="search-zip" class="col-md-4 control-label">
                                    Zip:
                                </label>
                                <div class="col-md-8">
                                    <input type="text" class="form-control" id="search-zip" placeholder="Zip" />
                                </div>
                            </div>
                           
                            <div class="form-group">
                                <div class="col-md-offset-4 col-md-8">
                                    <button type="submit" id="search-button" class="btn btn-default">Search</button>
                                </div> 
                            </div>
                       
                        </form>
                        
                    </div> <!-- end of add form div -->
                </div>
        </div>
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

    </body>
</html>