<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Dvd Library</title>
        <!-- Bootstrap core CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">

        <!-- SWC Icon -->
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/icon.png">

    </head>
    <body>
        <div class="container">
            <h1>Dvd Library</h1> <!--Spring MVC Application from Archetype-->
            <hr/>
            <div class="navbar">
                 <ul class="nav nav-tabs">
                     <li role="presentation"><a href="${pageContext.request.contextPath}/dvdHome">Home</a></li>
                     <li role="presentation"class="active"><a href="${pageContext.request.contextPath}/dvdSearch">Search</a></li>
                     <li role="presentation"><a href="${pageContext.request.contextPath}/dvdStats">Stats</a></li>
                     <li role="presentation"><a href="${pageContext.request.contextPath}/displayDvdList">DVD List </a></li>
                 </ul>    
            </div>
                  <div class="row">
                    <div class="col-md-6">
                        <h2>DVD Search</h2>
                        <table id="contactTable" class="table table-hover">
                            <tr>
                                <th width="40%">DVD Name</th>
                                <th width="30%">Release Date</th>
                                <th width="15%"></th>
                                <th width="15%"></th>
                            </tr>
                            <tbody id="contentRows"></tbody>
                        </table>
                    </div>
                    <div class="col-md-6">
                        <h2> Search DVD's</h2>
                        <form class="form-horizontal" role="form">
                            <div class="form-group">
                                <label for="search-title" class="col-md-4 control-label">
                                    Title:
                                </label>
                                <div class="col-md-8">
                                    <input type="text" class="form-control" id="search-title" placeholder="Title" />
                                </div>
                            </div>
                           
                            <div class="form-group">
                                <label for="search-director" class="col-md-4 control-label">
                                    Director:
                                </label>
                                <div class="col-md-8">
                                    <input type="text" class="form-control" id="search-director" placeholder="Director" />
                                </div>
                            </div>
                           
                            <div class="form-group">
                                <label for="search-realease-date" class="col-md-4 control-label">
                                    Release Date:
                                </label>
                                <div class="col-md-8">
                                    <input type="text" class="form-control" id="search-release-date" placeholder="Release Date" />
                                </div>
                            </div>
                           
                            <div class="form-group">
                                <label for="search-mpaa" class="col-md-4 control-label">
                                    MPAA Rating:
                                </label>
                                <div class="col-md-8">
                                    <input type="text" class="form-control" id="search-mpaa" placeholder="MPAA" />
                                </div>
                            </div>
                          
                            <div class="form-group">
                                <label for="search-rating" class="col-md-4 control-label">
                                    Viewer Rating:
                                </label>
                                <div class="col-md-8">
                                    <input type="text" class="form-control" id="search-rating" placeholder="Rating" />
                                </div>
                            </div>
                           <div class="form-group">
                                <label for="search-studio" class="col-md-4 control-label">
                                   Studio:
                                </label>
                                <div class="col-md-8">
                                    <input type="text" class="form-control" id="search-studio" placeholder="Studio" />
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
                <!---->
               
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

    </body>
</html>


