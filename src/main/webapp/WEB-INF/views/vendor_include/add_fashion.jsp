<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div class="content-wrapper">
	<div class="container-fluid">
		<ol class="breadcrumb">
			<li class="breadcrumb-item"><a href="#">Product</a></li>
			<li class="breadcrumb-item">Add Product</li>
			<li class="breadcrumb-item active">Add Fashion</li>
			<li class="breadcrumb-item"><a class="btn btn-primary right"
				href='<spring:url value="/vendor/product_add"/>'>Back</a></li>
		</ol>
		<div class="alert alert-primary text-center" role="alert">
			<h2>Add Fashion</h2>
		</div>

		<h3
			style="color: red; background-color: white; margin-right: 150px; margin-left: 150px;">${requestScope.message}</h3>
		<div class="container mt-3">
			<div class="container" style="margin-top: 50px;">
				<form:form method="post" enctype="multipart/form-data"
					modelAttribute="fashionItem">
					<fieldset>
						<div class="row">
							<label class="col-md-2 control-label" for="category">Product
								Category </label>
							<div class="col-lg-10">
								<div class="input-group">
									<input type="text" class="form-control" name="category"
										value="${sessionScope.subCategory}" readonly />
								</div>
							</div>
							<div class="col-lg-4 panel">
								<h2>Product Information</h2>
							</div>
							<div class="col-lg-4 panel panel-heading"
								style="display: none; color: red" id="contact_error"></div>
						</div>

						<div class="row form-group">
							<label class="col-lg-2 control-label" for="stock">Available
								Stock. </label>
							<div class="col-lg-2">
								<div class="input-group">
									<form:input id="stock" path="fashionInfo.stock"
										class="form-control" type="number" />
								</div>
							</div>
							<div class="row form-group">
								<label class="col-lg-2 control-label" for="brand">
									Brand. </label>
								<div class="col">
									<div class="input-group">
										<input type="text" class="form-control" name="brand"
										value="${sessionScope.subCategory}" readonly/>
									</div>
								</div>
							</div>
							
							
							<div class="row form-group">
								<label class="col-md-1 control-label " for="name"> Name.
								</label>
								<div class="col-md-3">
									<div class="input-group">
										<form:input id="name" path="fashionInfo.name"
											class="form-control" type="text" />
									</div>
								</div>

								<label class="col-md-1 control-label" for="title">
									Title. </label>
								<div class="col-md-3">
									<div class="input-group">
										<form:input id="title" path="fashionInfo.title" placeholder=""
											class="form-control" type="text" />
									</div>
								</div>
								<label class="col-md-1 control-label" for="price">
									Price. </label>
								<div class="col-md-2">
									<div class="input-group">
										<form:input id="price" path="fashionInfo.price" placeholder=""
											class="form-control" type="number" />
									</div>
								</div>
							</div>
						</div>

						<div class="row form-group">
							<label class="col-lg-2 control-label" for="description">Description.</label>
							<div class="col-lg-8">
								<div class="input-group">
									<form:textarea class="form-control" id="description.brief"
										path="description.brief" rows="5" />
								</div>
							</div>
						</div>

						<div class="row">
							<div class="col-md-12 panel">
								<h2>ManuFacture Information</h2>
							</div>
							<div class="row form-group">
								<label class="col-md-2 control-label" for="manufacture_date">
									Manufacture Date. </label>
								<div class="col-lg-4">
									<div class="input-group">
										<form:input id="manufacture_date"
											path="manufactureInformation.manufactureDate"
											class="form-control" type="date" />
									</div>
								</div>

								<label class="col-md-2 control-label" for="warrenty">
									Warrenty. </label>
								<div class="col-lg-4">
									<div class="input-group">
										<form:input id="warrenty"
											path="manufactureInformation.warrenty" class="form-control"
											type="number" />
									</div>
								</div>
								<div>&nbsp;</div>
								<label class="col-lg-4 control-label" for="man_info">
									Manufacture Info. </label>
								<div class="col-lg-8">
									<div class="input-group">
										<form:input id="man_info"
											path="manufactureInformation.manufactureInfo"
											class="form-control" type="text" />
									</div>
								</div>
							</div>
						</div>

						<div class="row">
							<div class="col-lg-12 panel ">
								<h2>Address Information</h2>
							</div>

							<div class="col-md-4 panel panel-heading"
								style="display: none; color: red" id="address_error"></div>
						</div>

						<div class="row form-group">
							<label class="col-md-2 control-label" for="city">City.</label>
							<div class="col-md-2">
								<div class="input-group">
									<form:input id="city" path="address.city" placeholder=""
										class="form-control" type="text" />
								</div>
							</div>

							<label class="col-md-1 control-label" for="state">State.</label>
							<div class="col-md-2">
								<div class="input-group">
									<form:input id="state" path="address.state" placeholder=""
										class="form-control" type="text" />
								</div>
							</div>

							<label class="col-md-1 control-label" for="district">District.</label>
							<div class="col-md-2">
								<div class="input-group">
									<i class="glyphicon glyphicon-list"></i>
									<form:input id="district" path="address.district"
										placeholder="" class="form-control" type="text" />
								</div>
							</div>
						</div>

						<div class="row form-group">
							<label class="col-lg-2 control-label" for="add_ln_1">Address
								Line 1.</label>
							<div class="col-lg">
								<form:input id="add_ln_1" path="address.addressLine1"
									placeholder="street address" class="form-control" type="text" />
							</div>

							<label class="col-lg-2 control-label" for="add_ln_2">Address
								Line 2. </label>
							<div class="col-lg ">
								<div class="input-group">
									<form:input id="add_ln_2" path="address.addressLine2"
										placeholder="street address" class="form-control" type="text" />
								</div>
							</div>
						</div>
						<div class="row form-group">
							<label class="col-lg-2 control-label" for="post_office">Post
								Office.</label>
							<div class="col-lg-6">
								<div class="input-group">
									<form:input id="post_office" path="address.postOffice"
										placeholder="" class="form-control" type="text" />
								</div>
							</div>
						</div>
						<div class="row form-group">
							<label class="col-lg-2 control-label" for="pin_code">Pin
								Code.</label>
							<div class="col-lg-2">
								<form:input id="pin_code" path="address.pincode" placeholder=""
									class="form-control" type="text" />
							</div>
							<label class="col-lg-1 control-label" for="country">Country</label>
							<div class="col-lg-5">
								<div class="input-group">
									<form:input id="country" path="address.country" placeholder=""
										class="form-control" type="text" />
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-lg-12 panel ">
								<h2>Additional Details</h2>
							</div>
						</div>

						<div class="row form-group">
							<label class="col-md-2 control-label" for="model_no">Model
								Name.</label>
							<div class="col-md-2">
								<div class="input-group">
									<form:input id="model_no"
										path="fashionInfo.fashionDetails.modelName" placeholder=""
										class="form-control" type="text" />
								</div>
							</div>

							<label class="col-md-1 control-label" for="sleeve">Sleeve.</label>
							<div class="col-md-2">
								<div class="input-group">
									<form:select path="fashionInfo.fashionDetails.sleeve"
										id="sleeve" class="form-control">
										<option value=none>---select---</option>
										<option value="full">Full Sleeve</option>
										<option value="Half">Half Sleeve</option>
										<option value="no">Sleeve Less</option>
										<option value="3/4">3/4<sub>th</sub>Sleeve
										</option>
									</form:select>

								</div>
							</div>

							<label class="col-md-1 control-label" for="type">Type.</label>
							<div class="col-md-2">
								<div class="input-group">
									<form:select path="fashionInfo.fashionDetails.type" id="type"
										class="form-control">
										<option value=none>---select---</option>
										<option value="rounded">Rounded</option>
										<option value="vshaped">V shaped</option>
										<option value="square">Square</option>
										<option value="collar Formal">{Collar Formal}</option>
										<option value="collar Casual">{Collar Casual}</option>
									</form:select>
								</div>
							</div>
						</div>

						<div class="row form-group">
							<label class="col-lg-2 control-label" for="material">Fabric/Material.</label>
							<div class="col-lg">
								<form:input id="material"
									path="fashionInfo.fashionDetails.material"
									placeholder="Pure Cotton" class="form-control" type="text" />
							</div>

							<label class="col-lg-2 control-label" for="idealFor">Ideal
								For. </label>
							<div class="col-lg ">
								<div class="input-group">
									<form:select path="fashionInfo.fashionDetails.idealFor"
										id="idealFor" class="form-control">
										<option value="Men">Men</option>
										<option value="women">Women</option>
										<option value="chilldren">Children</option>
									</form:select>
								</div>
							</div>
						</div>
						<div class="row form-group">
							<label class="col-lg-2 control-label" for="color">Color.</label>
							<div class="col-lg-2">
								<div class="input-group">
									<form:input id="color" path="fashionInfo.fashionDetails.color"
										class="form-control" type="color" />
								</div>
							</div>
							<label class="col-lg-2 control-label" for="size">Size.</label>
							<div class="col-lg-2">
								<div class="input-group">
									<form:select path="fashionInfo.fashionDetails.size" id="size"
										class="form-control">
										<option value="small">Small</option>
										<option value="large">Medium</option>
										<option value="Large">Large</option>
										<option value="Extra Large">Extra Large</option>
										<option value="6">6</option>
										<option value="7">7</option>
										<option value="7">7</option>
										<option value="8">8</option>
										<option value="9">9</option>
										<option value="10">10</option>
									</form:select>
								</div>
							</div>
						</div>
						<div class="row form-group">
							<label class="col-lg-2 control-label" for="pattern">Pattern</label>
							<div class="col-lg-2">
								<form:input id="pattern"
									path="fashionInfo.fashionDetails.pattern" placeholder=""
									class="form-control" type="text" />
							</div>
						</div>
						<div class="row form-group">
							<label class="col-lg-2 control-label" for="occasion">Occasion.</label>
							<div class="col-lg-2">
								<form:input id="occasion"
									path="fashionInfo.fashionDetails.occasion" placeholder="Casual"
									class="form-control" type="Text" />
							</div>
							<label class="col-lg-2 control-label" for="fashionType">Fashion
								Type.</label>
							<div class="col-lg-2">
								<form:input id="fashionType"
									path="fashionInfo.fashionDetails.fashionType"
									placeholder="jacket/jeans" class="form-control" type="Text" />
							</div>
						<div class="row form-group">
						<label class="col-lg-2 control-label" for="image">Product Image.</label>
							<div class="col-lg-4">
								<input type="file" id="myFile" name="image">
							</div>
						</div>
						</div>

						<div class="form-group row">
							<div class="col-md-8 text-center">
								<input type="submit" id="save" value="Save" name="save"
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
