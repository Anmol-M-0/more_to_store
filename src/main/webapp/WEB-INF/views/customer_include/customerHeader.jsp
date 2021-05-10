
	<nav class="navbar navbar-default navbar-inverse" role="navigation">
		<div class="container-fluid">
			
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="/">More to Store</a>
			</div>
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<form class="navbar-form navbar-left" role="search">
					<div class="col form-group">
						<input type="text" class="form-control " placeholder="Search">
					</div>
					<button type="submit" class="btn btn-default">Search</button>
				</form>
				<ul class="nav navbar-nav navbar-right">

					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown"><b>Login</b> <span class="caret"></span></a>
						<ul id="login-dp" class="dropdown-menu">
							<li>
								<div class="row">
									<div class="col-md-12">

										<form class="form" role="form" method="post"
											accept-charset="UTF-8" id="login-nav">
											<h1> Login Form</h1>
											<p
												style="color: red; background-color: white; margin-right: 15px; margin-left: 15px;">${requestScope.message}</p>
											<div class="form-group">
												<label class="sr-only" for="email">Email address</label> <input
													type="email" class="form-control" id="email" name="email"
													placeholder="Email address" required>
											</div>
											<div class="form-group">
												<label class="sr-only" for="password">Password</label> <input
													type="password" class="form-control" id="password"
													name="password" placeholder="Password" required>
												<div class="help-block text-right">
													<a href="">Forget the password ?</a>
												</div>
											</div>
											<div class="form-group">
												<button type="submit" class="btn btn-primary btn-block">Sign
													in</button>
											</div>
											<div class="checkbox">
												<label> <input type="checkbox"> keep me
													logged-in
												</label>
											</div>
										</form>
									</div>
									<div class="bottom text-center">
										New here ? <a href="#"><b>Register</b></a>
									</div>
								</div>
							</li>
						</ul></li>
				</ul>
			</div>
		</div>
	</nav>