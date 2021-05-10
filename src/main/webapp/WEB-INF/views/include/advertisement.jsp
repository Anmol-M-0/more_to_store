
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="content-wrapper">
	<div class="container-fluid">
		<ol class="breadcrumb">
			<li class="breadcrumb-item"><a href="#">Layout</a></li>
			<li class="breadcrumb-item active">Advertisement</li>
			<li class="breadcrumb-item">
			<a class="btn btn-primary right" href='<spring:url value="/admin/admin_dashboard"/>'>Back</a></li>
		</ol>
		<div class="alert alert-primary text-center" role="alert">
			<h2>Advertisement List</h2>
		</div>

		<h3
			style="color: red; background-color: white; margin-right: 150px; margin-left: 150px;">${requestScope.message}</h3>
		<div class="container mt-3">
			<form method="post" enctype="multipart/form-data">
				<div class="form-group">
					<label for="category">Category Title:</label>
					 <select class="form-control"id="category" name="category">
					<c:forEach var="cat" items="${sessionScope.categoryList}">
						<option value="${cat.cTitle}">${cat.cTitle}</option>
					</c:forEach>
					</select>
				</div>

				<p>Advertisement Image:</p>
				<input type="file" id="myFile" name="image"> <input
					type="submit" class="btn btn-primary" value="Add New" />

			</form>
		</div>
		<script>
			$(".custom-file-input").on(
					"change",
					function() {
						var fileName = $(this).val().split("\\").pop();
						$(this).siblings(".custom-file-label").addClass(
								"selected").html(fileName);
					});
		</script>
		<div class="row">
			<div class="col-12">
				<table class="table table-bordered">
					<thead>
						<tr>
							<th scope="col">Sr No</th>
							<th scope="col">Advertisement Image</th>
							<th scope="col">Category Title</th>
							<th scope="col">Status</th>
							<th scope="col">Actions</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="add" items="${sessionScope.advertiseList}">
							<tr>
								<td scope="row">${add.id}</td>
								<td><img src="data:image/jpeg;base64,${add.imgUtility}" height=100px width=100px/></td>
								<td>${add.cTitle}</td>
								<td>${add.aStatus}</td>
								<td><a 
									href='<spring:url value="/admin/advertise_status?aid=${add.id}"/>'><button
											type="button" class="btn btn-primary">
											<i class="far fa-eye"></i>
										</button></a> <a 
									href='<spring:url value="/admin/advertise_delete?aid=${add.id}"/>'><button
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