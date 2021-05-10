
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div class="content-wrapper">
	<div class="container-fluid">
		<ol class="breadcrumb">
			<li class="breadcrumb-item"><a href="#">Vendor</a></li>
			<li class="breadcrumb-item active">Vendor Registration</li>
			<li class="breadcrumb-item"><a class="btn btn-primary right"
				href='<spring:url value="/admin/admin_dashboard"/>'>Back</a></li>
		</ol>
		<div class="alert alert-primary text-center" role="alert">
			<h2>Vendor Registration</h2>
		</div>

		<h3
			style="color: red; background-color: white; margin-right: 150px; margin-left: 150px;">${requestScope.message}</h3>
		<div class="container mt-3">
			<div class="container" style="margin-top: 50px;">
				<form:form method="post" modelAttribute="registration">
					<fieldset>
						<div class="row">
							<div class="col-lg-4 panel">
								<h2>Contact Information</h2>
							</div>
							<div class="col-lg-4 panel panel-heading"
								style="display: none; color: red" id="contact_error"></div>
						</div>

						<div class="row form-group">

							<div class="col-lg-4">
								<label class="col control-label text-center" for="mobile">
									Contact No </label>
								<div class="input-group">
									<form:input path="vendor.mobileNo" id="mobile" maxlength="10"
										name="mobile" placeholder="xxxxxxxxxxxx" class="form-control text-center"
										type="number" />
								</div>
							</div>
							
								<div class="col-lg-4">
								<label class="col control-label text-center" for="mobile">
									Email </label>
									<div class="input-group">
										<form:input path="vendor.email" id="email" name="email"
											placeholder="example@gmail.com" class="form-control text-center"
											type="email" />
									</div>
							</div>
							</div>
							<hr>
							<div class="row form-group">
								<div class="col-md-4">
								<label class="col control-label text-center" for="first_name">
									First Name </label>
									<div class="input-group">
										<i class="glyphicon glyphicon-user"></i>
										<form:input path="firstName" id="first_name" name="first_name"
											placeholder="" class="form-control text-center" type="text" />
									</div>
								</div>

								<div class="col-md-4">
								<label class="col control-label text-center" for="middle_name">
									Middle Name </label>
									<div class="input-group">
										<i class="glyphicon glyphicon-user"></i>
										<form:input path="middleName" id="middle_name"
											name="middle_name" placeholder="" class="form-control text-center"
											type="text" />
									</div>
								</div>

								<div class="col-md-4">
								<label class="col control-label text-center" for="last_name">
									Last Name </label>
									<div class="input-group">
										<i class="glyphicon glyphicon-user"></i>
										<form:input path="lastName" id="last_name" name="last_name"
											placeholder="" class="form-control text-center" type="text" />
									</div>
								</div>
							</div>
						</div>
<hr>
						<div class="row">
							<div class="col-md-4 panel">
								<h2>Shop Information</h2>
							</div>
						</div>
							<div class="row form-group">
								<div class="col-lg-4">
								<label class="col control-label text-center" for="shop_name">
									Shop Name </label>
									<div class="input-group">
										<i class="glyphicon glyphicon-user"></i>
										<form:input path="vendor.shopName" id="shop_name"
											name="shop_name" placeholder="" class="form-control text-center"
											type="text" />
									</div>
								</div>

								<div class="col-lg-4">
								<label class="col control-label text-center" for="shop_reg_no">
									Shop Registration Number </label>
									<div class="input-group">
										<i class="glyphicon glyphicon-user"></i>
										<form:input path="vendor.regNo" id="shop_reg_no"
											name="shop_reg_no" placeholder="" class="form-control text-center"
											type="text" />
									</div>
								</div>


								<div class="col-md-4">
								<label class="col control-label text-center" for="category">
									Product Category </label>
									<div class="input-group">
										<i class="glyphicon glyphicon-list"></i>
										<form:select path="vendorCategory.categoryTitle" id="category"
											name="category" class="form-control input-md ">
											<c:forEach items="${subCategoryList}" var="category">
												<option value="${category.subCTitle}">${category.subCTitle  }</option>
											</c:forEach>
										</form:select>
									</div>
								</div>
							</div>
						<hr>
						<div class="row">
							<div class="col-lg-12 panel ">
								<h2>Address Information</h2>
							</div>
						</div>

						<div class="row form-group">
							<div class="col-md-4">
							<label class="col control-label text-center" for="city">City</label>
								<div class="input-group">
									<form:input path="address.city" id="city" name="city"
										placeholder="" class="form-control text-center" type="text" />
								</div>
							</div>

							<div class="col-md-4">
							<label class="col control-label text-center" for="state">State</label>
								<div class="input-group">
									<i class="glyphicon glyphicon-list"></i>
									<form:input path="address.state" id="state" name="state"
										placeholder="" class="form-control text-center" type="text" />
								</div>
							</div>

							<div class="col-md-4">
							<label class="col control-label text-center" for="district">District</label>
								<div class="input-group">
									<i class="glyphicon glyphicon-list"></i>
									<form:input path="address.district" id="district"
										name="district" placeholder="" class="form-control text-center"
										type="text" />
								</div>
							</div>
						</div>
<hr>
						<div class="row form-group">
							<div class="col-lg">
							<label class="col control-label text-center" for="add_ln_1">Address
								Line 1</label>
								<form:input path="address.addressLine1" id="add_ln_1"
									name="add_ln_1" placeholder="street address"
									class="form-control text-center" type="text" />
							</div>

							<div class="col-lg ">
							<label class="col control-label text-center" for="add_ln_2">Address
								Line 2 </label>
								<div class="input-group">
									<i class="glyphicon glyphicon-pencil"></i>
									<form:input path="address.addressLine2" id="add_ln_2"
										name="add_ln_2" placeholder="street address"
										class="form-control text-center" type="text" />
								</div>
							</div>
						</div>
						<hr>
						<div class="row form-group">
							<div class="col-lg-12">
							<label class="col control-label text-center" for="post_office">Post
								Office</label>
								<div class="input-group">
									<i class="glyphicon glyphicon-pencil"></i>
									<form:input path="address.postOffice" id="post_office"
										name="post_office" placeholder="" class="form-control text-center"
										type="text" />
								</div>
							</div>
						</div>
						<div class="row form-group">
							<div class="col-lg-2">
							<label class="col control-label text-center" for="pin_code">Pin
								Code</label>
								<form:input path="address.pincode" id="pin_code" name="pin_code"
									placeholder="" class="form-control text-center" type="text" />
							</div>

							<div class="col-lg-5">
							<label class="col control-label text-center" for="country">Country</label>
								<div class="input-group">
									<i class="glyphicon glyphicon-pencil"></i>
									<form:input path="address.country" id="country" name="country"
										placeholder="" class="form-control text-center" type="text" />
								</div>
							</div>
						</div>

<hr>
						<div class="form-group row">
							<div class="col-md-8 text-center">
								<input type="submit" id="save" value="Register" name="save"
									class="btn btn-large btn-success">

								<button class="btn btn-large btn-danger" type="reset">Cancel</button>
							</div>
						</div>
					</fieldset>
				</form:form>
			</div>


		</div>
	</div>
</div>
