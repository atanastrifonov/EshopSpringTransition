<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib tagdir="/WEB-INF/tags/templates" prefix="templates"%>

<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<templates:general>
	<h2><s:message code="welcome.message" /></h2>
	<a href="<c:url value="/testController"/>">Go to test page!</a>
</templates:general>

