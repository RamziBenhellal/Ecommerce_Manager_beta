<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<!-- Bootstrap CSS -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet">

<title>Register Demand</title>
</head>
<body>
	<div class="container ">
		<div class="row">
			<div class="col-md-4 col-md-offset-3">

				
				<form action="/Ecommerce_Manager_beta/auth/register_demand" method="post">
					<h3 class="col-md-offset-3">Register demand</h3>
					<c:if test="${ !empty error }">
					<div class="alert alert-danger" role="alert">${error }</div>
				    </c:if>
					<div class="form-group ">
						<label for="email">Email : </label> <input type="text"
							class="form-control" id="email" name="email"
							placeholder="Your Email">
					</div>
					<div class="form-group">
						<label for="category">Priority : </label> <select
							class="form-control" id="priority" name="priority">
								<option value="1">Order manager </option>
								<option value="2">Marketing </option>
								<option value="3">Administrator </option>
						</select>
					</div>
					
					<div class="form-group">
						<input type="submit" class="form-control btn btn-info" value="Send register request">
					</div>
				</form>
			</div>
		</div>
		<%@include file="../layouts/footer.jsp"%>
	</div>
	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
</body>
</html>