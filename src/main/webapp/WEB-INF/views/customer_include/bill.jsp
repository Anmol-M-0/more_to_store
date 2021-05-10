<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<section style="background-color: #f7f7f7;">	
	<div class="container">
  	<div class="row">
  		<div class="row">
			<div class="col-lg-12 panel ">
			<h2>Total Bill</h2>
		</div>
	</div>
		
<hr>
<div class="row" style="border: 2px solid black"> 
	<div class="col-75">
    <div class="container">    
       <div class="row">
          <div class="col-50">
            <h3>Customer Details</h3>
            <label for="fname"><i class="fa fa-user"></i> Full Name</label>
            <input style="border: none;" type="text" name="firstname" value="${sessionScope.customerDetails.name}">
            <label for="mobileNo"><i class="fa fa-envelope"></i> MobileNo</label>
            <input style="border: none;" type="text" name="email" value="${sessionScope.customerDetails.mobileNo}">
           </div>
          </div>
    </div>
	</div>	
	
	<div class="col-25">
    <div class="container">
      <h3>Shopping Details <span class="price" style="color:black"><i class="fa fa-shopping-cart">
      </i>${sessionScope.quantity} <b></b></span></h3>
     	
     	<div class="row">
			<div class="col-12">
     	<table class="table table-bordered">
     	<tr>
     		<th style="font: 1em 'Fira Sans', sans-serif;">Product Title</th>
     		<th style="font: 1em 'Fira Sans', sans-serif;">Price</th>
     	</tr>
     	<c:forEach  var="cartItem" items="${sessionScope.customerDetails.cart.cartItems}">
     	<tr >
     	<td style="font: 1em 'Fira Sans', sans-serif;">${cartItem.product.title}</td>
     	<td style="font: 1em 'Fira Sans', sans-serif;">${cartItem.product.price}</td>
     	</tr>	
     	</c:forEach>
     	</table>
      <hr>
      <br><br>
    <h2> <span style="border: 2px solid black;padding: 5px;">Total :<b>${sessionScope.sumTotal}</b></span></h2> 
    <center>  <a style="margin-bottom: 20px;" class="btn btn-primary mb-2" href='<spring:url value="/customer/thankyou"/>'>Done</a></center>
    </div>  
      
    </div>
  </div>
</div>
</div>
	
		
  	</div>
  	</div>
 </section>
