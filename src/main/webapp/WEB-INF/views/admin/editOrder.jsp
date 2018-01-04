<%@ taglib tagdir="/WEB-INF/tags/templates" prefix="templates" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

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
                            	<c:url value='editOrder' var="formAction" />
                            	<sf:form role="form" commandName="editOrderForm" action="${formAction}" method="POST">
                            	
                            	 	<c:if test = "${isUpdateSuccessful eq true}">
			                 	 	     <div class="alert alert-success alert-dismissable">
			                                <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
			                                Status has been successfully updated!
			                            </div>
		                            </c:if>		                            
		                            <c:if test = "${hasErrors eq true}">
	                            	    <div class="alert alert-danger alert-dismissable">
			                                <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
			                                Errors in updating status!
	                           	 		</div>
                           	 		</c:if>    
                          	 		                  	
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
												<sf:select path="status" class="form-control">
	                                                <option value="NEW" <c:if test="${orderRecord.status=='NEW'}">selected</c:if>>NEW</option>
	                                                <option value="ACCEPTED" <c:if test="${orderRecord.status=='ACCEPTED'}">selected</c:if>>ACCEPTED</option>
	                                                <option value="DENIED" <c:if test="${orderRecord.status=='DENIED'}">selected</c:if>>DENIED</option>
	                                                <option value="DISPATCHED" <c:if test="${orderRecord.status=='DISPATCHED'}">selected</c:if>>DISPATCHED</option>
	                                                <option value="COMPLETED" <c:if test="${orderRecord.status=='COMPLETED'}">selected</c:if>>COMPLETED</option>
	                                            </sf:select>
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
		                                <button type="submit" class="btn btn-default">Change Status</button>
	                                    <a href="<c:url value='/backoffice/orders/pending'/>" class="btn btn-default">Go Back</a>
                                    </div>
                                    <!-- /.col-lg-6 (nested) -->
                                    
                                    <sf:hidden path="orderId" value="${orderRecord.id}"/>
                                </sf:form>                                                              
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