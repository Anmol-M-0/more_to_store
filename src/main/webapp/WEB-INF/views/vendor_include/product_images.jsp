   
  <%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
  <div class="content-wrapper">
    <div class="container-fluid">
      <ol class="breadcrumb">
        <li class="breadcrumb-item">
          <a href="#">Products</a>
        </li>
        <li class="breadcrumb-item">Show Category</li>
        <li class="breadcrumb-item">Product list</li>
        <li class="breadcrumb-item active">Add Images</li>
        <li class="breadcrumb-item"><a class="btn btn-primary right" href='<spring:url value="/vendor/product_i_list?id=${sessionScope.vendorCategoriesId}"/>'>Back</a></li>
      </ol>
     <div class="alert alert-primary text-center" role="alert">
			<h2>Product Images</h2>
		</div>

		<h3
			style="color: red; background-color: white; margin-right: 150px; margin-left: 150px;">${requestScope.Message}</h3>
		<div class="container mt-3">
			<form method="post" enctype="multipart/form-data">
				<div class="form-group">
					<label for="category">Product Title:</label>
					 <input type="text" class="form-control" name="title" id="title" readonly="true" value="${requestScope.product.title}">
				</div>

				<p>Product Image:</p>
				<input type="file" id="myFile" name="image"> <input
					type="submit" class="btn btn-primary" value="upload" />

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
							<th scope="col">Product Image</th>
							<th scope="col">Product Title</th>
							<th scope="col">Actions</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="product" items="${sessionScope.productImages}">
							<tr>
								<td scope="row">${product.id}</td>
								<td><img src="data:image/jpeg;base64,${product.imgUtility}" height=100px width=100px/></td>
								<td>${requestScope.product.title}</td>
								<td>  <a 
									href='<spring:url value="/vendor/image_delete?proId=${product.id}"/>'><button
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