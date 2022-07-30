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
<!-- Styles -->
<style>
html, body {
	background-color: #fff;
	color: #636b6f;
	font-family: 'Raleway', sans-serif;
	font-weight: 100;
	height: 100vh;
	margin: 0;
}
.full-height {
	height: 100vh;
}
.flex-center {
	align-items: center;
	display: flex;
	justify-content: center;
}
.position-ref {
	position: relative;
}
.top-right {
	position: absolute;
	right: 10px;
	top: 18px;
}
.content {
	text-align: center;
}
.title {
	font-size: 30px;
}
.links>a {
	color: #636b6f;
	padding: 0 25px;
	font-size: 12px;
	font-weight: 600;
	letter-spacing: .1rem;
	text-decoration: none;
	text-transform: uppercase;
}
.m-b-md {
	margin-bottom: 30px;
}
</style>

<title>
	<% 
String titel = (String) request.getAttribute("titel");
out.println(titel); %>
</title>
</head>
<body>
	<div class="container">
			<%@ include file="layouts/header.jsp"%>
		<div class="row">
			<div class="col-md-4 col-md-offset-3">
				<div class="title m-b-md">E_commerce Manager Project</div>
			</div>
			<c:if test="${ !empty success }">
					<div class="alert alert-success" role="alert">${success }</div>
				</c:if>
				
			
			<div class="links">
				<a href="#">Facebook</a>
				<a href="#">Tweeter</a>
				<a href="#">Instegram</a>
				<a href="#">Google</a>
				<a href="#">LinkedIn</a>
				<a href="#">GitHub</a>
			</div>
		</div>
				<%@ include file="layouts/footer.jsp"%>
	</div>
	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
</body>
</html>