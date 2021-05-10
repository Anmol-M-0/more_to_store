
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="content-wrapper">
	<div class="container-fluid">
		<ol class="breadcrumb">
			<li class="breadcrumb-item"><a href="#">Products</a></li>
			<li class="breadcrumb-item active">Show Category</li>
				<li class="breadcrumb-item">
			<a class="btn btn-primary right" href='<spring:url value="/vendor/vendor_dashboard"/>'>Back</a></li>
		</ol>
		<div class="alert alert-primary text-center" role="alert">
			<h2>Vendor's Category List</h2>
		</div>

		<h3
			style="color: red; background-color: white; margin-right: 150px; margin-left: 150px;">${requestScope.message}</h3>
	
		
		<div class="row">
			<div class="col-12">
				<table class="table table-bordered">
					<thead>
						<tr>
							<th scope="col">Sr No</th>
							<th scope="col">Category Name</th>
							<th scope="col">Show Products</th>
						
						</tr>
					</thead>
					<tbody>
						<c:forEach var="cat" items="${categoryList}">
							<tr>
								<td scope="row">${cat.id}</td>
								<td>${cat.categoryTitle}</td>
								<td><a href='<spring:url value="/vendor/product_i_list?id=${cat.id}"/>'>Show all products</a></td>
								
						   </tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
		</div>
	</div>