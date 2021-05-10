<section style="background-color: white;">
	<div class="container-fluid">
		<div class="row">

			<div class="col-sm-5">
				<div class="thumbnail">
					<img src="data:image/jpeg;base64,${mobile.imgUtility}"
						class="img-responsive" alt="" height=450px width=350px>

					<div class="caption">
						<div class="row buttons">

							<a class="btn  col-sm-4 col-sm-offset-2 btn-lg"
								href="<spring:url value="/customer/addtocart?pid=${mobile.id}"/>"
								style="background-color: #ff9f00; color: #fff; font-size: 1em;">
								<span class="glyphicon glyphicon-shopping-cart"></span>&nbsp;ADD
								TO CART
							</a> <a class="btn col-sm-4 col-sm-offset-1 btn-lg"
								href="<spring:url value="/customer/addtocart?pid=${mobile.id}"/>"
								style="background-color: #fb641b; color: #fff; font-size: 1em;">
								<i class="fa fa-bolt" style="font-size: 1.2em;"></i> BUY NOW
							</a>
						</div>

					</div>
				</div>
				<div class="row">
					<c:forEach items="${mobile.images}" var="image">
						<div class="col-lg-3">
							<img style="border: 2px solid;padding: 10px" src="data:image/jpeg;base64,${image.imgUtility}"
								class="img-responsive image-size-fixed" alt="" />
						</div>
					</c:forEach>
				</div>
			</div>


			<div class="col-sm-7 desc">

				<div>

					<ol class="breadcrumb col-sm-12"
						style="background-color: transparent;">
						<li><a href="#">Home</a></li>
						<li><a href="">Mobiles</a></li>
						<li><a href="">${mobile.brand}</a></li>
						<li class="active">${mobile.brand}</li>
					</ol>

					<h4>${mobile.title}</h4>

					<div class="row">
						<div class="col-sm-2">
							<span class="label label-success">4.6 <span
								class="glyphicon glyphicon-star"></span></span>
						</div>

						<div class="col-sm-5">
							<strong>${mobile.misc.rating}</strong>
						</div>

					</div>

					<div>
						<spam
							style="color:white; background-color: blue; padding:5px; margin:40px;font-size:30px;">Rs
						${mobile.price}</spam>
					</div>

					<!-- <div>

						<h5>
							<span class="glyphicon glyphicon-calendar"></span> EMIs from <strong>Rs
								3,070/month </strong><a href="">View Plans <i
								class="fa fa-chevron-right"></i></a>
						</h5>

						<h5>
							<span class="glyphicon glyphicon-tag"></span><strong>
								Bank Offer</strong> 5% Instant Discount on Visa Cards for First 3 Online
							Payments. <a href="">T&C</a>
						</h5>

						<h5>
							<span class="glyphicon glyphicon-tag"></span><strong>
								Bank Offer</strong> Extra 5% off* with Axis Bank Buzz Credit Card. <a
								href="">T&C</a>
						</h5>

					</div> -->

					<br>
					<div class="row">
						<!-- <div class="col-sm-3">
							<a class="btn btn-default btn-block"><i class="fa fa-apple"
								style="font-size: 25px;"></i></a>
						</div> -->
						<div class="col-sm-9">

							<h5>
								Brand Warranty of ${mobile.manufactureInformation.warrenty}
								month(s)
								<!-- <a href="">Know More</a> -->
							</h5>
						</div>
					</div>
					<br> <br> <br> <br>



				</div>
				<br> <br>

				<div class="container col-xs-12" style="margin-top: 50px;">
					<div class="panel panel-default">
						<div class="panel-body">
							<div class="col-sm-12">
								<h3>PRODUCT DESCRIPTION</h3>
								<p>${mobile.description.brief}</p>

							</div>

						</div>
						<hr>
						<div class="panel-body">
							<div class="col-sm-12">



								<!-- Specifications -->

								<div class="panel panel-default" id="specifications">
									<div class="panel-heading" style="background-color: #fff;">
										<h3>Technical Details</h3>
									</div>

									<div class="panel-body">

										<h4>General</h4>

										<table class="table table-default">
											<tbody>
												<!-- <tr>
										<td class="col-sm-4">In The Box</td>
										<td class="col-sm-8">Handset, EarPods with Lightning
											Connector, Lightning to 3.5 mm Headphone Jack Adapter,
											Lightning to USB Cable, USB Power Adapter, Documentation</td>
									</tr> -->

												<tr>
													<td class="col-sm-4">Model Number</td>
													<td class="col-sm-8">${mobile.technicalDetails.modelNo}</td>
												</tr>
												<tr>
													<td class="col-sm-4">Color</td>
													<td class="col-sm-8">
													<span style="background-color:${mobile.technicalDetails.color};">__________</span>
													</td>
												</tr>
												<tr>
													<td class="col-sm-4">Operating System</td>
													<td class="col-sm-8">${mobile.technicalDetails.os}</td>
												</tr>

												<tr>
													<td class="col-sm-4">Display</td>
													<td class="col-sm-8">${mobile.technicalDetails.display}</td>
												</tr>

												<tr>
													<td class="col-sm-4">Model Dimensions</td>
													<td class="col-sm-8">${mobile.technicalDetails.dimensions}</td>
												</tr>
												<tr>
													<td class="col-sm-4">Battery Dimension</td>
													<td class="col-sm-8">${mobile.technicalDetails.batteryCapacity}</td>
												</tr>
												<tr>
													<td class="col-sm-4">Connectivity</td>
													<td class="col-sm-8">${mobile.technicalDetails.connectivity}</td>
												</tr>
												<tr>
													<td class="col-sm-4">Camera</td>
													<td class="col-sm-8">${mobile.technicalDetails.camera}</td>
												</tr>
												<tr>
													<td class="col-sm-4">Resolution</td>
													<td class="col-sm-8">${mobile.technicalDetails.resolution}</td>
												</tr>
												<tr>
													<td class="col-sm-4">Item Weight</td>
													<td class="col-sm-8">${mobile.technicalDetails.weight}
														gram</td>
												</tr>
												<tr>
													<td class="col-sm-4">Multimedia Support</td>
													<td class="col-sm-8">${mobile.technicalDetails.multimedia}</td>
												</tr>
												<tr>
													<td class="col-sm-4">Operating Frequency</td>
													<td class="col-sm-8">${mobile.technicalDetails.operatingFrequency}</td>
												</tr>
												<tr>
													<td class="col-sm-4">Brand warrenty</td>
													<td class="col-sm-8">${mobile.manufactureInformation.warrenty}
														month(s)</td>
												</tr>
											</tbody>

										</table>

									</div>

									<div class="panel-footer"></div>
								</div>

							</div>

						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<br> <br>
</section>
