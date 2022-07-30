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
	

<title>Sizes</title>
</head>
<body>
	<div class="container">
		<%@ include file="../layouts/header.jsp"%>
		<c:choose>
			<c:when test="${!empty error }">
				<div class="alert alert-danger" role="alert">${ error }</div>
			</c:when>
			<c:when test="${empty error }">
			<c:if test="${!empty success }">
				<div class="alert alert-success" role="alert">${ sessionScope.success }<span class="glyphicon glyphicon-ok"></span></div>
			</c:if>
				<h2>Sizes Table</h2>
				<a class="btn btn-primary float-right" href="/Ecommerce_Manager_beta/size/create"
					role="button"><span class="glyphicon glyphicon-plus"></span> &nbsp;Add New</a>
				<table class="table">
					<thead>
						<tr>
							<th>Id Size</th>
							<th>Name</th>
							<th>Sign</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${sizes }" var="size">
							<tr>
								<td>${size.id }</td>
								<td>${size.sizeName }</td>
								<td>${size.sign }</td>
								<td><a
									href="/Ecommerce_Manager_beta/size/details?id=${size.id }">Details</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</c:when>
		</c:choose>
		<%@ include file="../layouts/footer.jsp"%>
	</div>
	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>

</body>
</html>