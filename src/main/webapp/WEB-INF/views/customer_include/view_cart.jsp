<%@page import="java.time.LocalDate"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!--Section: Block Content-->
<section style="background-color: #f7f7f7;">

	<!--Grid row-->
	<div class="row">

		<!--Grid column-->
		<div class="col-lg-8">

			<!-- Card -->
			<div class="mb-3" style="margin-top:5%;margin-right:20%;margin-bottom:5%;">
				<div class="pt-4 wish-list" style="margin-left:5%;">
					<h5 class="mb-4">
						Cart (<span>${quantity}</span> items)
					</h5>
					<c:forEach var="cartItem"
						items="${sessionScope.customerDetails.cart.cartItems}">
						<%-- <c:set var="product" value="${cartItem.product}" /> --%>
						<div class="row mb-4" style="margin:5%; border:2px solid black;">
							<div class="col-md-5 col-lg-3 col-xl-3">
								<div class="view zoom overlay z-depth-1 rounded mb-3 mb-md-0">
									<img class="img-fluid w-100"  style="padding:5%"
										src="data:image/jpeg/jpg;base64,${cartItem.product.imgUtility}"
										alt="Sample"> <a href="#!">
										<div class="mask">
											<img class="img-fluid w-100"
												src="data:image/jpeg/jpg;base64,${cartItem.product.imgUtility}">
											<div class="mask rgba-black-slight"></div>
										</div>
									</a>
								</div>
							</div>
							<div class="col-md-7">
								<div>
									<div class="d-flex">
										<div>
											<h5>${cartItem.product.title}</h5>
											<p class="mb-3 text-muted text-uppercase small">${cartItem.product.name}</p>
											<p class="mb-2 text-muted text-uppercase small"></p>
											<p class="mb-3 text-muted text-uppercase small"></p>
										</div>
										<div>
											<div
												class="def-number-input number-input safari_only">
												<button
													onclick="this.parentNode.querySelector('input[type=number]').stepDown()"
													class="minus decrease"></button>
												<input class="quantity" min="0" name="quantity"
													value="${cartItem.quantity}" type="number">
												<button
													onclick="this.parentNode.querySelector('input[type=number]').stepUp()"
													class="plus increase"></button>
											</div>
											<small id="passwordHelpBlock"
												class="form-text text-muted text-center">
												${cartItem.quantity} </small>
										</div>
									</div>
									<div class="d-flex justify-content-between align-items-center">
										<div>
											<a
												href="<spring:url value="/customer/removeFromCart?pid=${cartItem.product.id}"/>"
												type="button"
												class="card-link-secondary small text-uppercase mr-3"><i
												class="fas fa-trash-alt mr-1"></i> Remove item </a> <a
												href="<spring:url value="/customer/movetowishlist?pid=${cartItem.product.id}"/>"
												type="button"
												class="card-link-secondary small text-uppercase"><i
												class="fas fa-heart mr-1"></i> Move to wish list </a>
										</div>
										<p class="mb-0" style="margin:5%; border:2px solid black; text-align:center;">
											<span><strong id="summary">${cartItem.product.price }</strong></span>
										</p class="mb-0">
									</div>
								</div>
							</div>
						</div>
						<hr class="mb-4">
					</c:forEach>
					<p class="text-primary mb-0">
						<i class="fas fa-info-circle mr-1"></i> Total ${quantity} items in
						your cart
					</p>
					<p class="text-primary mb-0">
						<i class="fas fa-info-circle mr-1"></i> Do not delay the purchase,
						adding items to your cart does not mean booking them.
					</p>

				</div>
			</div>
		<div class="row">
			<div class="col-lg-3" style="margin:5%;">
				<div class="pt-4">

					<h5 class="mb-4">Expected shipping delivery</h5>

					<p class="mb-0">
						<%
							LocalDate shippingDate = LocalDate.now();
						out.println(shippingDate.plusDays(15));
						%>
					</p>
				</div>
			</div>
			<div class="col-lg-3" style="margin:5%;">
				<div class="pt-4">

					<h5 class="mb-4">We accept</h5>

					<img class="mr-2" width="45px"
						src="https://mdbootstrap.com/wp-content/plugins/woocommerce-gateway-stripe/assets/images/visa.svg"
						alt="Visa"> <img class="mr-2" width="45px"
						src="https://mdbootstrap.com/wp-content/plugins/woocommerce-gateway-stripe/assets/images/amex.svg"
						alt="American Express"> <img class="mr-2" width="45px"
						src="https://mdbootstrap.com/wp-content/plugins/woocommerce-gateway-stripe/assets/images/mastercard.svg"
						alt="Mastercard"> <img class="mr-2" width="45px"
						src="https://mdbootstrap.com/wp-content/plugins/woocommerce/includes/gateways/paypal/assets/images/paypal.png"
						alt="PayPal acceptance mark">
				</div>
			</div>
			<!-- Card -->
</div>
		</div>
		<!--Grid column-->

		<!--Grid column-->
		<div class="col-lg-4">

			<!-- Card -->
			<div class="mb-3">
				<div class="pt-4">







					<h5 class="mb-3" >The total amount of ${sessionScope.sumTotal}</h5>

					<ul class="list-group list-group-flush" style="margin:5%; border:2px solid black;">

						<li
							class="list-group-item d-flex justify-content-between align-items-center px-0">
							Shipping <span>Gratis</span>
						</li>
						<li
							class="list-group-item d-flex justify-content-between align-items-center border-0 px-0 mb-3">
							<div>
								<strong>The total amount of</strong> <strong>
									<p class="mb-0">(including VAT)</p>
								</strong>
							</div> <span><strong>${sumTotal} Rs.</strong></span>
						</li>
					</ul>

					<a class="btn btn-primary btn-block" style="float:left;"
						href="<spring:url value="/customer/check"/>">go to checkout</a>

				</div>
			</div>
			<!-- Card -->

			<!-- Card -->
			<div class="mb-3">
				<div class="pt-4">


					<div class="collapse" id="collapseExample">
						<div class="mt-3">
							<div class="md-form md-outline mb-0">
								<input type="text" id="discount-code"
									class="form-control font-weight-light"
									placeholder="Enter discount code">
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- Card -->

		</div>
		<!--Grid column-->

	</div>
	<!-- Grid row -->

</section>
<!--Section: Block Content-->