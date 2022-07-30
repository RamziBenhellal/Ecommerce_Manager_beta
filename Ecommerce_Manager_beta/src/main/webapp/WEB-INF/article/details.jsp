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
<title>Article details</title>
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
						<h2 class="col-md-offset-3">ArticleInformations</h2>
						<dl class="row">
							<dt class="col-sm-3">Article code :</dt>
							<dd class="col-sm-9">${ article.id }</dd>

							<dt class="col-sm-3">Product :</dt>
							<dd class="col-sm-9"><a href="/Ecommerce_Manager_beta/product/details?id=${article.product.id }">${ article.product.name }</a></dd>

							<dt class="col-sm-3">Price :</dt>
							 <dd class="col-sm-9">${article.price }</dd>

							<dt class="col-sm-3">Quantity :</dt>
							<dd class="col-sm-9">${ article.quantity }</dd>
							
							<dt class="col-sm-3">Category :</dt>
							<dd class="col-sm-9">${ article.product.category.name }</dd>
							
							<dt class="col-sm-3">size :</dt>
							<dd class="col-sm-9">${ article.size.sizeName }</dd>
							
							<dt class="col-sm-3">color :</dt>
							<dd class="col-sm-9">${ article.color.colorName }</dd>
						</dl>
						
						<c:forEach items="${images }" var="img">
						
                       <a target="_blank" href="#">
						<img src="data:image/jpg;base64,${img}" width="240" height="300"/>
						</a>
						</c:forEach>

						<ul class="list-inline">
							<li class="list-inline-item"><a class="btn btn-primary"
								href="/Ecommerce_Manager_beta/article/edit?id=${ article.id }"
								role="button"><span class="glyphicon glyphicon-edit"></span>&nbsp;Edit</a></li>
							<li class="list-inline-item"><a class="btn btn-primary"
								href="/Ecommerce_Manager_beta/image/add?id=${ article.id }&item=article"
								role="button"><span class="glyphicon glyphicon-edit"></span>&nbsp;Add image</a></li>	
							<li class="list-inline-item">
								<form
									action="/ecommerce_manager/article/details?id=${ article.id }"
									method="post">
									<div class="form-group">
										<input class="btn btn-danger" type="submit" value="Delete" />
									</div>
								</form>
							</li>
						</ul>
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