<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<c:set var="addr"
	value="${sessionScope.customerDetails.additionalDetails.customerAddress}" />

<section style="background-color: #f7f7f7;">
	<div class="container">
		<div class="row">

			<div class="row">
				<div class="col-lg-12 panel ">
					<h2>Customer Address Information</h2>
				</div>
			</div>

			<div class="row form-group">
				<div class="col-md-4">
					<label class="col control-label text-center" for="city">City</label>
					<div class="input-group">
						<input id="city" class="form-control text-center"
							value="${addr.city}" type="text" readonly />
					</div>
				</div>

				<div class="col-md-4">
					<label class="col control-label text-center" for="state">State</label>
					<div class="input-group">
						<input id="state" value="${addr.state}"
							class="form-control text-center" type="text" readonly />
					</div>
				</div>

				<div class="col-md-4">
					<label class="col control-label text-center" for="district">District</label>
					<div class="input-group">
						<input id="district" value="${addr.district}"
							class="form-control text-center" type="text" readonly />
					</div>
				</div>
			</div>
			<hr>
			<div class="row form-group">
				<div class="col-lg">
					<label class="col control-label text-center" for="add_ln_1">Address
						Line 1</label> <input id="add_ln_1" value="${addr.addressLine1}"
						class="form-control" type="text" readonly />
				</div>

				<div class="col-lg ">
					<label class="col control-label text-center" for="add_ln_2">Address
						Line 2 </label> <input id="add_ln_2" value="${addr.addressLine2}"
						class="form-control" type="text" readonly />
				</div>
			</div>
			<hr>
			<div class="row form-group">
				<div class="col-lg-4">
					<label class="col control-label text-center" for="post_office">Post
						Office</label> <input id="post_office" value="${addr.postOffice}"
						class="form-control text-center" type="text" readonly />
				</div>

				<div class="col-lg-2">
					<label class="col control-label text-center" for="pin_code">Pin
						Code</label> <input id="pin_code" value="${addr.pincode}"
						class="form-control text-center" type="text" readonly />
				</div>

				<div class="col-lg-4">
					<label class="col control-label text-center" for="country">Country</label>

					<input id="country" value="${addr.country}"
						class="form-control text-center" type="text" readonly />
				</div>
			</div>
			<lable> <input type="checkbox" id="cbox" name="cbox">Customer
			address and Shipping address are same</lable>
			<form:form method="post" modelAttribute="shipAddress">

				<div class="row">
					<div class="col-lg-12 panel ">
						<h2>Shipping Address Information</h2>
					</div>
				</div>

				<div class="row form-group">
					<div class="col-md-4">
						<label class="col control-label text-center" for="city">City</label>
						<div class="input-group">
							<form:input path="city" id="bcity" placeholder=""
								class="form-control text-center" type="text" />
						</div>
					</div>

					<div class="col-md-4">
						<label class="col control-label text-center" for="state">State</label>
						<div class="input-group">
							<form:input path="state" id="bstate" placeholder=""
								class="form-control text-center" type="text" />
						</div>
					</div>

					<div class="col-md-4">
						<label class="col control-label text-center" for="district">District</label>
						<div class="input-group">
							<form:input path="district" id="bdistrict" placeholder=""
								class="form-control text-center" type="text" />
						</div>
					</div>
				</div>
				<hr>
				<div class="row form-group">
					<div class="col-lg">
						<label class="col control-label text-center" for="add_ln_1">Address
							Line 1</label>
						<form:input path="addressLine1" id="badd_ln_1"
							placeholder="street address" class="form-control"
							type="text" />
					</div>

					<div class="col-lg ">
						<label class="col control-label text-center" for="add_ln_2">Address
							Line 2 </label> 
						<form:input path="addressLine2" id="badd_ln_2"
							placeholder="street address" class="form-control"
							type="text" />
					</div>
				</div>
				<hr>
				<div class="row form-group">
					<div class="col-lg-4">
						<label class="col control-label text-center" for="post_office">Post
							Office</label>
						<form:input path="postOffice" id="bpost_office" placeholder=""
							class="form-control text-center" type="text" />
					</div>
					<div class="col-lg-2">
						<label class="col control-label text-center" for="pin_code">Pin
							Code</label>
						<form:input path="pincode" id="bpin_code" placeholder=""
							class="form-control text-center" type="text" />
					</div>

					<div class="col-lg-5">
						<label class="col control-label text-center" for="country">Country</label>
						<form:input path="country" id="bcountry" placeholder=""
							class="form-control text-center" type="text" />
					</div>
				</div>

				<div class="form-group row">
					<div class="col-md-8 text-center">
						<input type="submit" id="save" value="Proceed" name="save"
							class="btn btn-large btn-success">

						<button class="btn btn-large btn-danger" type="reset">Cancel</button>
					</div>
				</div>
			</form:form>
		</div>
	</div>
</section>
