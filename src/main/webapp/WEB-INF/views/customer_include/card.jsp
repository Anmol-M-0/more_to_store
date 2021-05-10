<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
	<section style="background-color: #f7f7f7;">	
	<div class="container">
	
	
  	<div class="row">	

						<div class="row">
							<div class="col-lg-12 panel ">
								<h2 style="text-align: left;">Card Information</h2>
							</div>
						</div>

						<div class="row">
							<div class="col-lg-12 panel ">
								<h3 style="text-align: left;">Payment</h3>
           						 <label for="fname" style="text-align: left;">Accepted Cards</label>
            					<div class="icon-container" style="text-align: left;">
           					    <i class="fa fa-cc-visa" style="color:navy;"></i>
              					<i class="fa fa-cc-amex" style="color:blue;"></i>
              					<i class="fa fa-cc-mastercard" style="color:red;"></i>
              					<i class="fa fa-cc-discover" style="color:orange;"></i>
            					</div>
						    </div>
						</div>
            
            <form method="post" style="margin:5px;background-color:#FDEDCC;  padding-left:25%;padding-top:25px;border:2px solid black; align:center;">
            <div class="row form-group">
            <div class="col-lg-8">
				<label class="col control-label text-center" for="cname">Name on Card</label>
				<input style="background-color: white; border: none; "name="cardname" id="cname" 
						placeholder="John More Doe" class="form-control" type="text" required />
			</div>
            
            <div class="col-lg-8">
				<label class="col control-label text-center" for="ccnum">Credit/Debit Card Number</label>
				<input name="cardnumber" id="ccnum" required  maxlength="16"
						placeholder="1111-2222-3333-4444" class="form-control" type="text" />
			</div>
					<div class="col-lg-8">
			<div class="col-lg-3">
				<label class="col control-label text-center" for="expmonth" >Exp Month</label>
				<input name="expmonth" id="expmonth" 
						placeholder="September" class="form-control" type="text" required/>
			</div>
						
			<div class="col-lg-3">
				<label class="col control-label text-center" for="expyear">Exp Year</label>
				<input name="expyear" id="expyear" 
						placeholder="2018" class="form-control text-center" type="text" required />
			</div>
			<div class="col-lg-2">
				<label class="col control-label text-center" for="cvv">CVV</label>
				<input name="cvv" id="cvv" placeholder="352" class="form-control text-center" 
					   type="text" required  maxlength="3"/>
			</div>
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
       