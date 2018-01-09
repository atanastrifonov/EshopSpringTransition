<%@ taglib tagdir="/WEB-INF/tags/templates" prefix="templates" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<templates:backoffice>
        <!-- Page Content -->
        <div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Select a category</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            
           	<!-- /.row -->
            <div class="row">
                <div class="col-lg-6">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            Choose wisely
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                        	<c:forEach var="category" items="${categories}">
	                            <p>
	                                <a href="#" class="btn btn-primary btn-lg btn-block">${category.name}</a>
	                            </p>
                            </c:forEach>
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-6 -->
            </div>
            <!-- /.row -->
        </div>
</templates:backoffice>