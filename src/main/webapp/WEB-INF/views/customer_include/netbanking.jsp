<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
	<section style="background-color: #f7f7f7;">	
	<div class="container">
  <div class="row">	
				<form method="post" >
						<div class="row">
							<div class="col-lg-12 panel ">
								<h2>Bank Information</h2>
							</div>
						</div>

<hr>
						
							
						<div class="row form-group">
							<div class="col-lg-8">
							<label class="col control-label text-center" for="pin_code">Bank Name</label>
								<input name="bank_name" id="bank_name" 
									placeholder="SBI" class="form-control text-center" type="text" />
							</div>

							<div class="col-lg-8">
							<label class="col control-label text-center" for="country">User ID</label>
								
									<input name="user_id" id="user_id" 
										placeholder="john54563" class="form-control text-center" type="text" />
								</div>
						</div>
						

						<div class="form-group row">
							<div class="col-md-8 text-center">
								<input type="submit" id="save" value="Generate Bill" name="save"
									class="btn btn-large btn-success">

								
							</div>
						</div>
						</form>
			
				</div>
			</div>
	</section>	