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
	

<title>Articles Table</title>
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
				<h2>Articles Table</h2>
				
				<table class="table">
					<thead>
						<tr>
							<th>Article code</th>
							<th>Product</th>
							<th>Price</th>
							<th>Quantity</th>
							<th>Category</th>
							<th>Size</th>
							<th>Color</th>

						</tr>
					</thead>
					<tbody>
						<c:forEach items="${articles }" var="a">
							<tr>
								<td>${a.id }</td>
								<td><a
									href="/Ecommerce_Manager_beta/product/details?id=${a.product.id }">${a.product.name }</a></td>
								<td>${a.price }</td>
								<td>${a.quantity }</td>
								<td>${a.product.category.name }</td>
								<td>${a.size.sizeName }</td>
								<td>${a.color.colorName }</td>
								<td><a
									href="/Ecommerce_Manager_beta/article/details?id=${a.id }">Details</a></td>
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