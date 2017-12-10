<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>

<!DOCTYPE html>
<html lang="en">

	<head>
	
	    <meta charset="utf-8">
	    <meta http-equiv="X-UA-Compatible" content="IE=edge">
	    <meta name="viewport" content="width=device-width, initial-scale=1">
	    <meta name="description" content="">
	    <meta name="author" content="">
	
	    <title>Eshop - Admin Login Page</title>
	
	    <!-- Bootstrap Core CSS -->
	    <link rel="stylesheet" type="text/css" href="<c:url value="/css/admin/bootstrap/bootstrap.css"/>">
	
	    <!-- MetisMenu CSS -->
	    <link rel="stylesheet" type="text/css" href="<c:url value="/css/admin/metisMenu/metisMenu.css"/>">
	
	    <!-- Custom CSS -->
	    <link rel="stylesheet" type="text/css" href="<c:url value="/css/admin/sb-admin-2.css"/>">
	
	    <!-- Custom Fonts -->
	    <link rel="stylesheet" type="text/css" href="<c:url value="/css/admin/font-awesome/font-awesome.css"/>">
		
	</head>

	<body>
	
	    <div class="container">
	        <div class="row">
	            <div class="col-md-4 col-md-offset-4">
	                <div class="login-panel panel panel-default">
	                    <div class="panel-heading">
	                        <h3 class="panel-title">Please Sign In</h3>
	                    </div>
	                    <c:if test="${not empty error}">
							<div class="error">${error}</div>
						</c:if>
						<c:if test="${not empty msg}">
							<div class="msg">${msg}</div>
						</c:if>
	                    <div class="panel-body">
	                        <sf:form name="f" role="form" method="POST">
	                            <fieldset>
	                                <div class="form-group">
	                                    <input class="form-control" placeholder="Username" name="username" type="text" autofocus>
	                                </div>
	                                <div class="form-group">
	                                    <input class="form-control" placeholder="Password" name="password" type="password" value="">
	                                </div>
	                                <!-- 
	                                <div class="checkbox">
	                                    <label>
	                                        <input name="remember" type="checkbox" value="Remember Me">Remember Me
	                                    </label>
	                                </div>
	                                -->
	                                <!-- Change this to a button or input when using this as a form 
	                                <a href="index.html" class="btn btn-lg btn-success btn-block">Login</a>
	                                -->
	                                <input class="btn btn-lg btn-success btn-block" name="submit" type="submit" value="Login"/>
	                            </fieldset>
	                        </sf:form>
	                    </div>
	                </div>
	            </div>
	        </div>
	    </div>
	
	    <!-- jQuery -->
	    <script src="<c:url value="/js/admin/jquery/jquery.js"/>" type="text/javascript"></script>
	
	    <!-- Bootstrap Core JavaScript -->
	    <script src="<c:url value="/js/admin/bootstrap/bootstrap.js"/>" type="text/javascript"></script>
	
	    <!-- Metis Menu Plugin JavaScript -->
	    <script src="<c:url value="/js/admin/metisMenu/metisMenu.js"/>" type="text/javascript"></script>
	
	    <!-- Custom Theme JavaScript -->
	    <script src="<c:url value="/js/admin/sb-admin-2.js"/>" type="text/javascript"></script>
	
	</body>

</html>
