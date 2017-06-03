<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div id="header">
	<div id="widgetBar">

		<div class="headerWidget">
		  <%-- If servlet path contains '/confirmation', do not display language toggle --%>
		  <c:if test="${!fn:contains(pageContext.request.servletPath,'/confirmation')}">
		    <%-- language selection widget --%>
		    <c:choose>
		      <%-- When user hasn't explicitly set language,
		           render toggle according to browser's preferred locale --%>
		      <c:when test="${empty sessionScope['javax.servlet.jsp.jstl.fmt.locale.session']}">
		        <c:choose>
		          <c:when test="${pageContext.request.locale.language ne 'bg'}">
		            english
		          </c:when>
		          <c:otherwise>
		            <c:url var="url" value="/chooseLanguage">
		              <c:param name="language" value="en"/>
		            </c:url>
		            <div class="bubble"><a href="${url}">english</a></div>
		          </c:otherwise>
		        </c:choose> |
		
		        <c:choose>
		          <c:when test="${pageContext.request.locale.language eq 'bg'}">
		            bulgarian
		          </c:when>
		          <c:otherwise>
		            <c:url var="url" value="/chooseLanguage">
		              <c:param name="language" value="bg"/>
		            </c:url>
		            <div class="bubble"><a href="${url}">bulgarian</a></div>
		          </c:otherwise>
		        </c:choose>
		      </c:when>
		
		    <%-- Otherwise, render widget according to the set locale --%>
		      <c:otherwise>
		        <c:choose>
		          <c:when test="${sessionScope['javax.servlet.jsp.jstl.fmt.locale.session'] ne 'bg'}">
		            english
		          </c:when>
		          <c:otherwise>
		            <c:url var="url" value="/chooseLanguage">
		              <c:param name="language" value="en"/>
		            </c:url>
		            <div class="bubble"><a href="${url}">english</a></div>
		          </c:otherwise>
		        </c:choose> |
		
		        <c:choose>
		          <c:when test="${sessionScope['javax.servlet.jsp.jstl.fmt.locale.session'] eq 'bg'}">
		            bulgarian
		          </c:when>
		          <c:otherwise>
		            <c:url var="url" value="/chooseLanguage">
		              <c:param name="language" value="bg"/>
		            </c:url>
		            <div class="bubble"><a href="${url}">bulgarian</a></div>
		          </c:otherwise>
		        </c:choose>
		      </c:otherwise>
		    </c:choose>
		  </c:if>
		</div>

		<%-- checkout widget --%>
		<div class="headerWidget">
		
		     <%-- DO NOT UNCOMMENT these are tests for the following: 
		          * if cart exists and is not empty
		          * if the servlet path does not contain '/checkout'
		          * if the requested view is not checkout
		          * if the servlet path does not contain '/cart'
		          * if the requested view is not cart
		          * if the checkout view is returned with order failure message flagged
		          * if the checkout view is returned with server-side validation errors detected
		
		          <c:if test="${!empty sessionScope.cart}">
		              CART EXISTS AND IS NOT NULL
		          </c:if>
		              <BR>
		          <c:if test="${sessionScope.cart.numberOfItems != 0}">
		              NUMBER OF ITEMS IN CART IS NOT 0
		          </c:if>
		              <BR>
		          <c:if test="${fn:contains(pageContext.request.servletPath,'/checkout')}">
		              SERVLET PATH CONTAINS '/checkout'
		          </c:if>
		              <BR>
		          <c:if test="${requestScope['javax.servlet.forward.servlet_path'] ne '/checkout'}">
		              REQUEST IS NOT CHECKOUT
		          </c:if>
		              <BR>
		          <c:if test="${requestScope.validationErrorFlag ne true}">
		              VALIDATION ERROR IS NOT FLAGGED
		          </c:if>
		              <BR>
		          <c:if test="${requestScope.orderFailureFlag ne true}">
		              ORDER FAILURE ERROR IS NOT FLAGGED
		          </c:if> --%>
		
			<c:if test="${!empty cart && cart.numberOfItems != 0 &&
			
			              !fn:contains(pageContext.request.servletPath,'/checkout') &&
			              requestScope['javax.servlet.forward.servlet_path'] ne '/checkout' &&
			
			              !fn:contains(pageContext.request.servletPath,'/cart') &&
			              requestScope['javax.servlet.forward.servlet_path'] ne '/cart'			
						 }">
			
			    <a href="<c:url value='checkout'/>" class="bubble">
			      <fmt:message key="proceedCheckout"/>
			    </a>
			</c:if>
		</div>

    	<%-- shopping cart widget --%>
		<div class="headerWidget" id="viewCart">
		
		  <img src="<c:url value='/img/cart.gif'/>" alt="shopping cart icon" id="cart">
		
		<%-- If 'numberOfItems' property doesn't exist, or if number of items
		     in cart is 0, output '0', otherwise output 'numberOfItems' --%>
		  <span class="horizontalMargin">
		    <c:choose>
		      <c:when test="${cart.numberOfItems == null}">
		        0
		      </c:when>
		      <c:otherwise>
		        ${cart.numberOfItems}
		      </c:otherwise>
		    </c:choose>
		
		<%-- Handle singular/plural forms of 'item' --%>
		    <c:choose>
		      <c:when test="${cart.numberOfItems == 1}">
		        <fmt:message key="item" />
		      </c:when>
		      <c:when test="${cart.numberOfItems == 2 ||
		                      cart.numberOfItems == 3 ||
		                      cart.numberOfItems == 4}">
		        <fmt:message key="items2-4" />
		      </c:when>
		      <c:otherwise>
		        <fmt:message key="items" />
		      </c:otherwise>
		    </c:choose>
		  </span>
		
		  <c:if test="${!empty cart && cart.numberOfItems != 0 &&
		
		                !fn:contains(pageContext.request.servletPath,'/cart') &&
		                requestScope['javax.servlet.forward.servlet_path'] ne '/cart'}">
		
		    <a href="<c:url value='/viewCart'/>" class="bubble">
		        <fmt:message key="cart" />
		    </a>
		  </c:if>
		</div>

	</div>

    <a href="<c:url value='/'/>">
        <img src="<c:url value='/img/logo.png'/>" id="logo" alt="Eshop logo">
    </a>

    <img src="<c:url value='/img/logoText.png'/>" id="logoText" alt="the eshop app">
</div>