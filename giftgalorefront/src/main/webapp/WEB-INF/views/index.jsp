<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.min.css">

<script
	src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>
<link rel="shortcut icon" href="${pageContext.request.contextPath}/resources/viewlogo1.ico" />
<title>${title}</title>
</head>
<body>
	<c:import url="Navbar.jsp" />
	<div style="min-height: 530px;">
		<c:if test="${sliderpage}">
			<c:import url="Slider.jsp" />
		</c:if>

		<c:if test="${aboutuspage}">
			<c:import url="Aboutus.jsp" />
		</c:if>

		<c:if test="${contactuspage}">
			<c:import url="Contactus.jsp" />
		</c:if>

		<c:if test="${loginpage}">
			<c:import url="newlof.jsp" />
		</c:if>

		<c:if test="${registerpage}">
			<c:import url="Register.jsp" />
		</c:if>

		<c:if test="${productpage}">
			<c:import url="Product.jsp" />
		</c:if>

		<c:if test="${categorypage}">
			<c:import url="Category.jsp" />
		</c:if>

		<c:if test="${allproductpage}">
			<c:import url="Allproducts.jsp" />
		</c:if>

		<c:if test="${oneproductpage}">
			<c:import url="oneproduct.jsp" />
		</c:if>
		
		<c:if test="${cartpage}">
			<c:import url="cart.jsp" />
		</c:if>
		
		<c:if test="${addresspage}">
			<c:import url="Address.jsp" />
		</c:if>
		<c:if test="${orderpage}">
			<c:import url="Order.jsp" />
		</c:if>
		<c:if test="${billpage}">
			<c:import url="Invoice.jsp" />
		</c:if>
	</div>
	<c:import url="Footer.jsp" />

</body>
</html>
