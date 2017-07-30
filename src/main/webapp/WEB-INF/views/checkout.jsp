<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags/templates" prefix="templates" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ page isELIgnored="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<templates:general>
	<%-- Set session-scoped variable to track the view user is coming from.
	     This is used by the language mechanism in the Controller so that
	     users view the same page when switching between English and Bulgarian. --%>
	<c:set var='view' value='/checkout' scope='session' />

	<div id="singleColumn">
	
	    <h2><fmt:message key="checkout"/></h2>
	
	    <p><fmt:message key="checkoutText"/></p>
	
	    <c:if test="${!empty orderFailureFlag}">
	        <p class="error"><fmt:message key="orderFailureError"/></p>
	    </c:if>
	    
		<c:url value='purchase' var="formAction" />
	    <sf:form commandName="customerDetailsForm" action="${formAction}" method="POST">
	        <table id="checkoutTable">
	        
	          <tr>
	          	<td colspan="2" style="text-align:left">
	          		<sf:errors path="*" element="div" cssClass="validationErrors" />
	          	</td>
	          </tr>
	          	          
	            <tr>
	                <td><sf:label path="name" cssErrorClass="validationError"><fmt:message key="customerName"/>:</sf:label></td>
	                <td class="inputField">
	                    <sf:input path="name"
	                    	   type="text"
	                           size="31"
	                           maxlength="45"
	                           cssErrorClass="validationError" />
	                </td>
	            </tr>
	            <tr>
	                <td><sf:label path="email" cssErrorClass="validationError"><fmt:message key="email"/>:</sf:label></td>
	                <td class="inputField">
	                    <sf:input path="email"
	                           type="email"
	                           size="31"
	                           maxlength="45"
	                           cssErrorClass="validationError" />
	                </td>
	            </tr>
	            <tr>
	                <td><sf:label path="phone" cssErrorClass="validationError"><fmt:message key="phone"/>:</sf:label></td>
	                <td class="inputField">
	                    <sf:input path="phone"
	                           type="text"
	                           size="31"
	                           maxlength="16"
	                           cssErrorClass="validationError" />
	                </td>
	            </tr>
	            <tr>
	                <td><sf:label path="address" cssErrorClass="validationError"><fmt:message key="address"/>:</sf:label></td>
	                <td class="inputField">
	                    <sf:input path="address"
	                           type="text"
	                           size="31"
	                           maxlength="45"
	                           cssErrorClass="validationError" />
	
	                    <br>
	                    <fmt:message key="street.number"/>
	                    <sf:select path="cityRegion">
	                      <c:forEach begin="1" end="10" var="regionNumber">
	                        <option value="${regionNumber}"
	                                <c:if test="${param.cityRegion eq regionNumber}">selected</c:if>>${regionNumber}</option>
	                      </c:forEach>
	                    </sf:select>
	                </td>
	            </tr>
	            <tr>
	                <td><sf:label path="ccNumber" cssErrorClass="validationError"><fmt:message key="creditCard"/>:</sf:label></td>
	                <td class="inputField">
	                    <sf:input path="ccNumber"
	                           type="text"
	                           size="31"
	                           maxlength="19"
	                           class="creditcard"
	                           cssErrorClass="validationError" />
	                </td>
	            </tr>
	            <tr>
	                <td colspan="2">
	                    <input type="submit" value="<fmt:message key='submit'/>">
	                </td>
	            </tr>
	        </table>
	    </sf:form>
	
	    <div id="infoBox">
	
	        <ul>
	            <li><fmt:message key="nextDayGuarantee"/></li>
	            <li><fmt:message key="deliveryFee1"/>
	                <fmt:formatNumber type="currency" currencySymbol="&euro; " value="${initParam.deliverySurcharge}"/>
	                <fmt:message key="deliveryFee2"/></li>
	        </ul>
	
	        <table id="priceBox">
	            <tr>
	                <td><fmt:message key="subtotal"/>:</td>
	                <td class="checkoutPriceColumn">
	                    <fmt:formatNumber type="currency" currencySymbol="&euro; " value="${cart.subtotal}"/></td>
	            </tr>
	            <tr>
	                <td><fmt:message key="surcharge"/>:</td>
	                <td class="checkoutPriceColumn">
	                    <fmt:formatNumber type="currency" currencySymbol="&euro; " value="${initParam.deliverySurcharge}"/></td>
	            </tr>
	            <tr>
	                <td class="total"><fmt:message key="total"/>:</td>
	                <td class="total checkoutPriceColumn">
	                    <fmt:formatNumber type="currency" currencySymbol="&euro; " value="${cart.total}"/></td>
	            </tr>
	        </table>
	    </div>
	</div>
</templates:general>