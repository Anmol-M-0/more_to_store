<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!--Section: Block Content-->

<section style="background-color: white;">

  <!--Grid row-->
  <div class="row">

    <!--Grid column-->
    <div class="col-lg-8">

      <!-- Card -->
      <div class="mb-3">
        <div class="pt-4 wish-list">

          <h5 class="mb-4">WishList Items</h5>
	 <c:forEach var="Item" items="${sessionScope.customerDetails.wishlist.wishlistItems}">
					<c:set var="product" value="${Item.product}" />
            <div class="col-md-5 col-lg-3 col-xl-3">
            <img  src="data:image/jpeg;base64,${product.imgUtility}"
						class="img-responsive" alt="" height=200px width=300px>
            </div>
            <div class="col-md-7 col-lg-9 col-xl-9">
              <div>
                <div class="d-flex justify-content-between">
                  <div>
                  
                    <h5>${product.brand}</h5>
                    <p class="mb-3 text-muted text-uppercase small">${product.name}</p>
                    <p class="mb-2 text-muted text-uppercase small">${product.title}</p>
                    <p class="mb-3 text-muted text-uppercase small">${product.offer}</p>
                   
                  </div>
                </div>
                <div class="d-flex justify-content-between align-items-center">
                  <div>
                    <a href="<spring:url value="/customer/removeFromWishlist?pid=${product.id}"/>" type="button" class="card-link-secondary small text-uppercase mr-3"><i
                        class="fas fa-trash-alt mr-1"></i> Remove item </a>
                    <a href="<spring:url value="/customer/movetocart?pid=${product.id}"/>" type="button" class="card-link-secondary small text-uppercase"><i
                        class="fas fa-heart mr-1"></i> Move to cart</a>
                  </div>
                  <p class="mb-0"><span><strong id="summary">${product.price}</strong></span><p class="mb-0">
                </div>
              </div>
            </div>
             </c:forEach>
          
          
          </div>
      </div>
      <!-- Card -->
      
    </div>
  
  </div>
  <!-- Grid row -->  

</section>
<!--Section: Block Content-->