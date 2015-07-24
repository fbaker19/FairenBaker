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
            <h1>Address Book</h1>
            <hr/>
            <div class="navbar">
                <ul class="nav nav-tabs">
                    <li role="presentation"class="active"><a href="${pageContext.request.contextPath}/addressHome">Home</a></li>
                    <li role="presentation" ><a href="${pageContext.request.contextPath}/addressSearch">Search</a></li>
                    <li role ="presentation"><a href ="${pageContext.request.contextPath}/displayAddressList">Address List</a></li>
            </div>


            <div class="row">
                <div class="col-md-6">
                    <h2>Address Book</h2>
                    <table id="addressTable" class="table table-hover">
                        <tr>
                            <th width="40%">Name</th>
                            <th width="30%">Street</th>
                            <th width="30%">State</th>
                            <th width="15%"></th>
                            <th width="15%"></th>
                        </tr>
                        <tbody id="contentRows"></tbody>
                    </table>
                </div>
                <div class="col-md-6">
                    <h2> Add New Address</h2>
                    <form class="form-horizontal" role="form">
                        <div class="form-group">
                            <label for="add-first-name" class="col-md-4 control-label">
                                First Name:
                            </label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" id="add-first-name" placeholder="First Name" />
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="add-last-name" class="col-md-4 control-label">
                                Last Name:
                            </label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" id="add-last-name" placeholder="Last Name" />
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="add-number-and-street" class="col-md-4 control-label">
                                Street:
                            </label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" id="add-number-and-street" placeholder="Street" />
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="add-city" class="col-md-4 control-label">
                                City:
                            </label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" id="add-city" placeholder="City" />
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="add-state" class="col-md-4 control-label">
                                State:
                            </label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" id="add-state" placeholder="State" />
                            </div>
                        </div>

                        <div class="form-group">
                            <label for ="add-zip" class="col-md-4 control-label">
                                Zip:
                            </label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" id="add-zip" placeholder="Zip"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="col-md-offset-4 col-md-8">
                                <button type="submit" id="add-button" class="btn btn-default">Create Address</button>
                            </div> 
                        </div>

                    </form>
                    <div id="validationErrors" style="color: red" ></div>
                </div> <!-- end of add form div -->
            </div>
        </div>

<!--  -->
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
                             <h4 class="modal-title" id="detailsModalLabel">Address Details</h4>
                         </div>
                         <!-- Modal Header End -->
                        
                         <!-- Modal Body -->
                            <div class="modal-body">
                                <h3 id = "address-id"></h3>
                                <table class="table table-bordered">
                                    <tr>
                                        <th>First name:</th><td id ="address-first-name"></td>
                                    </tr>
                                    <tr>
                                        <th>Last name:</th><td id ="address-last-name"></td>
                                    </tr>
                                    <tr>
                                        <th>Street:</th><td id ="address-number-and-street"></td>
                                    </tr>
                                    <tr>
                                        <th>City:</th><td id ="address-city"></td>
                                    </tr>
                                    <tr>
                                        <th>State:</th><td id ="address-state"></td>
                                    </tr>
                                    <tr>
                                        <th>Zip:</th><td id="address-zip"></td>
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
                              <h4 class="modal-title" id="detailsModalLabel">Edit Address</h4>
                          </div>
                          
                          <div class="modal-body">
                              <h3 id="address-id"></h3><!--.text in js/Ajax-->
                              <form class="form-horizontal" role ="form">
                                  <div class="form-group">
                                      <label for ="edit-first-name" class="col-md-4 control-label">First Name:</label>
                                      <div class="col-md-8">
                                          <input type ="text" class="form-control" id="edit-first-name" placeholder="First Name"/>
                                      </div>
                                  </div>
                                  <div class="form-group">
                                      <label for ="edit-last-name" class="col-md-4 control-label">Last Name:</label>
                                      <div class="col-md-8">
                                          <input type ="text" class="form-control" id="edit-last-name" placeholder="Last Name"/>
                                      </div>
                                  </div>
                                  <div class="form-group">
                                      <label for ="edit-number-and-street" class="col-md-4 control-label">Street:</label>
                                      <div class="col-md-8">
                                          <input type ="text" class="form-control" id="edit-number-and-street" placeholder="Street"/>
                                      </div>
                                  </div>
                                  <div class="form-group">
                                      <label for ="edit-city" class="col-md-4 control-label">City:</label>
                                      <div class="col-md-8">
                                          <input type ="text" class="form-control" id="edit-city" placeholder="City"/>
                                      </div>
                                  </div>
                                  <div class="form-group">
                                      <label for ="edit-state" class="col-md-4 control-label">State:</label>
                                      <div class="col-md-8">
                                          <input type ="text" class="form-control" id="edit-state" placeholder="State"/>
                                      </div>
                                  </div>
                                  <div class="form-group">
                                      <label for ="edit-zip" class="col-md-4 control-label">Zip:</label>
                                      <div class="col-md-8">
                                          <input type ="text" class="form-control" id="edit-zip" placeholder="Zip"/>
                                      </div>
                                  </div>
                                  
                                  
                                  <div class="form-group">
                                      <div class="col-md-4 col-md-8">
                                          <button type="submit" id="edit-button" class="btn btn-default" data-dismiss="modal">Edit Address</button>
                                          <button type="button"class="btn btn-default" data-dismiss="modal">Cancel</button>
                                          <input type="hidden" id="edit-address-id"/>
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
        <script src="${pageContext.request.contextPath}/js/addressAjax.js"></script>
    </body>
</html>


