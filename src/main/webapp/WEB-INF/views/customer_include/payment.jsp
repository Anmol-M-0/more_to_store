
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div style="background-color: white" class="content-wrapper">
	<div class="container-fluid">
		<ol class="breadcrumb">
			<li class="breadcrumb-item"><a href="#">Payment</a></li>
			<li class="breadcrumb-item active">Make Payment</li>
			<li class="breadcrumb-item">
			<a class="btn btn-primary right" href='<spring:url value="/admin/admin_dashboard"/>'>Back</a></li>
		</ol>
		<div class="alert alert-primary text-center" role="alert">
			<h2>Payment Information</h2>
		</div>
			<div class="container" style="margin-left: 450px;">
				<form method="post" action="<spring:url value='/customer/payment'/>">
						<div class="col-lg-2">
							<label class="col control-label text-center" for="payment_amount">
									Payment Amount</label>
							<div class="input-group">
								<input id="payment_amount" name="amount" value="${sessionScope.sumTotal}"
									class="form-control text-center" type="number" readonly="true"/>
							</div>
						</div>
					
						<div class="col-md-2">
							<label class="col control-label text-center" for="ram">Choose Payment Mode</label>
							<div class="input-group">
								<select name="page" id="page" class="form-control">
									<option value="card">CARD</option>
									<option value="upi">UPI</option>
									<option value="netbanking">NETBANKING</option>
									<option value="cod">COD</option>
								</select>
							</div>
						</div>
						<br><br>
						<div class="form-group row">
							<div class="col-md-4 col-sm-6 text-center"  style="margin-top: 20px;">
								<input type="submit" id="save" value="Next" name="save"
									class="btn btn-large btn-success">

								<button class="btn btn-large btn-danger" type="reset">Cancel</button>
							</div>
						</div>
				
				</form>
			</div>

		</div>
	</div>
