<!DOCTYPE html>
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

<title>New Mail</title>
</head>
<body>
	<div class="container ">

		<%@include file="../layouts/header.jsp"%>

		<div class="row">
			<div class="col-md-12 col-md-offset-12">

				<c:if test="${ !empty error }">
					<div class="alert alert-danger" role="alert">${error }</div>
				</c:if>
				<form action="/Ecommerce_Manager_beta/mail/create" method="post">
					<h3 class="col-md-offset-3">New mail</h3>
					<div class="form-group ">
						<label for="recipient">To : </label> <input type="text"
							class="form-control" id="recipient" name="recipient"
							placeholder="Recipient Email">
					</div>
					
					<div class="form-group ">
						<label for="subject">Subject : </label> <input type="text"
							class="form-control" id="subject" name="subject"
							placeholder="Subject">
					</div>
					
					<div class="form-group ">
						 <textarea class="form-control" id="text" name="text"
							placeholder="Mail body" rows="10" cols="80" maxlength="100"></textarea>
							
					</div>
					
					<div class="form-group">
						<input type="submit" class="form-control" value="Send">
					</div>
				</form>
			</div>
		</div>
		<%@include file="../layouts/footer.jsp"%>
	</div>
	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="https://cdn.ckeditor.com/4.5.11/standard/ckeditor.js"></script>
	<script>
   CKEDITOR.replace('text');
  </script>
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
</body>
</html>