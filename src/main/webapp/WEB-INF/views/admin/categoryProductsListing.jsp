<%@ taglib tagdir="/WEB-INF/tags/templates" prefix="templates" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<templates:backoffice>
        <div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">${selectedCategory.name} products</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            Products assigned to this category
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <table width="100%" class="table table-striped table-bordered table-hover" id="dataTables-example">
                                <thead>
                                    <tr>
                                        <th>Name</th>
                                        <th>Product Id</th>
                                        <th>Price</th>
                                        <th>Last update</th>
                                    </tr>
                                </thead>
                                <tbody>
                                	<c:forEach var="product" items="${selectedCategory.allProducts}">
	                                    <tr>
	                                        <td><a href="<c:url value='/backoffice/products/${product.id}'/>"><c:out value="${product.name}"/></a></td>
	                                        <td><c:out value="${product.id}"/></td>
	                                        <td><c:out value="${product.price}"/></td>
	                                        <td class="center"><c:out value="${product.lastUpdate}"/></td>
	                                    </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                            <!-- /.table-responsive -->
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
        </div>
        <!-- /#page-wrapper -->
</templates:backoffice>