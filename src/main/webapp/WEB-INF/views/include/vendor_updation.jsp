
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div class="content-wrapper">
	<div class="container-fluid">
		<ol class="breadcrumb">
			<li class="breadcrumb-item"><a href="#">Vendor</a></li>
			<li class="breadcrumb-item active">Update Vendor Details</li>
		</ol>
		<div class="alert alert-primary text-center" role="alert">
			<h2>Update Vendor Details</h2>
		</div>

		<h3
			style="color: red; background-color: white; margin-right: 150px; margin-left: 150px;">${requestScope.message}</h3>
		<div class="container mt-3">


			<div class="container" style="margin-top: 50px;">
				<form:form method="post" modelAttribute="vendor">
					<fieldset>

						<div class="row">
							<div class="col-md-4 panel">
								<h2>Contact Information</h2>
							</div>
							<div class="col-md-4 panel panel-heading"
								style="display: none; color: red" id="contact_error"></div>
						</div>

						<div class="row form-group">
						<label class="col-md-1 control-label" for="mobile">
								Vendor ID </label>
							<div class="col-lg-3">
								<div class="input-group">

									<i class="fa fa-phone" aria-hidden="true"></i>
									<form:input path="vendorInfo.id" id="id" maxlength="10"
										name="id"  class="form-control"
										type="number" readonly="true" value="${vendorInformation.id}" />
								</div>
							</div>
							<label class="col-md-1 control-label" for="mobile">
								Contact No. </label>
							<div class="col-lg-3">
								<div class="input-group">

									<i class="fa fa-phone" aria-hidden="true"></i>
									<form:input path="vendorInfo.mobileNo" id="mobile" maxlength="10"
										name="mobile" placeholder="xxxxxxxxxxxx" class="form-control"
										type="number" readonly="true" value="${vendorInformation.mobileNo}" />
								</div>
							</div>
							<div class="row form-group">
								<label class="col-md-2 control-label" for="mobile">
									Email. </label>
								<div class="col">
									<div class="input-group">

										<i class="fas fa-envelope-open-text"></i>
										<form:input path="vendorInfo.email" id="email" name="email"
											placeholder="example@gmail.com" class="form-control"
											type="email" readonly="true" value="${vendorInformation.email}" />
									</div>
								</div>
							</div>
							</div>
							
							<div class="row form-group">
								<label class="col-lg-2 control-label" for="first_name">Full
									Name</label>
								<div class="col-lg-8">
									<div class="input-group">
										<span class="input-group-addon"> <i
											class="glyphicon glyphicon-user"></i>
										</span>
										<form:input path="vendorInfo.fullName" id="full_name" name="full_name"
											placeholder="" class="form-control input-md" type="text"
											value="${vendorInformation.fullName}" />
									</div>
								</div>

							</div>
						

						<div class="row">
							<div class="col-md-4 panel">
								<h2>Shop Information</h2>
							</div>
							<div class="row form-group">
								<label class="col-md-2 control-label" for="shop_name">
									Shop Name. </label>
								<div class="col-lg-4">
									<div class="input-group">
										<span class="input-group-addon"> <i
											class="glyphicon glyphicon-user"></i>
										</span>
										<form:input path="vendorInfo.shopName" id="shop_name" name="shop_name"
											placeholder="" class="form-control input-md" type="text"
											value="${vendorInformation.shopName}" />
									</div>
								</div>

								<label class="col-md-2 control-label" for="shop_reg_no">
									Shop Registration No. </label>
								<div class="col-lg-4">
									<div class="input-group">
										<span class="input-group-addon"> <i
											class="glyphicon glyphicon-user"></i>
										</span>
										<form:input path="vendorInfo.regNo" id="shop_reg_no" name="shop_reg_no"
											placeholder="" class="form-control input-md" type="text"
											readonly="true" value="${vendorInformation.regNo}" />
									</div>
								</div>

								<%-- <form:checkboxes items="${subCategories}" path="vendor.vendorCategories"/> --%>
								<%-- itemLabel="subCTitle" itemValue="id" --%>
										 <%-- <input type="checkbox" name="${subCategories}" id=""> --%> 
								
								<script type="text/javascript">
								
								</script>
								<label class="col-lg-2 control-label" for="categories">
								Product Category
								</label>
								<div class="col-lg-10">
									<div class="input-group">
										 <i class="glyphicon glyphicon-list"></i>
										<form:checkboxes path="strs" itemValue="id"  items="${subCategories}" id="id" itemLabel="subCTitle" />
									</div>
								</div> <!-- vendor categories - , vendor password -->
							</div>
						</div>
					
				

		<div class="row">
			<div class="col-md-4 panel ">
				<h2>Address Information</h2>
			</div>
			<div class="col-md-4 panel panel-heading"
				style="display: none; color: red" id="address_error"></div>
		</div>

		<div class="row form-group">
			<label class="col-md-2 control-label" for="city">City</label>
			<div class="col-md-2">
				<div class="input-group">
					<span class="input-group-addon"> <i
						class="glyphicon glyphicon-home"></i>
					</span>
					<form:input path="vendorAddress.city" id="city" name="city"
						placeholder="" class="form-control input-md" type="text"
						value="${addressInformation.city}" />
				</div>
			</div>

			<label class="col-md-1 control-label" for="state">State</label>
			<div class="col-md-2">
				<div class="input-group">
					<span class="input-group-addon"> <i
						class="glyphicon glyphicon-list"></i>
					</span>
					<form:input path="vendorAddress.state" id="state" name="state"
						placeholder="" class="form-control input-md" type="text"
						value="${addressInformation.state}" />
				</div>
			</div>

			<label class="col-md-1 control-label" for="district">District</label>
			<div class="col-md-2">
				<div class="input-group">
					<span class="input-group-addon"> <i
						class="glyphicon glyphicon-list"></i>
					</span>
					<form:input path="vendorAddress.district" id="district"
						name="district" placeholder=""
						class="form-control input-md ac_district" type="text"
						value="${addressInformation.district}" />
				</div>
			</div>
		</div>
		<div class="row form-group">
			<label class="col-lg-2 control-label" for="add_ln_1">Address
				Line 1</label>
			<div class="col-lg">
				<form:input path="vendorAddress.addressLine1" id="add_ln_1"
					name="add_ln_1" placeholder="street address"
					class="form-control input-md" type="text"
					value="${addressInformation.addressLine1}" />
			</div>

			<label class="col-lg-2 control-label" for="add_ln_2">Address
				Line 2 </label>
			<div class="col-lg ">
				<div class="input-group">
					<!-- <span class="input-group-addon"> <i
										class="glyphicon glyphicon-pencil"></i>
									</span>  -->
					<form:input path="vendorAddress.addressLine2" id="add_ln_2"
						name="add_ln_2" placeholder="street address"
						class="form-control input-md" type="text"
						value="${addressInformation.addressLine2}" />
				</div>
			</div>
		</div>
		<div class="row form-group">
		<label class="col-lg-2 control-label" for="post_office">Post
			Office</label>
		<div class="col-lg-6">
			<div class="input-group">
				<!-- <span class="input-group-addon"> <i
									class="glyphicon glyphicon-pencil"></i>
								</span>  -->
				<form:input path="vendorAddress.postOffice" id="post_office"
					name="post_office" placeholder=""
					class="form-control input-md ac_post_office" type="text"
					value="${addressInformation.postOffice}" />
			</div>
		</div>
		</div>

		<div class="row form-group">
			<label class="col-lg-2 control-label" for="pin_code">Pin Code</label>
			<div class="col-lg-2">
				<form:input path="vendorAddress.pincode" id="pin_code"
					name="pin_code" placeholder="" class="form-control input-md"
					type="text" value="${addressInformation.pincode}" />
			</div>

			<label class="col-lg-1 control-label" for="country">Country </label>
			<div class="col-lg-5">
				<div class="input-group">
					<span class="input-group-addon"> <i
						class="glyphicon glyphicon-pencil"></i>
					</span>
					<form:input path="vendorAddress.country" id="country"
						name="country" placeholder="" class="form-control input-md"
						type="text" value="${addressInformation.country}" />
				</div>
			</div>
		</div>


		<div class="row form-group">
			<div class="col-lg-12 text-center">
				<input type="submit" id="save" value="Update" name="save"
					class="btn btn-large btn-success">

				<a class="btn btn-large btn-danger" href='<spring:url value="/admin/vendor_details"/>'>Cancel</a>
			</div>
		</div>
		</fieldset>
		</form:form>
	</div>


</div>
</div>
</div>
