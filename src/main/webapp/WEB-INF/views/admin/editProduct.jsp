<%@ taglib tagdir="/WEB-INF/tags/templates" prefix="templates" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<templates:backoffice>
        <div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Edit Product</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            Edit product here
                        </div>
                        <div class="panel-body">
                            <div class="row">
                                <div class="col-lg-6">
                                	<c:url value='editProduct' var="formAction" />
                                    <sf:form role="form" commandName="editProductForm" action="${formAction}" method="POST">
                                    
                                    	<c:if test = "${isUpdateSuccessful eq true}">
				                 	 	     <div class="alert alert-success alert-dismissable">
				                                <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
				                                Product has been successfully updated!
				                            </div>
			                            </c:if>		                            
			                            <c:if test = "${hasErrors eq true}">
		                            	    <div class="alert alert-danger alert-dismissable">
				                                <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
				                                Errors in updating product!
		                           	 		</div>
	                           	 		</c:if>
                                    
                                        <div class="form-group">
                                            <sf:label path="name">Product Name</sf:label>
                                            <sf:input path="name" class="form-control" />
                                            <p class="help-block">Example block-level help text here.</p>
                                        </div>
                                        <div class="form-group">
                                            <sf:label path="price">Product Price</sf:label>
                                            <sf:input path="price" class="form-control"/>
                                            <p class="help-block">Example block-level help text here.</p>
                                        </div>
                                        <div class="form-group">
                                            <sf:label path="description">Product Description</sf:label>
                                            <sf:textarea path="description" class="form-control" rows="3"></sf:textarea>
                                        </div>
                                        <div class="form-group">
                                            <sf:label path="categoryId">Product Category</sf:label>
                                            <sf:select path="categoryId" class="form-control">
			                                	<c:forEach var="category" items="${categories}">
			                                		<option value="${category.id}"
	                                					<c:if test="${editProductForm.categoryId eq category.id}">selected</c:if>>${category.name}
                                					</option>
			                                    </c:forEach>
                                            </sf:select>
                                        </div>
                                        <button type="submit" class="btn btn-default">Update Product</button>
                                        <a href="<c:url value='/backoffice/products/chooseCategory?categoryId=${editProductForm.categoryId}'/>" class="btn btn-default">Go Back</a>
                                    
                                    	<sf:hidden path="productId"/>
                                    </sf:form>
                                </div>
                                <!-- /.col-lg-6 (nested) -->
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