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
	                                            <p class="form-control-static">12345</p>
	                                        </div>
	                                       <div class="form-group">
	                                            <label>Order Total</label>
	                                            <p class="form-control-static">500.43</p>
	                                        </div>
	                                        <div class="form-group">
	                                            <label>Date Created</label>
	                                            <p class="form-control-static">Mon 1st Jan 2018</p>
	                                        </div>
	                                        <div class="form-group">
	                                            <label>Confirmation Number</label>
	                                            <p class="form-control-static">54321</p>
	                                        </div>
	                                        <div class="form-group">
	                                            <label>Order Status</label>
	                                            <select class="form-control">
	                                                <option>NEW</option>
	                                                <option>ACCEPTED</option>
	                                                <option>DENIED</option>
	                                                <option>DISPATCHED</option>
	                                                <option>COMPLETED</option>
	                                            </select>
	                                        </div>	                                    
	                                </div>
	                                <!-- /.col-lg-6 (nested) -->
	                                <div class="col-lg-6">
	                                        <div class="form-group">
	                                            <label>Customer</label>
	                                            <p class="form-control-static">Atanas Trifonov</p>
	                                        </div>
	                                        <div class="form-group">
	                                            <label>Customer</label>
	                                            <p class="form-control-static">Atanas Trifonov</p>
	                                        </div>
	                                        <div class="form-group">
	                                            <label>Customer</label>
	                                            <p class="form-control-static">Atanas Trifonov</p>
	                                        </div>
	                                        <div class="form-group">
	                                            <label>Customer</label>
	                                            <p class="form-control-static">Atanas Trifonov</p>
	                                        </div>
	                                        <div class="form-group">
	                                            <label>Customer</label>
	                                            <p class="form-control-static">Atanas Trifonov</p>
	                                        </div>                                     
	                                </div>
	                                <!-- /.col-lg-6 (nested) -->
	                                <div class="col-lg-6">
		                                <button type="submit" class="btn btn-default">Submit Button</button>
	                                    <button type="reset" class="btn btn-default">Reset Button</button>  
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