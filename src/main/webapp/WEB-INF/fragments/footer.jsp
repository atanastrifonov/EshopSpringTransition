<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div id="footer">
    <br>
    <hr id="footerDivider">
    <p id="footerText" class="reallySmallText">
        <a href="<c:url value='#'/>"><s:message code="privacy" /></a>
        &nbsp;&nbsp;::&nbsp;&nbsp;
        <a href="<c:url value='#'/>"><s:message code="contact" /></a>
        &nbsp;&nbsp;&copy;&nbsp;&nbsp;
        <s:message code="all.rights.reserved" /></p>
</div>