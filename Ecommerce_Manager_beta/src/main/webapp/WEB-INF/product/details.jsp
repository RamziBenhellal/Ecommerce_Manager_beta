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

				<div class="row">
					<div class="col-md-9 col-md-offset-1">
						<h2 class="col-md-offset-3">Product Informations</h2>
						<dl class="row">
							<dt class="col-sm-3">Product Name</dt>
							<dd class="col-sm-9">${ product.name }</dd>

							<dt class="col-sm-3">Mark :</dt>
							<dd class="col-sm-9">${ product.mark }</dd>

							<dt class="col-sm-3">Description :</dt>
							<dd class="col-sm-9">${ product.description }</dd>

							<dt class="col-sm-3">Price :</dt>
							<dd class="col-sm-9">${ product.price }</dd>
							
							<dt class="col-sm-3">Quantity :</dt>
							<dd class="col-sm-9">${ product.quantity }</dd>
							
							<dt class="col-sm-3">Category :</dt>
							<dd class="col-sm-9">${ product.category.name }</dd>
							
							<dt class="col-sm-3">Created at :</dt>
							<dd class="col-sm-9">${ product.createdAt }</dd>
						</dl>
						<c:forEach items="${images }" var="img">
						
                       <a target="_blank" href="#">
						<img src="data:image/jpg;base64,${img}" width="240" height="300"/>
						</a>
						</c:forEach>

						<ul class="list-inline">
							<li class="list-inline-item"><a class="btn btn-primary"
								href="/Ecommerce_Manager_beta/product/edit?id=${ product.id }"
								role="button"><span class="glyphicon glyphicon-edit"></span>&nbsp;Edit</a></li>
							<li class="list-inline-item"><a class="btn btn-primary"
								href="/Ecommerce_Manager_beta/image/add?id=${ product.id }&item=product"
								role="button"><span class="glyphicon glyphicon-edit"></span>&nbsp;Add image</a></li>	
							<li class="list-inline-item">
								<form action="/Ecommerce_Manager_beta/product/details?id=${ product.id }" method="post">
								<input type="hidden" name="action" value="delete"/>
									<div class="form-group">
										<input class="btn btn-danger" type="submit" value="Delete" />
									</div>
								</form>
							</li>
						</ul>
						
						<h3>Products Articles</h3>
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
								<td>${article.quantity }</td>
								<td>${article.price }</td>
								<td>${article.size.sizeName }</td>
								<td>${article.color.colorName }</td>
								<td><a
									href="/Ecommerce_Manager_beta/article/details?id=${article.id }">Details</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				
				<div class="col-md-4 col-md-offset-3">
				<c:if test="${ !empty error }">
					<div class="alert alert-danger" role="alert">${error }</div>
				</c:if>
				</div>
				<h3 class="col-md-offset-12">Create New Article</h3>
				<form action="/Ecommerce_Manager_beta/product/details?id=${product.id}" method="post">
					
					<div class="form-group ">
						<label for="quantity">Quantity : </label> <input type="number"
							class="form-control" id="quantity" name="quantity"
							placeholder="Price of product">
					</div>
					<div class="form-group ">
						<label for="reduction">Price : </label> <input type="text"
							class="form-control" id="price" name="price"
							placeholder="Reduction Price">
					</div>
					<div class="form-group">
						<label for="size">Size : </label> <select
							class="form-control" id="size" name="size">
							<c:forEach items="${sizes }" var="size">
								<option value="${size.id }">${size.sizeName } </option>
							</c:forEach>
						</select>
					</div>
					<div class="form-group">
						<label for="color">Color : </label> <select
							class="form-control" id="color" name="color">
							<c:forEach items="${colors }" var="color">
								<option value="${color.id }">${color.colorName } </option>
							</c:forEach>
						</select>
					</div>
					<div class="form-group">
						<input type="submit" class="form-control" value="Save">
					</div>
				</form>
			</div>
					</div>
				</div>
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