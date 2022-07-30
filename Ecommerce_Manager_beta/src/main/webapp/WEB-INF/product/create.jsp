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

<title>New Product</title>
</head>
<body>
	<div class="container ">

		<%@include file="../layouts/header.jsp"%>

		<div class="row">
			<div class="col-md-4 col-md-offset-3">

				<c:if test="${ !empty error }">
					<div class="alert alert-danger" role="alert">${error }</div>
				</c:if>
				<form action="/Ecommerce_Manager_beta/product/create" method="post" >
					<h3 class="col-md-offset-3">Create New Product</h3>
					<div class="form-group ">
						<label for="name">Product Name : </label> <input type="text"
							class="form-control" id="name" name="name"
							placeholder="Category Name">
					</div>
					
					<div class="form-group ">
						<label for="mark">Mark : </label> <input type="text"
							class="form-control" id="mark" name="mark"
							placeholder="Mark of product">
					</div>
					
					<div class="form-group ">
						<label for="description">Description : </label> <textarea 
							class="form-control" id="description" name="description"
							placeholder="Description of product"></textarea>
					</div>
					
					<div class="form-group ">
						<label for="price">Price : </label> <input type="text"
							class="form-control" id="price" name="price"
							placeholder="Price of product">
					</div>
					
					
					
					<div class="form-group">
						<label for="category">Category : </label> <select
							class="form-control" id="category" name="category">
							<c:forEach items="${categories }" var="c">
								<option value="${c.id }">${c.name } </option>
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
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
</body>
</html>