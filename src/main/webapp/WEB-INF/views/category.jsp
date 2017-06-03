<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags/templates" prefix="templates"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ page isELIgnored="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<templates:general>
	<%--Set session-scoped variable to track the view user is coming from.
    This is used by the language mechanism in the Controller so that
    users view the same page when switching between English and Bulgarian. --%>
	<c:set var='view' value='/category/${selectedCategory.id}' scope='session' />
	
	<div id="categoryLeftColumn">
	
	    <c:forEach var="category" items="${categories}">
	
	        <c:choose>
	            <c:when test="${category.name == selectedCategory.name}">
	                <div class="categoryButton" id="selectedCategory">
	                    <span class="categoryText">
	                        <fmt:message key="${category.name}"/>
	                    </span>
	                </div>
	            </c:when>
	            <c:otherwise>
	                <a href="<c:url value='/category/${category.id}'/>" class="categoryButton">
	                    <span class="categoryText">
	                        <fmt:message key="${category.name}"/>
	                    </span>
	                </a>
	            </c:otherwise>
	        </c:choose>
	
	    </c:forEach>
	
	</div>

	<div id="categoryRightColumn">
	
	    <p id="categoryTitle"><fmt:message key="${selectedCategory.name}" /></p>
	
	    <table id="productTable">
	
	        <c:forEach var="product" items="${selectedCategory.allProducts}" varStatus="iter">
	
	            <tr class="${((iter.index % 2) == 0) ? 'lightBlue' : 'white'}">
	                <td>                
	                    <img src="<c:url value='/${initParam.productImagePath}${product.name}.png'/>"
	                         alt="<fmt:message key='${product.name}'/>">
	                </td>
	
	                <td>
	                    <fmt:message key="${product.name}"/>
	                    <br>
	                    <span class="smallText"><fmt:message key='${product.name}Description'/></span>
	                </td>
	
	                <td><fmt:formatNumber type="currency" currencySymbol="&euro; " value="${product.price}"/></td>
	
	                <td>
	                    <form action="<c:url value='/addToCart'/>" method="post">
	                        <input type="hidden"
	                               name="productId"
	                               value="${product.id}">
                           	<input type="hidden"  
                           		   name="${_csrf.parameterName}"   
                           		   value="${_csrf.token}"/>
	                        <input type="submit"
	                               name="submit"
	                               value="<fmt:message key='addToCart'/>">
	                    </form>
	                </td>
	            </tr>
	
	        </c:forEach>
	
	    </table>
	</div>
</templates:general>
