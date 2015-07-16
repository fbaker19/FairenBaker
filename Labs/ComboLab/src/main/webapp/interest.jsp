<!DOCTYPE html>
<!-- saved from url=(0050)http://getbootstrap.com/examples/starter-template/ -->
<html lang="en"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">
        <link rel="shortcut icon" href="http://getbootstrap.com/assets/ico/favicon.ico">

        <title>Starter Template for Bootstrap</title>

        <!-- Bootstrap core CSS -->
        <link href="css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom styles for this template -->
        <link href="css/starter-template.css" rel="stylesheet">

        <!-- Just for debugging purposes. Don't actually copy this line! -->
        <!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->

        <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
          <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->
    </head>

    <body style="">

        <div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
             <div class="container">
            <h1>Company Contacts</h1> <!--Spring MVC Application from Archetype-->
            <hr/>
            <div class="navbar">
                 <ul class="nav nav-tabs">
                     <!--active = tabs active/highlighted-->
                <li role="presentation" class="active"><a href="${pageContext.request.contextPath}/InterestCalcServlet">Interest Calculator</a></li>
                <li role="presentation"><a href="${pageContext.request.contextPath}/search">Search</a></li>
                <li role="presentation"><a href="${pageContext.request.contextPath}/stats">Stats</a></li>
                <li role="presentation"><a href="${pageContext.request.contextPath}/displayContactListNoAjax">Contact List(No Ajax)</a></li>
                 </ul>    
            </div>
            <h2>Company Contacts</h2><!--HOME DISPLAY -->
            <h3>${message}</h3><!--Reference to java-->
        </div>
        </div>

        <!--START HERE-->
        <div class="container">
            <div class="starter-template">

                <h1>Interest Calculator</h1>
                <hr />
                <h4>Your interest is our interest</h4> <br />
                <form action="InterestCalcServlet" method="post">
                    <div class=form-group">What amount will you deposit in the fund?<input type="text" name="originalBalance"/></div> 
                    <div class=form-group">What annual interest rate did you qualify for? <input type="text" name="intRate"/></div>
                    <div class=form-group">How many years will the principal and interest stay in the fund? <input type="text" name="numYears"/></div>
                    <div class=form-group">How many times per year will the interest be compounded?<input type="text" name=" numPeriods"/> </div>

                    <input type="submit" value ="Submit" />
                </form>

            </div>
        </div><!-- /.container -->


        <!-- Bootstrap core JavaScript
        ================================================== -->
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="js/jquery-2.1.4.min.js"></script>
        <script src="js/bootstrap.min.js"></script>


    </body></html>