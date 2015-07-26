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
                     <li role="presentation"><a href="${pageContext.request.contextPath}/displayDvdList">DVD List </a></li>
                 </ul>    
            </div>
                  <div class="row">
                    <div class="col-md-6">
                        <h2>DVD Search</h2>
                        <table id="dvdTable" class="table table-hover">
                            <tr>
                                <th width="40%">DVD Title</th>
                                <th width="30%">Director</th>
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
                 <!-- MODAL = POP-UP Window -->
        <!-- Details Modal--> 
        <div class = "modal fade" id ="detailsModal" tabindex="-1" role="dialog" 
             aria-labelledby =" detailsModalLabel" aria-hidden =" true">
            <div class = "modal-dialog">
                <div class="modal-content">

                    <!-- Modal Header --> <!--X/close button -->
                    <div class = "modal-header">
                        <button type =" button" class="close" data-dismiss ="modal">
                            <span aria-hidden = "true">&times;</span>
                            <span class ="sr-only">Close</span>
                        </button>
                        <h4 class="modal-title" id="detailsModalLabel">DVD Details</h4>
                    </div>
                    <!-- Modal Header End -->

                    <!-- Modal Body -->
                    <div class="modal-body">
                        <h3 id = "dvd-id"></h3><!--.text in js/Ajax--> <!--!!!DONKEYLOBSTER!!!!-->
                        <table class="table table-bordered">
                            
                            <tr>
                                <th>Title:</th><td id ="dvd-title"></td>
                            </tr>
                            <tr>
                                <th>Director:</th><td id ="dvd-director"></td>
                            </tr>
                            <tr>
                                <th>Release Date:</th><td id ="dvd-release-date"></td>
                            </tr>
                            <tr>
                                <th>MPAA Rating:</th><td id ="dvd-mpaa"></td>
                            </tr>
                            <tr>
                                <th>Viewer Rating:</th><td id ="dvd-rating"></td>
                            </tr>
                            <tr>
                                <th>Studio:</th><td id ="dvd-studio"></td>
                            </tr>
                        </table>
                    </div>
                    <!-- Modal Body End -->

                    <!-- Modal Footer -->
                    <div class="modal-footer">
                        <button type ="button" class="btn btn-default" data-dismiss="modal">
                            Close
                        </button>
                    </div>
                    <!-- Modal Footer End -->

                </div>
            </div>
        </div>
        <!-- end Details modal -->


        <!-- Edit modal -->
        <div class = "modal fade" id ="editModal" table-index ="-1" aria-labelledby="detailsModelLabel" aria-hidden ="true">
            <div class="modal-dialog">
                <div class="modal-content">


                    <div class="modal-header">
                        <button type ="button" class="close" data-dismiss="modal">
                            <span aria-hidden="true">&times;</span>
                            <span class="sr-only">Close</span>
                        </button>
                        <h4 class="modal-title" id="detailsModalLabel">Edit DVD</h4>
                    </div>

                    <div class="modal-body">
                        <h3 id="dvd-id"></h3><!--.text in js/Ajax--><!---DVDID??? or just ID?-->
                        <form class="form-horizontal" role ="form">
                            <div class="form-group">
                                <label for ="edit-title" class="col-md-4 control-label">Title:</label>
                                <div class="col-md-8">
                                    <input type ="text" class="form-control" id="edit-title" placeholder="Title"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for ="edit-director" class="col-md-4 control-label">Director:</label>
                                <div class="col-md-8">
                                    <input type ="text" class="form-control" id="edit-director" placeholder="Director"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for ="edit-released-date" class="col-md-4 control-label">Release Date:</label>
                                <div class="col-md-8">
                                    <input type ="text" class="form-control" id="edit-release-date" placeholder="Release Date"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for ="edit-mpaa" class="col-md-4 control-label">MPAA:</label>
                                <div class="col-md-8">
                                    <input type ="text" class="form-control" id="edit-mpaa" placeholder="MPAA"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for ="edit-rating" class="col-md-4 control-label">Viewer Rating:</label>
                                <div class="col-md-8">
                                    <input type ="text" class="form-control" id="edit-rating" placeholder="Viewer Rating"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for ="edit-studio" class="col-md-4 control-label">Studio:</label>
                                <div class="col-md-8">
                                    <input type ="text" class="form-control" id="edit-studio" placeholder="Studio"/>
                                </div>
                            </div>


                            <div class="form-group">
                                <div class="col-md-4 col-md-8">
                                    <button type="submit" id="edit-button" class="btn btn-default" data-dismiss="modal">Edit DVD</button>
                                    <button type="button"class="btn btn-default" data-dismiss="modal">Cancel</button>
                                    <input type="hidden" id="edit-dvd-id"/>
                                </div>
                            </div>

                        </form>
                    </div>
                </div>
            </div>
        </div>
        <!-- end Edit modal -->

               
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
        
         <script src="${pageContext.request.contextPath}/js/dvdAjax.js"></script>

    </body>
</html>


