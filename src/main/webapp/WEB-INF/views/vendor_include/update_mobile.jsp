
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div class="content-wrapper">
	<div class="container-fluid">
		<ol class="breadcrumb">
			<li class="breadcrumb-item"><a href="#">Product</a></li>
			<li class="breadcrumb-item active">Update Product</li>
			<li class="breadcrumb-item"><a class="btn btn-primary right"
				href='<spring:url value="/vendor/product_list"/>'>Back</a></li>
		</ol>

		<div class="alert alert-primary text-center" role="alert">
			<h2>Update Mobile Details</h2>
		</div>

		<h3 style="color: red; background-color: white; margin-right: 150px; margin-left: 150px;">${requestScope.message}</h3>
		<form method="post">
			<div class="container mt-3">
				<div class="container" style="margin-top: 50px;">
							 <input name="pid" id="pid" class="form-control" type="hidden" value="${sessionScope.mobileDetails.id}" />
							 <input name="did" id="did" class="form-control" type="hidden" value="${sessionScope.descriptionDetails.id}" />
							  <input name="tid" id="tid" class="form-control" type="hidden" value="${sessionScope.technicalDetails.id}" />
							   <input name="mid" id="mid" class="form-control" type="hidden" value="${sessionScope.manufactureInformation.id}" />
							   <input name="aid" id="aid" class="form-control" type="hidden" value="${sessionScope.mfgAddress.id}" />
							<div class="col-lg-4 panel">
								<h2>Product Information</h2>
							</div>
							<div class="col-lg-4 panel panel-heading"
								style="display: none; color: red" id="contact_error"></div>
						</div>
					
					<div class="row form-group">
						
						<div class="col-lg-4">
						<label class="col control-label text-center" for="stock">Available Stock </label>
							<div class="input-group">
								<input name="stock" id="stock" class="form-control text-center" type="text"
									value="${sessionScope.mobileDetails.stock}" />
							</div>
						</div>
						
						<div class="col-lg-4">
						<label class="col control-label text-center" for="brand"> Brand.</label>
							<div class="input-group">
								<input name="brand" type="text" class="form-control text-center" id="brand"
										value="${sessionScope.mobileDetails.brand}" readonly="true" />
							</div>
						</div>
						
						<div class="col-lg-4">
						<label class="col control-label text-center" for="name"> Name.</label>
							<div class="input-group">
								<input name="name" id="name" class="form-control text-center" type="text"
										value="${sessionScope.mobileDetails.name}" readonly="true" />
							</div>
						</div>
						</div>
						<hr>
				<div class="row form-group">
							<div class="col-lg-4">
							<label class="col control-label text-center" for="title"> Title.</label>
								<div class="input-group">
									<input name="title" id="title" class="form-control text-center" type="text"
										value="${sessionScope.mobileDetails.title}" readonly="true" />
								</div>
							</div>
							
							<div class="col-lg-2">
							<label class="col control-label text-center" for="price"> Price.</label>
								<div class="input-group">
									<input name="price" id="price" class="form-control text-center"
										type="number" value="${sessionScope.mobileDetails.price}" readonly="true" />
								</div>
							</div>
							<div class="col-lg-2">
							<label class="col control-label text-center" for="price"> Status</label>
								<div class="input-group">
									<input name="status" id="status" class="form-control text-center" value="${sessionScope.mobileDetails.status}"
										readonly="true" />
								</div>
							</div>

							
							<div class="col-lg-2">
							<label class="col control-label text-center" for="price"> Offer</label>
								<div class="input-group">
									<input name="offer" id="offer" class="form-control text-center" value="${sessionScope.mobileDetails.offer}" />
								</div>
							</div>

							
							<div class="col-md-2">
							<label class="col control-label text-center" for="dateAdded">DateAdded </label>
								<div class="input-group">
									<input type="text" name="dateAdded" id="dateAdded"
										class="form-control text-center" value="${sessionScope.mobileDetails.dateAdded}" readonly="true" />
								</div>
							</div>
						</div>
						<hr>
				<div class="row form-group">
					<label class="col-lg-2 control-label" for="description">Description.</label>
					<div class="col-lg-8">
						<div class="input-group">
							<textarea class="form-control" id="brief" name="brief" rows="5">"${sessionScope.descriptionDetails.brief}"</textarea>
						</div>
					</div>
				</div>
				<hr>
				<div class="row">
					<div class="col-md-12 panel">
						<h2>ManuFacture Information</h2>
					</div>
					
					
					<div class="row form-group">
						
						<div class="col-lg-3">
						<label class="col control-label text-center" for="manufacture_date">Manufacture Date. </label>
							<div class="input-group">
								<input name="manufactureDate" type="text" id="manufacture_date"
									class="form-control text-center" value="${sessionScope.manufactureInformation.manufactureDate}" readonly="true" />
							</div>
						</div>

						<div class="col-lg-2">
						<label class="col control-label text-center" for="warrenty">Warrenty. </label>
							<div class="input-group">
								<input name="warrenty" id="warrenty" class="form-control text-center"
									type="text" value="${sessionScope.manufactureInformation.warrenty}" />
							</div>
						</div>
		
						<div class="col-lg-7">
							<label class="col control-label text-center" for="man_info">Manufacture Info. </label>
							<div class="input-group">
								<input name="manufactureInfo" id="man_info" class="form-control text-center"
									type="text" value="${sessionScope.manufactureInformation.manufactureInfo} " />
							</div>
						</div>
					</div>
				</div>
		<hr>
				<div class="row">
					<div class="col-lg-12 panel ">
						<h2>Address Information</h2>
					</div>

				<div class="row form-group">
					<div class="col-lg-2">
					<label class="col control-label text-center" for="city">City.</label>
						<div class="input-group">
							<input name="city" id="city" class="form-control text-center" type="text"
								value="${sessionScope.mfgAddress.city}" />
						</div>
					</div>

					<div class="col-lg-33">
					<label class="col control-label text-center" for="state">State.</label>
						<div class="input-group">
							<input name="state" id="state" class="form-control text-center" type="text"
								value="${sessionScope.mfgAddress.state}" />
						</div>
					</div>

					<div class="col-lg-2">
					<label class="col control-label text-center" for="district">District.</label>
						<div class="input-group">
							 <input name="district"
								id="district" class="form-control text-center" type="text" value="${sessionScope.mfgAddress.district}" />
						</div>
					</div>
					
					<div class="col-lg-2">
					<label class="col control-label text-center" for="pin_code">Pin Code.</label>
						<div class="input-group">
							<input name="pincode" id="pin_code" class="form-control text-center"
								type="text" value="${sessionScope.mfgAddress.pincode}" />
						</div>
					</div>
					
					<div class="col-lg-3">
				  	<label class="col control-label text-center" for="country">Country</label>
						<div class="input-group">
							<input name="country" id="country" class="form-control text-center"
								type="text" value="${sessionScope.mfgAddress.country}" />
						</div>
					</div>
				</div>
				</div>
		<hr>
	
					<div class="row form-group">
						<label class="control-label" for="add_ln_1">Street Address</label>
							<div class="col-lg-5">
								<input name="addressLine1" id="add_ln_1" class="form-control"
										type="text" value="${sessionScope.mfgAddress.addressLine1}" />
							</div>
						<label class="control-label" for="add_ln_2">Landmark </label>
							<div class="col-lg-4 ">
								<input name="addressLine2" id="add_ln_2" class="form-control"
									type="text" value="${sessionScope.mfgAddress.addressLine2}" />
					</div>
				</div>
				<div class="row form-group">
					<label class="control-label" for="post_office">Post Office</label>
					<div class="col-lg-8">
						<div class="input-group">
							<input id="post_office" name="postOffice" class="form-control"
								type="text" value="${sessionScope.mfgAddress.postOffice}" />
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
					
					<div class="col-lg-3">
						<label class="col control-label text-center" for="model_no">Model No</label>
							<div class="input-group">
								<input name="modelNo" id="model_no" class="form-control text-center"
									type="text" value="${sessionScope.technicalDetails.modelNo}" />
							</div>
					</div>

					
					<div class="col-lg-3">
						<label class="col control-label text-center" for="os">Operating System</label>
							<div class="input-group">
								<input name="os" id="os" class="form-control text-center" type="text"
									value="${sessionScope.technicalDetails.os}" />
							</div>
					</div>

					
					<div class="col-lg-2">
						<label class="col control-label text-center" for="ram">Ram</label>
							<div class="input-group">
								<input name="ram" id="ram" class="form-control text-center" type="text"
									value="${sessionScope.technicalDetails.ram}" />
							</div>
					</div>

					<div class="col-lg-4">		
						<label class="col control-label text-center" for="dimension">Dimension.</label>
						<div class="input-group">
							<input name="dimensions" id="dimension" class="form-control text-center"
								type="text" value="${sessionScope.technicalDetails.dimensions}" />
						</div>
					</div>
				</div>	
		<hr>
		
				<div class="row form-group">
						<div class="col-lg-3">
							<label class="col control-label text-center" for="battery">Battery Capacity</label>
							<div class="input-group">
								<input name="batteryCapacity" id="battery" class="form-control text-center"
									type="number" value="${sessionScope.technicalDetails.batteryCapacity}" />
							</div>
						</div>
						
						<div class="col-lg-2">
							<label class="col control-label text-center" for="color">Color.</label>
						<div class="input-group">
							<input name="color" id="color" class="form-control text-center" type="color"
								value="${sessionScope.technicalDetails.color}" />
						</div>
					</div>
					
					<div class="col-lg-2">
						<label class="col control-label text-center" for="connectivity">Connectivity.</label>
						<div class="input-group">
							<input name="connectivity" id="connectivity" class="form-control text-center"
								type="text" value="${sessionScope.technicalDetails.connectivity}" />
						</div>
					</div>
						
					<div class="col-lg-3">
						<label class="col control-label text-center" for="display">Display</label>
						<div class="input-group">
							<input name="display" id="display" class="form-control text-center"
								type="text" value="${sessionScope.technicalDetails.display}" />
						</div>
					</div>
					
					<div class="col-lg-2">
						<label class="col control-label text-center" for="weight">Weight.</label>
						<div class="input-group">
							<input name="weight" id="weight" class="form-control text-center"
								type="text" value="${sessionScope.technicalDetails.weight}" />
						</div>
					</div>
					</div>
					<hr>
				<div class="row form-group">
					<div class="col-lg-4">
						<label class="col control-label text-center" for="camera">Camera</label>
							<div class="input-group">
							<input name="camera" id="camera" class="form-control text-center" type="text"
								value="${sessionScope.technicalDetails.camera}" />
						</div>
					</div>
					
					<div class="col-lg-2">
						<label class="col control-label text-center" for="multimedia">Multi Media</label>
							<div class="input-group">
								<input name="multimedia" id="multimedia" class="form-control text-center"
									type="text" value="${sessionScope.technicalDetails.multimedia}" />
							</div>
					</div>
					
					<div class="col-lg-3">
						<label class="col control-label text-center" for="operatingFrequency">Operating Frequency</label>
						<div class="input-group">
							<input name="operatingFrequency" id="operatingFrequency text-center"
								class="form-control" type="text" value="${sessionScope.technicalDetails.operatingFrequency}" />
						</div>
					</div>
					
					<div class="col-lg-3">
						<label class="col control-labelt text-center" for="resolution">Resolution</label>
						<div class="input-group">
							<input name="resolution" id="resolution" class="form-control text-center"
								type="text" value="${sessionScope.technicalDetails.resolution}" />
						</div>
					</div>
					</div>
				<hr>
				
				<div class="form-group row">
					<div class="col-lg-8 text-center">
						<input type="submit" id="update" value="Update" name="update"
							class="btn btn-large btn-success">

						<button class="btn btn-large btn-danger" type="reset">Cancel</button>
					</div>
				</div>
				</div>
				
		</form>
		</div>	
	</div>

