
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div class="content-wrapper">
	<div class="container-fluid">
		<ol class="breadcrumb">
			<li class="breadcrumb-item"><a href="#">Product</a></li>
			<li class="breadcrumb-item active">Add Product</li>
			<li class="breadcrumb-item">
			<a class="btn btn-primary right" href='<spring:url value="/vendor/vendor_dashboard"/>'>Back</a></li>
		</ol>
		<div class="alert alert-primary text-center" role="alert">
			<h2>Add Product</h2>
		</div>

		<h3
			style="color: red; background-color: white; margin-right: 150px; margin-left: 150px;">${requestScope.message}</h3>
		<div class="container mt-3">
			<div class="container" style="margin-top: 50px;">
				<form method="post">
					<fieldset>
						<div class="row">
							<label class="col-md-2 control-label" for="category">
								Product Category
								</label>
								
								<div class="col-lg-10">
									<div class="input-group">
										 <i class="glyphicon glyphicon-list"></i>
										<select id="category" name="category" class="form-control input-md">
											<c:forEach items="${vendorCategory}" var="category">
						                	<option value="${category.categoryTitle}">${category.categoryTitle}</option>
						                    </c:forEach>
										</select>
									</div>
								</div>
							</div>
							<div class="row">
							&nbsp;
							</div>
						<div class="form-group row">
							<div class="col-md-8 text-center">
								<input type="submit" id="save" value="Get Form" name="save"
									class="btn btn-large btn-success">

							
							</div>
						</div>
					</fieldset>
				</form>
			</div>


		</div>
	</div>
</div>
