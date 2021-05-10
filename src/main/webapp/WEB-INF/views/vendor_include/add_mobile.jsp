
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div class="content-wrapper">
	<div class="container-fluid">
		<ol class="breadcrumb">
			<li class="breadcrumb-item"><a href="#">Product</a></li>
			<li class="breadcrumb-item">Add Product</li>
			<li class="breadcrumb-item active">Add Mobile</li>
			<li class="breadcrumb-item"><a class="btn btn-primary right"
				href='<spring:url value="/vendor/product_add"/>'>Back</a></li>
		</ol>
		<div class="alert alert-primary text-center" role="alert">
			<h2>Add Mobile</h2>
		</div>

		<h3
			style="color: red; background-color: white; margin-right: 150px; margin-left: 150px;">${requestScope.message}</h3>
		<div class="container mt-3">
			<div class="container" style="margin-top: 50px;">
				<form method="post" enctype="multipart/form-data">
					<fieldset>
						<div class="row">
							<div class="col-lg-4">
								<label class="col control-label text-center" for="category">Product Category</label>
								<div class="input-group">
									<input type="text" class="form-control" name="category"
										value="${sessionScope.subCategory}" readonly="true"/>
								</div>
							</div>
							</div>
							
							<div class="col-lg-4 panel">
								<h2>Product Information</h2>
							</div>
						</div>


						<div class="row form-group">
							<div class="col-lg-4">
							<label class="col control-label text-center" for="stock">Available
								Stock</label>
								<div class="input-group">
									<input id="stock" name="stock" class="form-control text-center"
										type="number" />
								</div>
							</div>
							
								<div class="col-lg-4">
								<label class="col control-label text-center" for="brand">
									Brand</label>
									<div class="input-group">
										<input type="text" class="form-control text-center" id="brand"
											name="brand" value="${sessionScope.subCategory}"
											readonly="true" />
									</div>
								</div>
								<div class="col-md-3">
								<label class="col control-label text-center" for="name">
									Name </label>
									<div class="input-group">
										<input id="name" name="name" placeholder=""
											class="form-control text-center" type="text" />
									</div>
								</div>
							</div>
								<hr>
								<div class="row form-group">
								<div class="col-lg-6">
								<label class="col control-label text-center" for="title">
									Title </label>
									<div class="input-group">
										<input id="title" name="title" placeholder=""
											class="form-control text-center" type="text" />
									</div>
								</div>
								
								<div class="col-md-4">
								<label class="col control-label text-center" for="price"> Price </label>
									<div class="input-group">
										<input id="price" name="price" placeholder=""
											class="form-control" type="number" />
									</div>
								</div>
							</div>
						<hr>

						<div class="row form-group">
							<div class="col-lg-8">
							<label class="col control-label text-center" for="description">Description</label>
								<div class="input-group">
									<textarea class="form-control" id="description.brief"
										name="description" rows="5"></textarea>
								</div>
							</div>
						</div>
<hr>
						<div class="row">
							<div class="col-md-12 panel">
								<h2>Manufacture Information</h2>
							</div>
							</div>
							<div class="row form-group">
								<div class="col-lg-4">
								<label class="col control-label text-center"
									for="manufacture_date"> Manufacture Date </label>
									<div class="input-group">
										<input id="manufacture_date" name="manufactureDate"
											class="form-control text-center" type="date" />
									</div>
								</div>

								
								<div class="col-lg-4">
								<label class="col control-label text-center" for="warrenty">
									Warrenty</label>
									<div class="input-group">
										<input id="warrenty" name="warrenty" placeholder=""
											class="form-control text-center" type="number" />
									</div>
								</div>
							
								<div class="col-lg-4">
									<label class="col control-label text-center" for="man_info">
									Manufacture Information </label>
									<div class="input-group">
										<input id="man_info" name="manufactureInfo" placeholder=""
											class="form-control text-center" type="text" />
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
									<input id="city" name="manufactureLocation.city" placeholder=""
										class="form-control text-center" type="text" />
								</div>
							</div>

							
							<div class="col-md-4">
							<label class="col control-label text-center" for="state">State</label>
								<div class="input-group">
									<input id="state" name="manufactureLocation.state"
										placeholder="" class="form-control text-center" type="text" />
								</div>
							</div>

							
							<div class="col-md-4">
							<label class="col control-label text-center" for="district">District</label>
								<div class="input-group">
									<i class="glyphicon glyphicon-list"></i> <input id="district"
										name="manufactureLocation.district" placeholder=""
										class="form-control text-center" type="text" />
								</div>
							</div>
						</div>
<hr>
						<div class="row form-group">
							
							<div class="col-lg">
							<label class="col control-label text-center" for="add_ln_1">Address
								Line 1</label>
								<input id="add_ln_1" name="manufactureLocation.addressLine1"
									placeholder="street address" class="form-control" type="text" />
							</div>

							
							<div class="col-lg ">
							<label class="col control-label text-center" for="add_ln_2">Address
								Line 2 </label>
								<div class="input-group">
									<input id="add_ln_2" name="manufactureLocation.addressLine2"
										placeholder="street address" class="form-control" type="text" />
								</div>
							</div>
						</div>
						<hr>
						<div class="row form-group">
							
							<div class="col-lg-6">
							<label class="col control-label text-center" for="post_office">Post
								Office</label>
								<div class="input-group">
									<input id="post_office" name="manufactureLocation.postOffice"
										placeholder="" class="form-control text-center" type="text" />
								</div>
							</div>
						
							
							<div class="col-lg-2">
							<label class="col control-label text-center" for="pin_code">Pin
								Code</label>
								<input id="pin_code" name="pincode" placeholder=""
									class="form-control text-center" type="text" />
							</div>

									<div class="col-lg-3">
									<label class="col control-label text-center" for="country">Country</label>
					
								<div class="input-group">
									<input id="country" name="manufactureLocation.country"
										placeholder="" class="form-control text-center" type="text" />
								</div>
							</div>
						</div>
						<hr>
						<div class="row">
							<div class="col-lg-12 panel ">
								<h2>Techinical Details</h2>
							</div>
						</div>

						<div class="row form-group">
							<div class="col-md-4">
							<label class="col control-label text-center" for="model_no">Model
								Number</label>
								<div class="input-group">
									<input id="model_no" name="modelNo" placeholder=""
										class="form-control" type="text" />
								</div>
							</div>
							
							<div class="col-md-4">
								<label class="col control-label text-center" for="os">Operating
									System</label>
								<div class="input-group">
									<select name="os" id="os" class="form-control">
										<option value="Android">Android</option>
										<option value="Mac os">Mac Os</option>
									</select>
								</div>
							</div>

							<div class="col-md-4">
								<label class="col control-label text-center" for="ram">Ram</label>

								<div class="input-group">
									<select name="ram" id="ram" class="form-control">
										<option value="2">2GB</option>
										<option value="4">4GB</option>
										<option value="6">6GB</option>
										<option value="8">8GB</option>
									</select>
								</div>
							</div>
						</div>
<hr>
						<div class="row form-group">
							<div class="col-lg-3">
								<label class="col control-label text-center" for="dimension">Dimension</label>

								<input id="dimension" name="dimensions" placeholder="dimension"
									class="form-control" type="text" />
							</div>

							<div class="col-lg-3">
								<label class="col control-label text-center" for="battery">Battery
									Capacity </label>

								<div class="input-group">
									<input id="battery" name="batteryCapacity"
										placeholder="battery" class="form-control" type="number" />
								</div>
							</div>
					
							<div class="col-lg-3">
								<label class="col control-label text-center" for="color">Color</label>
								<div class="input-group">
									<input id="color" name="color" class="form-control"
										type="color" />
								</div>
							</div>
							<div class="col-lg-3">
								<label class="col control-label text-center" for="connectivity">Connectivity</label>

								<div class="input-group">
									<select name="connectivity" id="connectivity"
										class="form-control">
										<option value="2G">2G</option>
										<option value="3G">3G</option>
										<option value="4G">4G</option>
										<option value="5G">5G</option>
									</select>
								</div>
							</div>
						</div>
						<hr>
						<div class="row form-group">
							<div class="col-lg-2">
								<label class="col control-label text-center" for="display">Display</label>

								<input id="display" name="display" placeholder=""
									class="form-control" type="text" />
							</div>

							<div class="col-lg-6">
								<label class="col control-label text-center" for="camera">Camera</label>

								<div class="input-group">
									<input id="camera" name="camera" placeholder=""
										class="form-control" type="text" />
								</div>
							</div>

							<div class="col-lg-2">
								<label class="col control-label text-center" for="weight">Weight</label>

								<input id="weight" name="weight" placeholder=""
									class="form-control" type="number" />
							</div>

							<div class="col-lg-2">
								<label class="col control-label text-center" for="multimedia">Multi
									Media</label>

								<div class="input-group">
									<select name="multimedia" class="form-control" id="multimedia">
										<option value="no">No</option>
										<option value="yes">Yes</option>
									</select>
								</div>
							</div>
						</div>
						<hr>
						<div class="row form-group">
							<div class="col-lg-4">
								<label class="col control-label text-center"
									for="operatingFrequency">Operating Frequency</label> <input
									id="operatingFrequency" name="operatingFrequency"
									placeholder="" class="form-control" type="text" />
							</div>

							<div class="col-lg-4">
								<label class="col control-label text-center" for="resolution">Resolution</label>

								<div class="input-group">
									<input id="resolution" name="resolution" placeholder=""
										class="form-control" type="text" />
								</div>
							</div>
						
<hr>
							<div class="col-lg-4">
								<label class="col control-label text-center" for="image">Product
									Image</label> <input type="file" id="myFile" name="image">
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
				</form>
			</div>


		</div>
	</div>
</div>
