<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page isELIgnored="false" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3 style="color:red">It works!!!!!!</h3>

<p>Selected language is: ${language} </p>

<h1>Start Table</h1>
<%-- 
<sql:query var="result" dataSource="jdbc/eShop">
    SELECT * FROM category, product
    WHERE category.id = product.category_id
</sql:query>

<table border="1">
    <!-- column headers -->
    <tr>
        <c:forEach var="columnName" items="${result.columnNames}">
            <th><c:out value="${columnName}"/></th>
        </c:forEach>
    </tr>
    <!-- column data -->
    <c:forEach var="row" items="${result.rowsByIndex}">
        <tr>
            <c:forEach var="column" items="${row}">
                <td><c:out value="${column}"/></td>
            </c:forEach>
        </tr>
    </c:forEach>
</table>
--%>
<table border="1">
    <!-- column headers -->
    <tr>
        <c:forEach var="category" items="${categories}">
            <th><c:out value="${category.name}"/></th>
        </c:forEach>
    </tr>
</table>


</body>
</html>