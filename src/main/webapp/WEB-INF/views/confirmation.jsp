<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags/templates" prefix="templates"%>

<%@ page isELIgnored="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<templates:general>
	<p>confirmation page</p>
		Name : ${name} </br>
		Email : ${email} </br>
		Address : ${address} </br>
		CC Number : ${ccNumber} </br>
		Phone : ${phone} </br>
		City Region : ${cityRegion} </br>
</templates:general>