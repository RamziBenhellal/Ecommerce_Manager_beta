<nav class="navbar navbar-expand-lg navbar-light bg-light">
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarTogglerDemo03" aria-controls="navbarTogglerDemo03"
		aria-expanded="false" aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>
	<a class="navbar-brand" href="/Ecommerce_Manager_beta/home">E_commerce
		Manager</a>

	<div class="collapse navbar-collapse" id="navbarTogglerDemo03">
		<ul class="navbar-nav mr-auto mt-2 mt-lg-0">


			<c:if test="${!empty  sessionScope.admin }">
				<c:choose>
					<c:when test="${ sessionScope.admin.priority == 3  }">
						<li class="nav-item active"><a class="nav-link"
							href="/Ecommerce_Manager_beta/home">Home <span class="sr-only">(current)</span>
						</a></li>
						<li class="nav-item"><a class="nav-link"
							href="/Ecommerce_Manager_beta/product/index">Products</a></li>
						<li class="nav-item"><a class="nav-link"
							href="/Ecommerce_Manager_beta/article/index">Articles</a></li>
						<li class="nav-item"><a class="nav-link"
							href="/Ecommerce_Manager_beta/category/index">Categories</a></li>
						<li class="nav-item"><a class="nav-link"
							href="/Ecommerce_Manager_beta/size/index">Sizes</a></li>
						<li class="nav-item"><a class="nav-link"
							href="/Ecommerce_Manager_beta/color/index">Colors</a></li>
						<li class="nav-item"><a class="nav-link"
							href="/Ecommerce_Manager_beta/order/index">Orders</a></li>
						<li class="nav-item"><a class="nav-link"
							href="/Ecommerce_Manager_beta/user/index">Users</a></li>
						<li class="nav-item"><a class="nav-link"
							href="/Ecommerce_Manager_beta/admin/index">Admins</a></li>	
						<li class="nav-item"><a class="nav-link"
							href="/Ecommerce_Manager_beta/mail/index">Mail</a></li>	
					</c:when>
					<c:when test="${ sessionScope.admin.priority == 2  }">
						<li class="nav-item active"><a class="nav-link"
							href="/Ecommerce_Manager_beta/home">Home <span class="sr-only">(current)</span>
						</a></li>
						<li class="nav-item"><a class="nav-link"
							href="/Ecommerce_Manager_beta/product/index">Products</a></li>
						<li class="nav-item"><a class="nav-link"
							href="/Ecommerce_Manager_beta/article/index">Articles</a></li>
						<li class="nav-item"><a class="nav-link"
							href="/Ecommerce_Manager_beta/category/index">Categories</a></li>
						<li class="nav-item"><a class="nav-link"
							href="/Ecommerce_Manager_beta/size/index">Sizes</a></li>
						<li class="nav-item"><a class="nav-link"
							href="/Ecommerce_Manager_beta/color/index">Colors</a></li>
						<li class="nav-item"><a class="nav-link"
							href="/Ecommerce_Manager_beta/order/index">Orders</a></li>
						<li class="nav-item"><a class="nav-link"
							href="/Ecommerce_Manager_beta/mail/index">Mail</a></li>	

					</c:when>
					<c:when test="${ sessionScope.admin.priority == 1  }">
						<li class="nav-item active"><a class="nav-link"
							href="/Ecommerce_Manager_beta/home">Home <span class="sr-only">(current)</span>
						</a></li>
						<li class="nav-item"><a class="nav-link"
							href="/Ecommerce_Manager_beta/order/index">Orders</a></li>
						<li class="nav-item"><a class="nav-link"
							href="/Ecommerce_Manager_beta/mail/index">Mail</a></li>	
					</c:when>
				</c:choose>
			</c:if>
		</ul>


		<ul class="nav navbar-nav navbar-right">

			<c:if test="${ sessionScope.admin.priority == 3 }">
				<li><a href="/Ecommerce_Manager_beta/auth/register"><span
						class="glyphicon glyphicon-collapse-up"></span> Register an admin</a></li>
			</c:if>
			<c:if test="${!empty  sessionScope.admin }">
				<li><a href="/Ecommerce_Manager_beta/admin/edit"><span class="glyphicon glyphicon-user"></span>
						${ sessionScope.admin.email }</a></li>
				<li><a href="/Ecommerce_Manager_beta/auth/logout"><span
						class="glyphicon glyphicon-log-out"></span> Logout</a></li>
			</c:if>
		</ul>
	</div>
</nav>


