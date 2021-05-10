<section>
	<style>
.boxUpi {
	width: 30%;
	height: auto;
	border: 2px solid black;
	margin-left: 35%;
	box-shadow: 3px 4px 6px black;
}
</style>
	<form method="post">
		<div class="col-md-4 boxUpi" style="background-color: white">
			<label class="col control-label text-center" for="ram">Choose
				UPI</label>
			<div class="input-group">
				<select name="upi" id="upi" class="form-control">
					<option value="paytm">Paytm</option>
					<option value="gpay">Google Pay</option>
					<option value="pal">PhonePal</option>
					<option value="bhim">BHIM</option>
					<option value="phnpe">PhonePe</option>
				</select>
			</div>

			<label class="col control-label text-center" for="id"> Enter UPI Id
			</label>
			<i class="glyphicon glyphicon-user"></i> 
			<div class="input-group">
				<input id="id" name="id"
					placeholder="john@okicici" class="form-control text-center"
					type="text" />
			</div>
			<div class="col-md-4 col-sm-6 text-center" style="margin-top: 20px; margin-left:30%">
				<input type="submit" id="save" value="Generate Bill" name="save"
					class="btn btn-large btn-success" >
			</div>
		</div>

	</form>
</section>