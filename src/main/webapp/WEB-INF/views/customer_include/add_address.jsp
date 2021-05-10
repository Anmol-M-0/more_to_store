<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<section style="background-color: #f7f7f7;">
	<div class="container">
		<div class="row">
			<form:form method="post" modelAttribute="customerAddress">
				<div class="row">
					<div class="col-lg-12 panel ">
						<h2>Address Information</h2>
					</div>
				</div>

				<div class="row form-group">
					<div class="col-md-4">
						<label class="col control-label text-center" for="city">City</label>
						<div class="input-group">
							<form:input path="city" id="city" placeholder=""
								class="form-control text-center" type="text" />
						</div>
					</div>

					<div class="col-md-4">
						<label class="col control-label text-center" for="state">State</label>
						<div class="input-group">

							<form:input path="state" id="state" placeholder=""
								class="form-control text-center" type="text" />
						</div>
					</div>

					<div class="col-md-4">
						<label class="col control-label text-center" for="district">District</label>
						<div class="input-group">

							<form:input path="district" id="district" placeholder=""
								class="form-control text-center" type="text" />
						</div>
					</div>
				</div>
				<hr>
				<div class="row form-group">
					<div class="col-lg">
						<label class="col control-label text-center" for="add_ln_1">Address
							Line 1</label>
						<form:input path="addressLine1" id="add_ln_1"
							placeholder="street address" class="form-control " type="text" />
					</div>
				</div>
				<div class="row form-group">
					<div class="col-lg">
						<label class="col control-label text-center" for="add_ln_2">Address
							Line 2 </label>
						<form:input path="addressLine2" id="add_ln_2"
							placeholder="street address" class="form-control" type="text" />
					</div>
				</div>
		</div>

		<hr>
		<div class="row form-group">
			<div class="col-lg-4">
				<label class="col control-label text-center" for="post_office">Post
					Office</label>

				<form:input path="postOffice" id="post_office" placeholder=""
					class="form-control text-center" type="text" />

			</div>
			<div class="col-lg-2">
				<label class="col control-label text-center" for="pin_code">Pin
					Code</label>
				<form:input path="pincode" id="pin_code" placeholder=""
					class="form-control text-center" type="text" />
			</div>
			<div class="col-lg-5">
				<label class="col control-label text-center" for="country">Country</label>
				<form:input path="country" id="country" placeholder=""
					class="form-control text-center" type="text" />
			</div>

		</div>
		<div class="form-group row">
			<div class="col-md-8 text-center">
				<input type="submit" id="save" value="Save Address" name="save"
					class="btn btn-large btn-success">

				<button class="btn btn-large btn-danger" type="reset">Cancel</button>
			</div>
		</div>
		</form:form>
	</div>
	</div>
</section>
