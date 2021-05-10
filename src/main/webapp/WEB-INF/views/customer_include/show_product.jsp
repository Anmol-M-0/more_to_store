<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<h5 style="color: red; background-color: white; margin-right: 50px; margin-left: 50px;">${sessionScope.productNotAvailableMessage}</h5>
<div class="container">
	<div class="row">
		<c:forEach items="${mobileList}" var="mobile">
			<div class="col-md-3">
				<div class="dress-card">
				
					<div class="dress-card-head">
						<img class="dress-card-img-top product-image"
							src="data:image/jpeg;base64,${mobile.imgUtility}" alt="sai">
						<div class="surprise-bubble">
							<span class="dress-card-heart"> <i class="fas fa-heart"></i>
							</span><a
								href='<spring:url value="/customer/mobile_details?pid=${mobile.id}"/>'>
								<span>More Details</span>
							</a>
						</div>
					</div>
					<div class="dress-card-body">
						<h4 class="dress-card-title">${mobile.brand}</h4>
						<p class="dress-card-para">${mobile.title}</p>
						<p class="dress-card-para">
							<span class="dress-card-price">${mobile.price}
						</p>
						<div class="row">
							<div class="col-md-6 card-button">
								<a
									href='<spring:url value="/customer/addtocart?pid=${mobile.id}"/>'>
									<div class="card-button-inner bag-button">Add to Cart</div>
								</a>
							</div>
							<div class="col-md-6 card-button">
								<a
									href='<spring:url value="/customer/addtowish?pid=${mobile.id}"/>'>
									<div class="card-button-inner wish-button">Wishlist</div>
								</a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</c:forEach>
	</div>
</div>

</div>