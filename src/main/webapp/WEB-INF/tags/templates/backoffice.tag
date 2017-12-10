<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">

	<head>
	
	    <meta charset="utf-8">
	    <meta http-equiv="X-UA-Compatible" content="IE=edge">
	    <meta name="viewport" content="width=device-width, initial-scale=1">
	    <meta name="description" content="">
	    <meta name="author" content="">
	
	    <title>Eshop - Back office</title>
	    
        <!-- Bootstrap Core CSS -->
	    <link rel="stylesheet" type="text/css" href="<c:url value="/css/admin/bootstrap/bootstrap.css"/>">
	
	    <!-- MetisMenu CSS -->
	    <link rel="stylesheet" type="text/css" href="<c:url value="/css/admin/metisMenu/metisMenu.css"/>">
	
	    <!-- Custom CSS -->
	    <link rel="stylesheet" type="text/css" href="<c:url value="/css/admin/sb-admin-2.css"/>">
	
	    <!-- Morris Charts CSS -->
	    <link rel="stylesheet" type="text/css" href="<c:url value="/css/admin/morris/morris.css"/>">
	
	    <!-- Custom Fonts -->
	    <link rel="stylesheet" type="text/css" href="<c:url value="/css/admin/font-awesome/font-awesome.css"/>">		
	</head>
	
	<body>
		<div id="wrapper">
			<jsp:include page="/WEB-INF/fragments/admin/navigation.jsp"></jsp:include>
			<jsp:doBody />
		</div>
	
	    <!-- jQuery -->
	    <script src="<c:url value="/js/admin/jquery/jquery.js"/>" type="text/javascript"></script>
	
	    <!-- Bootstrap Core JavaScript -->
	    <script src="<c:url value="/js/admin/bootstrap/bootstrap.js"/>" type="text/javascript"></script>
	
	    <!-- Metis Menu Plugin JavaScript -->
	    <script src="<c:url value="/js/admin/metisMenu/metisMenu.js"/>" type="text/javascript"></script>
	
	    <!-- Morris Charts JavaScript -->
	    <script src="<c:url value="/js/admin/charts/raphael.min.js"/>" type="text/javascript"></script>
	    <script src="<c:url value="/js/admin/charts/morris.min.js"/>" type="text/javascript"></script>
	    <script src="<c:url value="/js/admin/charts/morris-data.js"/>" type="text/javascript"></script>
	
	    <!-- Custom Theme JavaScript -->
	    <script src="<c:url value="/js/admin/sb-admin-2.js"/>" type="text/javascript"></script>
	</body>
</html>