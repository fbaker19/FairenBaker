<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
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
            <h1>Dvd Library</h1>
            <hr/>
        </div>
        
        <div class="container">
            <h1>Edit Dvd</h1>
            <a href="displayDvdList">Dvd List</a><br />
            <hr />
            <sf:form class="form-horizontal" role="form" modelAttribute="ll" action="editDvd" method="POST">
                <div class="form-group">
                    <label for="add-title" class="col-md-4 control-label">Title:</label>
                    <div class="col-md-8">
                        <sf:input type="text" class="form-control" id="add-title" path="title" placeholder="Title" />
                        <sf:errors path="title" cssclass="error"></sf:errors>
                    </div>
                </div>
                <div class="form-group">
                    <label for="add-director" class="col-md-4 control-label">Director:</label>
                    <div class="col-md-8">
                        <sf:input type="text" class="form-control" id="add-director" path="director" placeholder="Director" />
                        <sf:errors path="director" cssclass="error"></sf:errors>
                    </div>
                </div>
                <div class="form-group">
                    <label for="add-release-date" class="col-md-4 control-label">Release Date:</label>
                    <div class="col-md-8">
                        <sf:input type="text" class="form-control" id="add-release-date" path="releaseDate" placeholder="Release Date" />
                        <sf:errors path="releaseDate" cssclass="error"></sf:errors>
                    </div>
                </div>
                <div class="form-group">
                    <label for="add-mpaa" class="col-md-4 control-label">MPAA Rating:</label>
                    <div class="col-md-8">
                        <sf:input type="text" class="form-control" id="add-mpaa" path="mpaa" placeholder="MPAA Rating" />
                        <sf:errors path="mpaa" cssclass="error"></sf:errors>
                    </div>
                </div>  
                <div class="form-group">
                    <label for="add-rating" class="col-md-4 control-label">Viewer Rating:</label>
                    <div class="col-md-8">
                        <sf:input type="text" class="form-control" id="add-rating" path="rating" placeholder="Viewer Rating" />
                        <sf:errors path="phone" cssclass="error"></sf:errors>
                        <sf:hidden path="addressId" />
                    </div>
                </div>
                     <div class="form-group">
                    <label for="add-studio" class="col-md-4 control-label">MPAA Rating:</label>
                    <div class="col-md-8">
                        <sf:input type="text" class="form-control" id="add-studio" path="studio" placeholder="Studio" />
                        <sf:errors path="studio" cssclass="error"></sf:errors>
                    </div>
                </div>  
                    <div class="form-group">
                        <div class="col-md-offset-4 col-md-8">
                            <button type="submit" id="add-button" class="btn btn-default">Edit Dvd</button>
                        </div>
                    </div>
            </sf:form>
        </div>
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

    </body>
</html>

