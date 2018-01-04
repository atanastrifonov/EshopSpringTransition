<%@ taglib tagdir="/WEB-INF/tags/templates" prefix="templates" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<templates:backoffice>
        <div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Edit Order</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            Please, choose order status
                        </div>
                        <div class="panel-body">
                            <div class="row">
                            	<form role="form">
	                                <div class="col-lg-6">                                    
	                                        <div class="form-group">
	                                            <label>Order Id</label>
	                                            <p class="form-control-static">${orderRecord.id}</p>
	                                        </div>
	                                       <div class="form-group">
	                                            <label>Order Total</label>
	                                            <p class="form-control-static">${orderRecord.amount}</p>
	                                        </div>
	                                        <div class="form-group">
	                                            <label>Date Created</label>
	                                            <p class="form-control-static">${orderRecord.dateCreated}</p>
	                                        </div>
	                                        <div class="form-group">
	                                            <label>Confirmation Number</label>
	                                            <p class="form-control-static">${orderRecord.confirmationNumber}</p>
	                                        </div>
	                                        <div class="form-group">
	                                            <label>Order Status</label>
	                                            <select class="form-control">
	                                                <option <c:if test="${orderRecord.status=='NEW'}">selected</c:if>>NEW</option>
	                                                <option <c:if test="${orderRecord.status=='ACCEPTED'}">selected</c:if>>ACCEPTED</option>
	                                                <option <c:if test="${orderRecord.status=='DENIED'}">selected</c:if>>DENIED</option>
	                                                <option <c:if test="${orderRecord.status=='DISPATCHED'}">selected</c:if>>DISPATCHED</option>
	                                                <option <c:if test="${orderRecord.status=='COMPLETED'}">selected</c:if>>COMPLETED</option>
	                                            </select>
	                                        </div>	                                    
	                                </div>
	                                <!-- /.col-lg-6 (nested) -->
	                                <div class="col-lg-6">
	                                        <div class="form-group">
	                                            <label>Customer Name</label>
	                                            <p class="form-control-static">${customer.name}</p>
	                                        </div>
	                                        <div class="form-group">
	                                            <label>Customer Phone</label>
	                                            <p class="form-control-static">${customer.phone}</p>
	                                        </div>
	                                        <div class="form-group">
	                                            <label>Customer E-mail</label>
	                                            <p class="form-control-static">${customer.email}</p>
	                                        </div>
	                                        <div class="form-group">
	                                            <label>Customer Address</label>
	                                            <p class="form-control-static">${customer.address}</p>
	                                        </div>
	                                        <div class="form-group">
	                                            <label>Customer city region</label>
	                                            <p class="form-control-static">${customer.cityRegion}</p>
	                                        </div>                                     
	                                </div>
	                                <!-- /.col-lg-6 (nested) -->
	                                <div class="col-lg-6">
                                		<h3>Products</h3>
                                		<c:forEach var="product" items="${products}">
	                   	                    <div class="form-group">
	                                            <label>${product.name}</label>
	                                            <p class="form-control-static"><b><i>Price :</i></b> ${product.price}</p>
	                                        </div>
                                        </c:forEach>
	                                </div>
                                    <!-- /.col-lg-6 (nested) -->
	                                <div class="col-lg-6">
		                                <button type="submit" class="btn btn-default">Submit Button</button>
	                                    <a href="<c:url value='/backoffice/orders/pending'/>" class="btn btn-default">Go Back</a>
                                    </div>
                                    <!-- /.col-lg-6 (nested) -->
                                </form>                                                              
                            </div>
                            <!-- /.row (nested) -->
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