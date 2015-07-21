<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>DVD  Library</title>
        <!-- Bootstrap core CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">

        <!-- SWC Icon -->
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/icon.png">

    </head>
    <body>
        <div class="container">
            <h1>DVD Library</h1>
            <hr/>
            <div class="navbar">
                <ul class="nav nav-tabs">
                    <li role="presentation"class="active"><a href="${pageContext.request.contextPath}/dvdHome">Home</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/dvdSearch">Search</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/dvdStats">Stats</a></li>
                    <li role="presentation" ><a href="${pageContext.request.contextPath}/displayDvdList">DVD List </a></li>
                </ul>    
            </div>


            <div class="row">
                <div class="col-md-6">
                    <h2>DVD's</h2>
                    <table id="contactTable" class="table table-hover">
                        <tr>
                            <th width="40%">DVD Title</th>
                            <th width="30%">Release Date</th>
                            <th width="15%"></th>
                            <th width="15%"></th>
                        </tr>
                        <tbody id="contentRows"></tbody>
                    </table>
                </div>
                <div class="col-md-6">
                    <h2> Add New DVD</h2>
                    <form class="form-horizontal" role="form">
                        <div class="form-group">
                            <label for="add-title" class="col-md-4 control-label">
                                Title:
                            </label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" id="add-title" placeholder="Title" />
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="add-director" class="col-md-4 control-label">
                                Director:
                            </label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" id="add-director" placeholder="Director" />
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="add-release-date" class="col-md-4 control-label">
                                Release Date:
                            </label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" id="add-release-date" placeholder="Release Date" />
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="add-mpaa" class="col-md-4 control-label">
                               MPAA Rating:
                            </label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" id="add-mpaa" placeholder="MPAA Rating" />
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="add-rating" class="col-md-4 control-label">
                                Viewer Rating:
                            </label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" id="add-rating" placeholder="Viewer Rating" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="studio" class="col-md-4 control-label">
                                Studio:
                            </label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" id="add-studio" placeholder="Studio" />
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="col-md-offset-4 col-md-8">
                                <button type="submit" id="add-button" class="btn btn-default">Create Dvd</button>
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
