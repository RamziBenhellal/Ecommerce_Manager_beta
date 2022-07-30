<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<link
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css"
	rel="stylesheet">
<title>Login</title>
</head>
<body>

	<div class="row">
		<div class="col-md-4 col-md-offset-3">
			<h2 class="col-md-offset-4">Log In</h2>
			<c:if test="${ !empty error }">
				<div class="alert alert-danger" role="alert">${error }</div>
			</c:if>
			<c:if test="${!empty cookieusername }">
				<p>Are you ${ cookieusername }</p>
			</c:if>
			<form action="/Ecommerce_Manager_beta/auth/login" method="post">
			<c:if test="${ !empty success }">
				<div class="alert alert-danger" role="alert">${success }</div>
			</c:if>
				<div class="form-group">
					<label for="email"> Username or email :</label> <input type="text"
						class="form-control" id="email" name="email"
						placeholder="Your Username or Email ">
				</div>
				<div class="form-group">
					<label for="password"> password :</label> <input type="password"
						class="form-control" id="password" name="password"
						placeholder="Your Password">
						</div>
					<div class="form-group">
						<input type="submit" class="form-control btn btn-info" value="Login">
					</div>
				
			</form>
			No Account? <a href="/Ecommerce_Manager_beta/auth/register_demand">Send request for register</a>
		</div>
	</div>
	<%@include file="../layouts/footer.jsp"%>

	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
</body>
</html>