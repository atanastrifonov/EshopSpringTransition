<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags/templates" prefix="templates"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ page isELIgnored="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<templates:general>
	<%-- Set session-scoped variable to track the view user is coming from.
	     This is used by the language mechanism in the Controller so that
	     users view the same page when switching between English and Bulgarian. 
	<c:set var='view' value='/category' scope='session' />
	 --%>

	<div id="categoryLeftColumn">
	
	    <c:forEach var="category" items="${categories}">
	
	        <c:choose>
	            <c:when test="${category.name == selectedCategory.name}">
	                <div class="categoryButton" id="selectedCategory">
	                    <span class="categoryText">
	                        <s:message code="${category.name}"/>
	                    </span>
	                </div>
	            </c:when>
	            <c:otherwise>
	                <a href="<c:url value='/category/${category.id}'/>" class="categoryButton">
	                    <span class="categoryText">
	                        <s:message code="${category.name}"/>
	                    </span>
	                </a>
	            </c:otherwise>
	        </c:choose>
	
	    </c:forEach>
	
	</div>

	<div id="categoryRightColumn">
	
	    <p id="categoryTitle"><s:message code="${selectedCategory.name}" /></p>
	
	    <table id="productTable">
	
	        <c:forEach var="product" items="${selectedCategory.allProducts}" varStatus="iter">
	
	            <tr class="${((iter.index % 2) == 0) ? 'lightBlue' : 'white'}">
	                <td>                
	                    <img src="<c:url value='/${initParam.productImagePath}${product.name}.png'/>"
	                         alt="<s:message code='${product.name}'/>">
	                </td>
	
	                <td>
	                    <s:message code="${product.name}"/>
	                    <br>
	                    <span class="smallText"><s:message code='${product.name}Description'/></span>
	                </td>
	
	                <td><fmt:formatNumber type="currency" currencySymbol="&euro; " value="${product.price}"/></td>
	
	                <td>
	                    <form action="<c:url value='addToCart'/>" method="post">
	                        <input type="hidden"
	                               name="productId"
	                               value="${product.id}">
	                        <input type="submit"
	                               name="submit"
	                               value="<s:message code='addToCart'/>">
	                    </form>
	                </td>
	            </tr>
	
	        </c:forEach>
	
	    </table>
	</div>
</templates:general>
