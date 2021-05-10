<section style="background-color: white;">
	<div class="container-fluid">
		<div class="row">
			
			<div class="col-sm-5">
				<div class="thumbnail">
					<img  src="data:image/jpeg;base64,${fashion.imgUtility}"
						class="img-responsive" alt="" height=450px width=350px>

					<div class="caption">
						<div class="row buttons">

							<a class="btn  col-sm-4 col-sm-offset-2 btn-lg"
								href="<spring:url value="/customer/addtocart?pid=${fashion.id}"/>"
								style="background-color: #ff9f00; color: #fff; font-size: 1em;">
								<span class="glyphicon glyphicon-shopping-cart"></span>&nbsp;ADD
								TO CART
							</a>

							
							<a class="btn col-sm-4 col-sm-offset-1 btn-lg"
								href="<spring:url value="/customer/addtocart?pid=${fashion.id}"/>"
								style="background-color: #fb641b; color: #fff; font-size: 1em;">
								<i class="fa fa-bolt" style="font-size: 1.2em;"></i> BUY NOW
							</a>
						</div>

					</div>
				</div>

			</div>


			<div class="col-sm-7 desc">

				<div>

					<ol class="breadcrumb col-sm-12"
						style="background-color: transparent;">
						<li><a href="#">Home</a></li>
						<li><a href="">Fashions</a></li>
						<li><a href="">${fashion.brand}</a></li>
						<li class="active">${fashion.brand}</li>
					</ol>

					<h4>${fashion.title}</h4>

					<div class="row">
						<div class="col-sm-2">
							<span class="label label-success">4.6 <span
								class="glyphicon glyphicon-star"></span></span>
						</div>

						<div class="col-sm-5">
							<strong>${fashion.misc.rating}</strong>
						</div>

					</div>

					<div>
						<h3>Rs ${fashion.price}</h3>
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
								Brand Warranty of ${fashion.manufactureInformation.warrenty} month(s) <!-- <a href="">Know More</a> -->
							</h5>
						</div>
					</div>
					<br>

				
					<br>

					

					<br>
					<br>

					

				</div>
				<br>
				<br>

				<div class="container col-xs-12" style="margin-top: 50px;">
					<div class="panel panel-default">
						<div class="panel-body">
							<div class="col-sm-12">
								<h3>PRODUCT DESCRIPTION</h3>
								<p>${fashion.description.brief}</p>

							</div>

						</div>
						<hr>
						<div class="panel-body">
							<div class="col-sm-12">

								

					<!-- Specifications
			String color, String size, String type, String sleeve, String idealFor,
			String pattern, String modelName, String material, String occasion				 -->

					<div class="panel panel-default" id="specifications">
						<div class="panel-heading" style="background-color: #fff;">
							<h3>Fashion Details</h3>
						</div>

						<div class="panel-body">

							<h4>General</h4>

							<table class="table table-default">
								<tbody>
									<tr>
										<td class="col-sm-4">Size</td>
										<td class="col-sm-8">${fashion.fashionDetails.size}</td>
									</tr>
									<tr>
										<td class="col-sm-4">Color</td>
										<td class="col-sm-8">${mobile.fashionDetails.color}</td>
									</tr>
									<tr>
										<td class="col-sm-4">Type</td>
										<td class="col-sm-8">${fashion.fashionDetails.type}</td>
									</tr>
									
									<tr>
										<td class="col-sm-4">Sleeve</td>
										<td class="col-sm-8">${fashion.fashionDetails.sleeve}</td>
									</tr>
									
									<tr>
										<td class="col-sm-4">Ideal For</td>
										<td class="col-sm-8">${fashion.fashionDetails.idealFor}</td>
									</tr>
									<tr>
										<td class="col-sm-4">Pattern</td>
										<td class="col-sm-8">${fashion.fashionDetails.pattern}</td>
									</tr>
									<tr>
										<td class="col-sm-4">Model Name</td>
										<td class="col-sm-8">${fashion.fashionDetails.modelName}</td>
									</tr>
									<tr>
										<td class="col-sm-4">Material</td>
										<td class="col-sm-8">${fashion.fashionDetails.material}</td>
									</tr>
									<tr>
										<td class="col-sm-4">Occasion</td>
										<td class="col-sm-8">${fashion.fashionDetails.occasion}</td>
									</tr>
									
								</tbody>

							</table>

						</div>

						<div class="panel-footer">
					
						</div>
					</div>

				</div>

			</div>
		</div>
</div>
</div>
</div>
</div>
		<br>
		<br>
</section>
