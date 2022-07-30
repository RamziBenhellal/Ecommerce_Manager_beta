<!DOCTYPE html>
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

<title>Edit Article</title>
</head>
<body>
	<div class="container ">

		<%@include file="../layouts/header.jsp"%>

		<div class="row">
			<div class="col-md-4 col-md-offset-3">

				<c:if test="${ !empty error }">
					<div class="alert alert-danger" role="alert">${error }</div>
				</c:if>
				<form action="/Ecommerce_Manager_beta/article/edit?id=${ article.id }" method="post">
					<h3 class="col-md-offset-3">Edit Article Informations </h3>
					<div class="col-md-9 col-md-offset-1">
						<h5 class="col-md-offset-3">Product Informations</h5>
						<dl class="row">
							<dt class="col-sm-6">Product Name</dt>
							<dd class="col-sm-9">${ article.product.name }</dd>

							<dt class="col-sm-6">Mark :</dt>
							<dd class="col-sm-9">${ article.product.mark }</dd>

							<dt class="col-sm-6">Price :</dt>
							<dd class="col-sm-9">${ article.product.price }</dd>
							
							<dt class="col-sm-6">Quantity :</dt>
							<dd class="col-sm-9">${ article.product.quantity }</dd>
							
							<dt class="col-sm-6">Category :</dt>
							<dd class="col-sm-9">${ article.product.category.name }</dd>

						</dl>
						</div>
					
					<div class="form-group ">
						<label for="quantity">quantity : </label> <input type="text"
							class="form-control" id="quantity" name="quantity" value="${article.quantity }"
							placeholder="Quantity">
					</div>
					<div class="form-group">
						<label for="reduction_price">Price : </label> <input type="text"
							class="form-control" id="price" name="price" value="${article.price }"
							placeholder="Price">
					</div>
					<div class="form-group">
						<label for="module">Size : </label> <select
							class="form-control" id="size" name="size">
							<option value="${article.size.id }">${article.size.sizeName }</option>
							<c:forEach items="${sizes }" var="size">
								<option value="${size.id }">${size.sizeName }</option>
							</c:forEach>
						</select>
					</div>
					<div class="form-group">
						<label for="tclass">Color : </label> <select
							class="form-control" id="color" name="color">
							<option value="${article.color.id }">${article.color.colorName }</option>
							<c:forEach items="${colors }" var="c">
								<option value="${c.id }">${c.colorName }</option>
							</c:forEach>
						</select>
					</div>
					<div class="form-group">
						<input type="submit" class="form-control" value="Save">
					</div>
				</form>
			</div>
		</div>
		<%@include file="../layouts/footer.jsp"%>
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