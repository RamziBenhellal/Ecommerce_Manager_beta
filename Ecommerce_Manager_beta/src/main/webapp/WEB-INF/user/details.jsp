<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	>
<link
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css"
	rel="stylesheet">
<title>User details</title>
</head>
<body>
	<div class="container">
		<%@ include file="../layouts/header.jsp"%>

		<c:choose>
			<c:when test="${!empty error }">
				<div class="alert alert-danger" role="alert">${ error }</div>
			</c:when>

			<c:when test="${ empty error }">

				<div class="row">
					<div class="col-md-9 col-md-offset-1">
						<h2 class="col-md-offset-3">User Informations</h2>
						<dl class="row">
							<dt class="col-sm-3">User id :</dt>
							<dd class="col-sm-9">${ user.id }</dd>

							<dt class="col-sm-3">Email :</dt>
							<dd class="col-sm-9">${ user.email }</dd>
							
							<dt class="col-sm-3">First name :</dt>
							<dd class="col-sm-9">${ user.account.firstname }</dd>
							
							<dt class="col-sm-3">Last name :</dt>
							<dd class="col-sm-9">${ user.account.lastname }</dd>
							
							<dt class="col-sm-3">Birth date :</dt>
							<dd class="col-sm-9">${ user.account.birthdate }</dd>
							
							<dt class="col-sm-3">Address :</dt>
							<dd class="col-sm-9">${ user.account.address }</dd>
							
							<dt class="col-sm-3">Phone :</dt>
							<dd class="col-sm-9">${ user.account.phone }</dd>
						</dl>
		
					</div>
				</div>
			</c:when>
		</c:choose>

		<%@ include file="../layouts/footer.jsp"%>
	</div>
	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
		></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
		></script>
</body>
</html>