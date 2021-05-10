
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="content-wrapper">
	<div class="container-fluid">
		<ol class="breadcrumb">
			<li class="breadcrumb-item"><a href="#">Layout</a></li>
			<li class="breadcrumb-item active">sub_category</li>
			<li class="breadcrumb-item">
			<a class="btn btn-primary right" href='<spring:url value="/admin/admin_dashboard"/>'>Back</a></li>
		</ol>
		<div class="alert alert-primary text-center" role="alert">
			<h2>Sub Category List</h2>
		</div>

		<h3
			style="color: red; background-color: white; margin-right: 150px; margin-left: 150px;">${requestScope.message}</h3>
		<div class="container mt-3">
			<form method="post">
				<div class="form-group">
					<label for="Category">Select Parent Category :</label> <select
						name="cid" class="form-control" >
						<c:forEach items="${categoryList}" var="category">
							<option value="${category.id}">${category.cTitle}</option>
						</c:forEach>
					</select>
				</div>
				<div class="form-group">
					<label>Sub Category Title</label> <input type="text"
						name="subCTitle" class="form-control" />
				</div>
				<input type="submit" class="btn btn-primary" value="Add new " />
			</form>
		</div>

		<div class="row">
			<div class="col-12">
				<table class="table table-bordered">
					<thead>
						<tr>
							<th scope="col">Sr No</th>						
							<th scope="col">Parent Category Title</th>
							<th scope="col">Sub-Category Title</th>
							<th scope="col">Status</th>
							<th scope="col">Actions</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="s" items="${subCategoryList}">
							<tr>
								<td scope="row">${s.id}</td>
								<td>${s.parentCategory.cTitle}</td>
								<td>${s.subCTitle}</td>
								<td>${s.subStatus}</td>
								<td>
								<a
									href='<spring:url value="/admin/subCategory_status?sid=${s.id}"/>'><button
											type="button" class="btn btn-primary">
											<i class="far fa-eye"></i>
										</button></a> <a
									href='<spring:url value="/admin/subCategory_delete?sid=${s.id}"/>'><button
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