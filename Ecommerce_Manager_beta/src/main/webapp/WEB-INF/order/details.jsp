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
	<style type="text/css">
	
	</style>
<title>Product details</title>
</head>
<body>
	<div class="container">
		<%@ include file="../layouts/header.jsp"%>

		<c:choose>
			<c:when test="${!empty error }">
				<div class="alert alert-danger" role="alert">${ error }</div>
			</c:when>

			<c:when test="${ empty error }">
			</c:when>
		</c:choose>

				<div class="row">
					<div class="col-md-9 col-md-offset-1">
						<h2 class="col-md-offset-3">Product Informations</h2>
						<dl class="row">
							<dt class="col-sm-3">Order ID</dt>
							<dd class="col-sm-9">${ order.id }</dd>

							<dt class="col-sm-3">Client :</dt>
							<dd class="col-sm-9">${ order.client.user.email }</dd>

							<dt class="col-sm-3">Total Price :</dt>
							<dd class="col-sm-9">${ order.totalPrice }</dd>

							<dt class="col-sm-3">Status :</dt>
							<dd class="col-sm-9">${ order.status }</dd>
							
							
							<dt class="col-sm-3">Created at :</dt>
							<dd class="col-sm-9">${ order.createdAt }</dd>
						</dl>
						

						<ul class="list-inline">
							<li class="list-inline-item"><a class="btn btn-primary"
								href="/Ecommerce_Manager_beta/order/edit?id=${ order.id }"
								role="button"><span class="glyphicon glyphicon-edit"></span>&nbsp;Take over</a></li>
								
							<li class="list-inline-item">
								<form action="/Ecommerce_Manager_beta/order/details?id=${ order.id }" method="post">
								<input type="hidden" name="action" value="delete"/>
									<div class="form-group">
										<input class="btn btn-danger" type="submit" value="Delete" />
									</div>
								</form>
							</li>
						</ul>
						
						<h3>Orders Articles</h3>
						<table class="table">
					<thead>
						<tr>
							<th>Article code</th>
							<th>Quantity</th>
							<th>price</th>
							<th>Size</th>
							<th>Color</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${articles }" var="article">
							<tr>
								<td>${article.id }</td>
								<td>${article.price }</td>
								<td>${article.size.sizeName }</td>
								<td>${article.color.colorName }</td>
								<td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<h3>Payment details</h3>
				<table class="table">
				
						<c:forEach items="${paymentDetails }" var="p">
							<tr>
								<td>${p }</td>
							</tr>
						</c:forEach>
					</table>
				</div>
					</div>
				</div>
			
		<%@ include file="../layouts/footer.jsp"%>
	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
</body>
</html>