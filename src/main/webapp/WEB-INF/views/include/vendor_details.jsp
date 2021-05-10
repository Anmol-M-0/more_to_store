
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="content-wrapper">
	<div class="container-fluid">
		<ol class="breadcrumb">
			<li class="breadcrumb-item"><a href="#">Layout</a></li>
			<li class="breadcrumb-item active">Vendor Details</li>
		</ol>
		<div class="alert alert-primary text-center" role="alert">
			<h2>Vendor List</h2>
		</div>

		<h3
			style="color: red; background-color: white; margin-right: 150px; margin-left: 150px;">${requestScope.message}</h3>
	
	<a href='<spring:url value="/admin/vendor_registration"/>'>
	<button type="button" class="btn btn-primary" >Add New Vendor</button></a><!-- float-right -->
		
		<div class="row">
			<div class="col-12">
				<table class="table table-bordered">
					<thead>
						<tr>
							<th scope="col">Sr No</th>
							<th scope="col">Vendor Full Name</th>
							<th scope="col">Vendor Mobile Number</th>
							<th scope="col">Vendor Product into Category/Categories</th>
							<th scope="col">Status</th>
							<th scope="col">Actions</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="v" items="${vendorList}">
							<tr>
								<td scope="row">${v.id}</td>
								<td>${v.fullName}</td>
								<td>${v.mobileNo}</td>
				<!-- change --> <td>
			<ul>	
				<c:forEach items="${v.vendorCategory}" var="i" >
			<li>
			${i.categoryTitle}
			</li>
				</c:forEach>
			</ul>	
				
				</td>
								<td>${v.status}</td>
								<td><a
									href='<spring:url value="/admin/vendor_status?id=${v.id}"/>'><button
											type="button" class="btn btn-primary">
											<i class="far fa-eye"></i>
										</button></a> 
										<a
									href='<spring:url value="/admin/vendor_updation?id=${v.id}"/>'><button
											type="button" class="btn btn-success">
											<i class="fas fa-edit"></i>
										</button></a>
										 <a
									href='<spring:url value="/admin/vendor_delete?id=${v.id}"/>'><button
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