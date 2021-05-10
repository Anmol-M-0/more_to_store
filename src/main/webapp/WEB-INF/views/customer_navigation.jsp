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
				<li><a href='<spring:url value="customer/login"/>' class="nav-link" ><i
						class="fa fa-sign-in"></i> Login</a></li>
				<li><a href='<spring:url value="customer/register"/>' class="nav-link" s><i
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
				<li><a href='<spring:url value="./contactus"/>'
					class="nav-link">Contact Us</a></li>
						<li><a href='<spring:url value="./faqs"/>'
					class="nav-link">FAQ's</a></li>
			</ul>
			

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
