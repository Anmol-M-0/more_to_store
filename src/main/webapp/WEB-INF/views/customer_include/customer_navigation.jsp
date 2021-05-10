<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.app.pojos.SubCategory"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<nav class="navbar navbar-default navbar-inverse">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href='<spring:url value="/"/>'> <img
				src='<spring:url value="/image/brand.png"/>' />
			</a>
		</div>
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<form class="navbar-form navbar-left " role="search">
				<div class="col form-group text-center">
					<input type="text" class="form-control space" placeholder="Search">
				</div>
				<button type="submit" class="btn btn-default">Search</button>
			</form>
			<ul class="nav navbar-nav navbar-right">
				<li><a href='<spring:url value="/customer/about_us"/>'
					class="nav-link">About Us</a></li>
				<%
					if ((session.getAttribute("customerDetails") == null) || (session.getAttribute("customerDetails") == "")) {
				%>
				<li><a href="#login" class="nav-link" data-toggle="modal"><i
						class="fa fa-sign-in"></i> Login</a></li>
				<li><a href="#register" class="nav-link" data-toggle="modal"><i
						class="fa fa-user-plus"></i> Register</a></li>
				<%
					} else {
				%>

				<li><a href='<spring:url value="/customer/view_cart"/>'
					class="nav-link"><i class="fa fa-shopping-cart"
						aria-hidden="true"></i>Cart</a></li>
				<li><a href='<spring:url value="/customer/view_wishlist"/>'
					class="nav-link"><i class="fa fa-heart" aria-hidden="true"></i>Wishlist</a></li>
				<li><a href='<spring:url value="/logout"/>' class="nav-link"><i
						class="fa fa-sign-out"></i> Logout</a></li>

				<%
					}
				%>
				<li><a href='<spring:url value="../contactus"/>'
					class="nav-link">Contact Us</a></li>
						<li><a href='<spring:url value="../faqs"/>'
					class="nav-link">FAQ's</a></li>
			</ul>
			<div class="modal fade" id="login">
				<div class="modal-dialog modal-dialog-centered" role="document">
					<div class="modal-content form-wrapper">
						<div class="close-box" data-dismiss="modal">
							<i class="fa fa-times fa-2x"></i>
						</div>
						<div class="container-fluid mt-5">
							<form action='<spring:url value="/login"/>' method="post"
								id="LoginForm">
								<div class="form-group text-center">
									<h4>Login Form</h4>
									<h6>Enter your credentials</h6>
								</div>
								<div class="form-group" style="position: relative;">
									<label for="l_email">Email</label> <input type="email"
										id="l_email" name="email" class="form-control mb-1"
										placeholder="someone@something.domain" required>
								</div>
								<div class="form-group pb-3" style="position: relative;">
									<label for="l_password">Password</label> <input type="password"
										id="l_password" name="password" class="form-control mb-1"
										placeholder="*******************" required> <a
										href="#forgotPassword"
										style="display: block; position: absolute; right: 0;"
										title="Fill Email Field and Click it"> Forgot Password? </a>
								</div>
								<div class="form-group pt-2">
									<button class="btn btn-info form-control">Login</button>
								</div>

							</form>
						</div>
					</div>
				</div>
			</div>

			<div class="modal fade" id="register">
				<div class="modal-dialog modal-dialog-centered" role="document">
					<div class="modal-content form-wrapper">
						<div class="close-box" data-dismiss="modal">
							<i class="fa fa-times fa-2x"></i>
						</div>
						<div class="container-fluid mt-5">
							<form action='<spring:url value="/register"/>' method="post"
								id="RegisterationForm">
								<div class="form-group text-center pb-2">
									<h3
										style="color: red; background-color: white; margin-right: 150px; margin-left: 150px;">${requestScope.successMsg}</h3>
									<h3
										style="color: red; background-color: white; margin-right: 150px; margin-left: 150px;">${requestScope.errorMsg}</h3>
									<h4>Registration Form</h4>
								</div>
								<div class="form-row">
									<div class="form-group col">
										<label for="name">Name</label> <input type="text" name="name"
											class="form-control" placeholder="Jhon Doe" required>
									</div>

								</div>
								<div class="form-group" style="position: relative;">
									<label for="email">Email</label> <input type="email"
										name="email" class="form-control mb-1"
										placeholder="jhonedoe@gmail.com" required>


								</div>
								<div class="form-group" style="position: relative;">
									<label for="mobile">Mobile No</label> <input type="text"
										name="mobile" class="form-control mb-1"
										placeholder="9860388909" required>


								</div>
								<div class="form-row mb-1">
									<div class="form-group col">
										<label for="password">Password</label> <input type="password"
											name="password" class="form-control"
											placeholder="*******************" required>

									</div>
									<div class="form-group col">
										<label for="password_confirmation">Confirm Password</label> <input
											type="password" name="password_confirmation"
											class="form-control" placeholder="*******************"
											required>
									</div>
								</div>

								<div class="form-group">
									<button class="btn btn-info form-control">Register</button>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>


			<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
				integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
				crossorigin="anonymous"></script>
			<script
				src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
				integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
				crossorigin="anonymous"></script>
			<script
				src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.2/js/bootstrap.min.js"
				integrity="sha384-o+RDsa0aLu++PJvFqy8fFScvbHFLtbvScb8AjopnFD+iEQ7wo/CG0xlczd+2O/em"
				crossorigin="anonymous"></script>

		</div>
	</div>
	<hr>
	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#navbar2" aria-expanded="false"
				aria-controls="navbar">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>

		</div>
		<div id="navbar2" class="navbar-collapse collapse">
			<ul class="nav navbar-nav space">
				<c:forEach items="${mainCategory}" var="category">
					<li class="dropdown space2"><img class="ml-2"
						src="data:image/jpeg;base64,${category.imgUtility}" height=100px
						width=100px /> <a class="dropdown-toggle" data-toggle="dropdown"
						role="button" aria-haspopup="true" aria-expanded="false">
							${category.cTitle}<span class="caret"></span>
					</a>
						<ul class="dropdown-menu">
							<li><c:forEach items="${category.subCategories}"
									var="subcategory">
									<a
										href='<spring:url value="/customer/show_${category.cTitle}?subCId=${subcategory.id}"/>'>${subcategory.subCTitle}</a>
								</c:forEach></li>
						</ul></li>
				</c:forEach>

			</ul>
		</div>
	</div>
</nav>
