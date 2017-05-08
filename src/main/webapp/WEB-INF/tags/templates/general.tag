<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>

<!-- UNCOMMENT WHEN LANGUAGE TOGGLE IS READY 
	<%-- Set language based on user's choice --%>
	<c:if test="${!empty language}">
	    <fmt:setLocale value="${language}" scope="session" />
	</c:if>
UNCOMMENT WHEN LANGUAGE TOGGLE IS READY -->

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/eshop.css">
        <link rel="shortcut icon" href="img/favicon.ico">
        
        <script src="js/jquery-1.4.2.js" type="text/javascript"></script>
        <script src="js/jquery-ui-1.8.4.custom.min.js" type="text/javascript"></script>
        
        <script type="text/javascript">
            $(document).ready(function(){
                $('a.categoryButton').hover(
                    function () {$(this).animate({backgroundColor: '#b2d2d2'})},
                    function () {$(this).animate({backgroundColor: '#d3ede8'})}
                );

                $('div.categoryBox').hover(over, out);

                function over() {
                    var span = this.getElementsByTagName('span');
                    $(span[0]).animate({opacity: 0.3});
                    $(span[1]).animate({color: 'white'});

                }

                function out() {
                    var span = this.getElementsByTagName('span');
                    $(span[0]).animate({opacity: 0.7});
                    $(span[1]).animate({color: '#444'});
                }
            });
        </script>
        
        <title><s:message code="tab.title" /></title>
	</head>
	<body>
		<div id="main">
			<jsp:include page="/WEB-INF/fragments/header.jsp"></jsp:include>
			<jsp:doBody />			
			<jsp:include page="/WEB-INF/fragments/footer.jsp"></jsp:include>
		</div>
	</body>
</html>