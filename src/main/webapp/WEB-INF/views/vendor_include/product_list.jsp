
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="content-wrapper">
	<div class="container-fluid">
		<ol class="breadcrumb">
			<li class="breadcrumb-item"><a href="#">Product</a></li>
			<li class="breadcrumb-item">Show Category</li>
			<li class="breadcrumb-item active">Product List</li>
			<li class="breadcrumb-item">
			<a class="btn btn-primary right" href='<spring:url value="/vendor/show_category"/>'>Back</a></li>
		</ol>
		<div class="alert alert-primary text-center" role="alert">
			<h2>Product List </h2>
		</div>

		<div class="row">
			<div class="col-12">
				<table class="table table-bordered">
					<thead>
						<tr>
							<th scope="col">Sr No</th>
							<th scope="col">Name</th>
							<th scope="col">Title</th>
							<th scope="col">Stock</th>
							<th scope="col">Status</th>
							<th scope="col">Actions</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="prod" items="${requestScope.allMobiles}">
							<tr>
								<td scope="row">${prod.id}</td>
								<td>${prod.name}</td>
								<td>${prod.title}</td>
								<td>${prod.stock}</td>
								<td>${prod.status}</td>
								<td><a
									href='<spring:url value="/vendor/product_status?id=${prod.id}"/>'><button
											type="button" class="btn btn-primary">
											<i class="far fa-eye"></i>
										</button></a> <a
									href='<spring:url value="/vendor/product_update?id=${prod.id}"/>'><button
											type="button" class="btn btn-success">
											<i class="fas fa-edit"></i>
										</button></a>
										 <a
									href='<spring:url value="/vendor/product_delete?id=${prod.id}"/>'><button
											type="button" class="btn btn-danger">
											<i class="far fa-trash-alt"></i>
										</button></a></td>
							</tr>
						</c:forEach>
						<c:forEach var="prod" items="${requestScope.allFashion}">
							<tr>
								<td scope="row">${prod.id}</td>
								<td>${prod.name}</td>
								<td>${prod.title}</td>
								<td>${prod.stock}</td>
								<td>${prod.status}</td>
								<td><a
									href='<spring:url value="/vendor/product_status?id=${prod.id}"/>'><button
											type="button" class="btn btn-primary">
											<i class="far fa-eye"></i>
										</button></a> <a
									href='<spring:url value="/vendor/product_update?id=${prod.id}"/>'><button
											type="button" class="btn btn-success">
											<i class="fas fa-edit"></i>
										</button></a>
										 <a
									href='<spring:url value="/vendor/product_delete?id=${prod.id}"/>'><button
											type="button" class="btn btn-danger">
											<i class="far fa-trash-alt"></i>
										</button></a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
		</div>
	</div>