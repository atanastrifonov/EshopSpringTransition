<%@ taglib tagdir="/WEB-INF/tags/templates" prefix="templates" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<templates:backoffice>
        <div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Pending orders</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            DataTables Advanced Tables
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <table width="100%" class="table table-striped table-bordered table-hover" id="dataTables-example">
                                <thead>
                                    <tr>
                                        <th>Order Id</th>
                                        <th>Amount</th>
                                        <th>Date created</th>
                                        <th>Confirmation Number</th>
                                        <th>Status</th>
                                    </tr>
                                </thead>
                                <tbody>
                                	<c:forEach var="pendingOrder" items="${pendingOrders}">
	                                    <tr>
	                                        <td><c:out value="${pendingOrder.id}"/></td>
	                                        <td><c:out value="${pendingOrder.amount}"/></td>
	                                        <td><c:out value="${pendingOrder.dateCreated}"/></td>
	                                        <td class="center"><c:out value="${pendingOrder.confirmationNumber}"/></td>
	                                        <td class="center"><c:out value="${pendingOrder.status}"/></td>
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