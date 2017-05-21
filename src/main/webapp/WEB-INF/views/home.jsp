<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags/templates" prefix="templates"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>

<templates:general>
	<!-- TEST SECURITY LINK
	<a href="<c:url value="/testController"/>">Go to test page!</a>
	TEST SECURITY LINK -->
	
	<!-- UNCOMMENT WHEN LANGUAGE TOGGLE IS READY
	<%-- Set session-scoped variable to track the view user is coming from.
	     This is used by the language mechanism in the Controller so that
	     users view the same page when switching between English and Bulgarian. --%>
	<c:set var='view' value='/index' scope='session' />
	UNCOMMENT WHEN LANGUAGE TOGGLE IS READY -->

	<div id="indexLeftColumn">
	    <div id="welcomeText">
	        <p style="font-size: larger"><fmt:message key="greeting"/></p>
	
	        <p><fmt:message key='introText'/></p>
	    </div>
	</div>

	<div id="indexRightColumn">
	    <c:forEach var="category" items="${categories}">
	        <div class="categoryBox">
	            <a href="<c:url value='category/${category.id}'/>">
	                <span class="categoryLabel"></span>
	                <span class="categoryLabelText"><fmt:message key="${category.name}"/></span>
	
	                <img src="${initParam.categoryImagePath}${category.name}.jpg"
	                     alt="<fmt:message key='${category.name}'/>" class="categoryImage">
	            </a>
	        </div>
	    </c:forEach>
	</div>
</templates:general>

