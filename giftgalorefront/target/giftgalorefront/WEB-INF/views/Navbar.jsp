<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextroot" value="${pageContext.request.contextPath}"></c:set>
<style>
.navbar {
	background-color: #15cdc7;
	border-color: #15cdc7;
}

.nav.navbar-nav li a {
	color: #6C3483;
	font-size: 18px;
}
</style>
<nav class="navbar navbar-default">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
				aria-expanded="false">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="#"><img
				src="${contextroot}/resources/viewlogo1.png" alt="GIFT GALORE"
				height="50px" width="70px"></a>
		</div>
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<c:choose>
				<c:when test="${sessionScope.userlogin==true}">
					<ul class="nav navbar-nav ">
						<li><a href="${contextroot}/home"><span
								class="glyphicon glyphicon-home"></span>Home</a></li>

						<li><a href="${contextroot}/Aboutus"><span
								class="glyphicon glyphicon-file"></span>About Us</a></li>
						<li><a href="${contextroot}/Contactus"><span
								class="glyphicon glyphicon-envelope"></span>Contact Us</a></li>
						<li><a href="${contextroot}/AllProduct"><span
								class="glyphicon glyphicon-list"></span>Products</a></li>
					</ul>
					<ul class="nav navbar-nav navbar-right">
						<li><a href=""><span class="glyphicon glyphicon-user"></span>Welcome!! ${sessionScope.username}</a></li>
						<li><a href=""><span class="glyphicon">&#xe116;</span></a></li>
						<li><a href="${contextroot}/logout"><span class="glyphicon glyphicon-log-out"></span>
								Logout </a></li>
					</ul>
				</c:when>
				<c:when test="${sessionScope.userlogin==false}">
					<ul class="nav navbar-nav ">
						<li><a href="${contextroot}/home"><span
								class="glyphicon glyphicon-home"></span>Home</a></li>
						<li><a href="${contextroot}/Aboutus"><span
								class="glyphicon glyphicon-file"></span>About Us</a></li>
						<li><a href="${contextroot}/Contactus"><span
								class="glyphicon glyphicon-envelope"></span>Contact Us</a></li>
						<li><a href="${contextroot}/admin/Product"><span
								class="glyphicon glyphicon-th-list"></span>Product</a></li>
						<li><a href="${contextroot}/admin/Category"><span
								class="glyphicon glyphicon-th-list"></span>Category</a></li>
					</ul>
					<ul class="nav navbar-nav navbar-right">
						<li><a href=""><span class="glyphicon glyphicon-user"></span>Welcome!!${sessionScope.username}</a></li>
						<li><a href="${contextroot}/logout"><span class="glyphicon glyphicon-log-out"></span>
								Logout </a></li>
					</ul>
				</c:when>
				<c:otherwise>
					<ul class="nav navbar-nav ">
						<li><a href="${contextroot}/home"><span
								class="glyphicon glyphicon-home"></span>Home</a></li>
						<li><a href="${contextroot}/Aboutus"><span
								class="glyphicon glyphicon-file"></span>About Us</a></li>
						<li><a href="${contextroot}/Contactus"><span
								class="glyphicon glyphicon-envelope"></span>Contact Us</a></li>
						<li><a href="${contextroot}/AllProduct"><span
								class="glyphicon glyphicon-th-list"></span>Products</a></li>
					</ul>
					<ul class="nav navbar-nav navbar-right">
						<li><a href="Register"><span
								class="glyphicon glyphicon-user"></span> Register </a></li>

						<li><a href="Login"><span
								class="glyphicon glyphicon-log-in"></span> Login </a></li>
					</ul>
				</c:otherwise>
			</c:choose>
		</div>
	</div>
</nav>
