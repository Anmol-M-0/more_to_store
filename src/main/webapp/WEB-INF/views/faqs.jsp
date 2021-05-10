<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>More To Store</title>
<!-- Bootstrap CSS -->
<link rel='stylesheet'
	href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css'>
<!-- Font Awesome CSS -->
<link rel='stylesheet'
	href='https://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css'>
<!-- jQuery -->
<script
	src='https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
<!-- Bootstrap JS -->
<script
	src='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js'></script>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="<spring:url value='/css/customer.css'/>"
	type="text/css" />
<link
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<script type="text/javascript"
	src="<spring:url value='/js/frontProduct.js'/>"></script>
<script
	src='//production-assets.codepen.io/assets/editor/live/console_runner-079c09a0e3b9ff743e39ee2d5637b9216b3545af0de366d4b9aad9dc87e26bfd.js'></script>
<script
	src='//production-assets.codepen.io/assets/editor/live/events_runner-73716630c22bbc8cff4bd0f07b135f00a0bdc5d14629260c3ec49e5606f98fdd.js'></script>
<script
	src='//production-assets.codepen.io/assets/editor/live/css_live_reload_init-2c0dc5167d60a5af3ee189d570b1835129687ea2a61bee3513dee3a50c115a77.js'></script>
<meta charset='UTF-8'>
<meta name="robots" content="noindex">
<link rel="shortcut icon" type="image/x-icon"
	href="//production-assets.codepen.io/assets/favicon/favicon-8ea04875e70c4b0bb41da869e81236e54394d63638a1ef12fa558a4a835f1164.ico" />
<link rel="mask-icon" type=""
	href="//production-assets.codepen.io/assets/favicon/logo-pin-f2d2b6d2c61838f7e76325261b7195c27224080bc099486ddd6dccb469b8e8e6.svg"
	color="#111" />
<link rel="canonical"
	href="https://codepen.io/dylanhobbs/pen/kXRVwr?depth=everything&order=popularity&page=55&q=product&show_forks=false" />


<style class="cp-pen-styles">
@import
	url(https://fonts.googleapis.com/css?family=Roboto+Condensed:400,300,700)
	;

body {
	padding: 0;
	margin: 0;
	background-color: #fefefe;
	font-size: 16px;
	text-rendering: optimizeLegibility;
	-webkit-font-smoothing: antialiased;
	-moz-osx-font-smoothing: grayscale;
	-moz-font-feature-settings: "liga" on;
}

.description {
	padding: 1em;
}

h3 {
	font-family: 'Lato';
	color: white;
	letter-spacing: 0.08rem;
	font-weight: 700;
}

h3 span {
	font-weight: 900;
}

.description p {
	margin-top: -0.75em;
	font-size: 0.85em;
	color: white;
	font-weight: 300;
	width: 22vw;
}

p {
	font-family: 'Roboto Condensed', sans-serif;
	font-weight: 700;
}

.card-container {
	z-index: 1;
	margin: 0 auto;
	width: 100%;
}

.object {
	position: relative;
	border-radius: 2%;
	margin: 12vh auto;
	width: 50%;
	height: 50vh;
	background-color: #ff0; /* Old browsers */
	background-image: -moz-linear-gradient(-45deg, #f96217 0%, #f2092a 100%);
	/* FF3.6-15 */
	background-image: -webkit-linear-gradient(-45deg, #f96217 0%, #f2092a 100%);
	/* Chrome10-25,Safari5.1-6 */
	background-image: linear-gradient(135deg, rgba(249, 98, 23, 0.75) 0%,
		rgba(249, 23, 23, 1) 100%);
	/* W3C, IE10+, FF16+, Chrome26+, Opera12+, Safari7+ */
	background-blend-mode: multiply;
	transition: all 1s;
}

.object.expanded {
	background-color: #F91717;
	width: 90%;
}

.object .product.transition {
	transform: matrix(0.8, 0, 0, 0.8, 300, -220);
	will-change: transform;
	transition: all 1s ease-in-out;
}

.object .logo {
	width: 6vw;
	padding-top: 0.5em;
	padding-left: 1.5em;
}

.object .logo img {
	max-width: 100%;
}

.object .product {
	z-index: 10;
	position: absolute;
	width: 34vw;
	margin-left: -12vw;
	margin-top: 1vh;
	transition: all 1s ease-in-out;
}

.object .product img {
	max-width: 100%;
}

.hero p.title {
	position: absolute;
	font-size: 3em;
	top: 10.4%;
	font-size: 12em;
	z-index: 1;
	opacity: 0.12;
	transition: all 1s;
}

.button {
	z-index: 2;
	position: absolute;
	top: 55vh;
	left: 23vw;
	padding-top: 0.95em;
	padding-bottom: 0.75em;
	white-space: nowrap;
	background-image:
		url('https://s3-us-west-2.amazonaws.com/s.cdpn.io/477444/shopping-white.svg');
	background-repeat: no-repeat;
	background-size: 45%;
	background-position: center;
	background-color: rgb(0, 194, 235);
	height: 1.7em;
	width: 3.5em;
	border-radius: 50%;
	box-shadow: 0 1px 3px rgba(0, 194, 235, 0.12), 0 1px 2px
		rgba(0, 194, 235, 0.24);
	transition: all 0.5s;
}

.button:hover {
	box-shadow: 0 3px 6px rgba(0, 194, 235, 0.16), 0 3px 6px
		rgba(0, 194, 235, 0.23);
}

.button.expanded {
	width: 8em;
	height: 1.5em;
	left: 37vw;
	border-radius: 5px;
	text-align: center;
	padding-top: 0.95em;
	padding-bottom: 0.75em;
	transition: all 0.5s;
	background-image: none;
}

.button span {
	display: none;
	opacity: 0;
	white-space: nowrap;
}

.button.expanded span {
	display: initial;
	opacity: 1;
	color: white;
	font-family: 'Lato';
	font-weight: 600;
}

.button.expanded .bold {
	font-weight: 900;
}
</style>
</head>
<body>
	<%@include file="./customer_navigation.jsp"%>
	<div class="container-fluid ">
		<div class="panel-group" id="faqAccordion">


			<div class="panel panel-default ">
				<div
					class="panel-heading accordion-toggle question-toggle collapsed"
					data-toggle="collapse" data-parent="#faqAccordion"
					data-target="#question0">
					<h4 class="panel-title">
						<a href="#" class="ing">Q:What can I return ?</a>
					</h4>

				</div>
				<div id="question0" class="panel-collapse collapse"
					style="height: 0px;">
					<div class="panel-body">
						<h5>
							<span class="label label-primary">Answer</span>
						</h5>

						<p>You may request returns for most items you buy from sellers
							listed on More-To-Store that are within the return window, except
							those that are explicitly identified as not returnable on the
							product detail page.Items are returnable if you've received them
							in a condition that is physically damaged, has missing parts or
							accessories, defective or different from its description on the
							product detail page on More-To-Store</p>
					</div>
				</div>
			</div>


			<div class="panel panel-default ">
				<div
					class="panel-heading accordion-toggle collapsed question-toggle"
					data-toggle="collapse" data-parent="#faqAccordion"
					data-target="#question1">
					<h4 class="panel-title">
						<a href="#" class="ing">Q: What are the return guidelines? </a>
					</h4>

				</div>
				<div id="question1" class="panel-collapse collapse"
					style="height: 0px;">
					<div class="panel-body">
						<h5>
							<span class="label label-primary">Answer</span>
						</h5>

						<p>Following are the return guidelines: 1.Your address and the
							item that you wish to return must be eligible for return. 2.If
							the return is not eligible for Pickup, a Self-Return option will
							be given. 3.Once the return is received, you will, in accordance
							with More-To_Store Refund Policy, be issued a refund to your
							original payment method. For Pay on Delivery orders, refunds will
							be processed either to your bank account (via National Electronic
							Funds Transfer (NEFT)).</p>
					</div>
				</div>
			</div>
			<div class="panel panel-default ">
				<div
					class="panel-heading accordion-toggle collapsed question-toggle"
					data-toggle="collapse" data-parent="#faqAccordion"
					data-target="#question2">
					<h4 class="panel-title">
						<a href="#" class="ing">Q: Can my order be replaced?</a>
					</h4>

				</div>
				<div id="question2" class="panel-collapse collapse"
					style="height: 0px;">
					<div class="panel-body">
						<h5>
							<span class="label label-primary">Answer</span>
						</h5>

						<p>If the item you ordered arrived in a physically damaged or
							defective condition or is different from their description on the
							product detail page , or has missing parts or accessories, it
							will be eligible for a free replacement, provided the exact item
							is available with the same seller.</p>
					</div>
				</div>
			</div>
			<div class="panel panel-default ">
				<div
					class="panel-heading accordion-toggle collapsed question-toggle"
					data-toggle="collapse" data-parent="#faqAccordion"
					data-target="#question3">
					<h4 class="panel-title">
						<a href="#" class="ing">Q: When will I get my refund?</a>
					</h4>

				</div>
				<div id="question3" class="panel-collapse collapse"
					style="height: 0px;">
					<div class="panel-body">
						<h5>
							<span class="label label-primary">Answer</span>
						</h5>

						<p>In case of replacement or exchange, the new product will be
							delivered to your address after the returned product is
							inspected. If you opted for a refund, it will be processed within
							7-10 working days.</p>
					</div>
				</div>
			</div>


			<div class="panel panel-default ">
				<div
					class="panel-heading accordion-toggle question-toggle collapsed"
					data-toggle="collapse" data-parent="#faqAccordion"
					data-target="#question4">
					<h4 class="panel-title">
						<a href="#" class="ing">Q: Which items are eligible for a Free
							Replacement?</a>
					</h4>

				</div>
				<div id="question4" class="panel-collapse collapse"
					style="height: 0px;">
					<div class="panel-body">
						<h5>
							<span class="label label-primary">Answer</span>
						</h5>

						<p>Fulfilled by More-To-Store items, Prime eligible items and
							few Seller Fulfilled items are eligible for free replacements. If
							an eligible item is out of stock from the same seller, it cannot
							be replaced. Only a refund against the returned item will be
							issued.</p>
					</div>
				</div>
			</div>


			<div class="panel panel-default ">
				<div
					class="panel-heading accordion-toggle question-toggle collapsed"
					data-toggle="collapse" data-parent="#faqAccordion"
					data-target="#question5">
					<h4 class="panel-title">
						<a href="#" class="ing">Q: What are the conditions for Free
							Replacement?</a>
					</h4>

				</div>
				<div id="question5" class="panel-collapse collapse"
					style="height: 0px;">
					<div class="panel-body">
						<h5>
							<span class="label label-primary">Answer</span>
						</h5>

						<p>Items within return window and in stock (exact same item)
							with same seller are eligible for free replacement. The free
							replacement order will be shipped through standard shipping once
							the original order is returned. Free replacements can be
							requested if the following conditions apply: 1.Item received is
							physically damaged; 2.Item received has missing parts or
							accessories; 3.Item received is different from their description
							on the product detail page on Amazon.in; or 4.Item received is
							defective/does not work properly.</p>
					</div>
				</div>
			</div>


			<div class="panel panel-default ">
				<div
					class="panel-heading accordion-toggle question-toggle collapsed"
					data-toggle="collapse" data-parent="#faqAccordion"
					data-target="#question6">
					<h4 class="panel-title">
						<a href="#" class="ing">Q: General Returns Policy</a>
					</h4>

				</div>
				<div id="question6" class="panel-collapse collapse"
					style="height: 0px;">
					<div class="panel-body">
						<h5>
							<span class="label label-primary">Answer</span>
						</h5>

						<p>1.Products are returnable within the applicable return
							window if youâve received them in a condition that is
							physically damaged, has missing parts or accessories, defective
							or different from their description on the product detail page on
							Amazon.in. 2.If you report an issue with your Smart phone,
							Tablet, Lap-top, Television, Air Conditioner, Refrigerator,
							Washing Machine, Microwave, we may schedule a technician visit to
							your location. This visit is scheduled by placing an order with
							Amazon through Amazon.in Home Services. Subject to Amazon.in Home
							Services Terms and Conditions, a resolution will be provided
							based on the technician's evaluation report. 3.Return will be
							processed only if: it is determined that the product was not
							damaged while in your possession; the product is not different
							from what was shipped to you; the product is returned in original
							condition (with brandâs/manufacturer's box, MRP tag intact,
							user manual, warranty card and all the accessories therein). 4.
							If you wish to return an electronic device that stores any
							personal information, please ensure that you have removed all
							such personal information from the device prior to returning.
							Amazon shall not be liable in any manner for any misuse or usage
							of such information. 5. Products may not be eligible for return
							in some cases, including cases of buyer's remorse such as
							incorrect model or color of product ordered or incorrect product
							ordered. 6.Products marked as "non-returnable" on the product
							detail page cannot be returned. 7.Additional information is not
							required to return an eligible order unless otherwise noted in
							the category specific policy. 8.Products may be eligible for
							replacement only if the same seller has the exact same item in
							stock. 9.If the replacement request is placed and the seller does
							not have the exact same product in stock, we will provide a
							refund. 10. Products purchased by international customers are not
							eligible for returns. However, orders made by international
							customers are eligible for refunds. 11.To know about the Return
							window for Amazon Business orders, please visit here.</p>
					</div>
				</div>
			</div>
		</div>
		<!--/panel-group-->
	</div>

	<%@include file="customer/footer.jsp"%>
</body>
</html>