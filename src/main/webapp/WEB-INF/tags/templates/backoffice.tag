<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html lang="en">

	<head>
	
	    <meta charset="utf-8">
	    <meta http-equiv="X-UA-Compatible" content="IE=edge">
	    <meta name="viewport" content="width=device-width, initial-scale=1">
	    <meta name="description" content="">
	    <meta name="author" content="">
	
	    <title>Eshop - BackOffice</title>
	    
        <!-- Bootstrap Core CSS -->
	    <link rel="stylesheet" type="text/css" href="<c:url value="/css/admin/bootstrap/bootstrap.css"/>">
	
	    <!-- MetisMenu CSS -->
	    <link rel="stylesheet" type="text/css" href="<c:url value="/css/admin/metisMenu/metisMenu.css"/>">
    <c:if test="${fn:contains(pageContext.request.servletPath,'/pendingOrders.jsp')}">
        <!-- DataTables CSS -->
    	<link rel="stylesheet" type="text/css" href="<c:url value="/css/admin/datatables-plugins/dataTables.bootstrap.css"/>">

    	<!-- DataTables Responsive CSS -->
    	<link rel="stylesheet" type="text/css" href="<c:url value="/css/admin/datatables-responsive/dataTables.responsive.css"/>"> 
	</c:if>	
	    <!-- Custom CSS -->
	    <link rel="stylesheet" type="text/css" href="<c:url value="/css/admin/sb-admin-2.css"/>">
	<c:if test="${fn:contains(pageContext.request.servletPath,'/dashboard.jsp')}">	
	    <!-- Morris Charts CSS -->
	    <link rel="stylesheet" type="text/css" href="<c:url value="/css/admin/morris/morris.css"/>">
	</c:if>
	    <!-- Custom Fonts -->
	    <link rel="stylesheet" type="text/css" href="<c:url value="/css/admin/font-awesome/font-awesome.css"/>">		
	</head>
	
	<body>
		<div id="wrapper">
			<jsp:include page="/WEB-INF/fragments/admin/navigation.jsp"></jsp:include>
			<jsp:doBody />
		</div>
		<!-- /#wrapper -->
	
	    <!-- jQuery -->
	    <script src="<c:url value="/js/admin/jquery/jquery.js"/>" type="text/javascript"></script>
	
	    <!-- Bootstrap Core JavaScript -->
	    <script src="<c:url value="/js/admin/bootstrap/bootstrap.js"/>" type="text/javascript"></script>
	
	    <!-- Metis Menu Plugin JavaScript -->
	    <script src="<c:url value="/js/admin/metisMenu/metisMenu.js"/>" type="text/javascript"></script>	    
    <c:if test="${fn:contains(pageContext.request.servletPath,'/pendingOrders.jsp')}">
    	<!-- DataTables JavaScript -->
	    <script src="<c:url value="/js/admin/datatables/jquery.dataTables.min.js"/>" type="text/javascript"></script>
	    <script src="<c:url value="/js/admin/datatables-plugins/dataTables.bootstrap.min.js"/>" type="text/javascript"></script>
	    <script src="<c:url value="/js/admin/datatables-responsive/dataTables.responsive.js"/>" type="text/javascript"></script>
        <!-- Page-Level Demo Scripts - Tables - Use for reference -->
	    <script>
	    $(document).ready(function() {
	        $('#dataTables-example').DataTable({
	            responsive: true
	        });
	    });
	    </script>
	</c:if>
	<c:if test="${fn:contains(pageContext.request.servletPath,'/dashboard.jsp')}">	
	    <!-- Morris Charts JavaScript -->
	    <script src="<c:url value="/js/admin/charts/raphael.min.js"/>" type="text/javascript"></script>
	    <script src="<c:url value="/js/admin/charts/morris.min.js"/>" type="text/javascript"></script>
	    <script src="<c:url value="/js/admin/charts/morris-data.js"/>" type="text/javascript"></script>
	</c:if>
	    <!-- Custom Theme JavaScript -->
	    <script src="<c:url value="/js/admin/sb-admin-2.js"/>" type="text/javascript"></script>
	</body>
</html>