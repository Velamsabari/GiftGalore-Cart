<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="cr3" value="${pageContext.request.contextPath}" />
<c:set var="CR"
	value="${pageContext.request.contextPath}/resources/pimages" />

<style>
.thumbnail {
	height: 200;
	width: 350;
	color: #15cdc7;
}

.label {
	display: block;
	width: 320px;
	word-break: break-all;
	background-color: #15cdc7;
	font-color:#6C3483;
}

.btn {
	background-color: #15cdc7;
	color:#6C3483;
}

.list-group {
	margin: auto;
	float: left;
	padding-top: 20px;
}

.lead {
	margin: auto;
	left: 0;
	right: 0;
	padding-top: 10%;
}
.img-responsive
{
height: 100;
width: 100;
}
</style>
<div class="row">
	<div class="col-md-2 col-sm-2 col-xs-12">
		<div class="list-group">
			<a href="${cr3}/AllProduct" class="list-group-item">All Category</a>
			<c:forEach items="${catlist}" var="c">
				<a class="list-group-item"
					href="${cr3}/products?catname=${c.category_Name}">${c.category_Name}</a>
			</c:forEach>
		</div>
	</div>
	<div class="col-md-10 col-sm-2 col-xs-12">
		<c:forEach var="l" items="${prodlist}">
			<div class="col-sm-6 col-md-4">
				<div class="thumbnail">
					<h4 class="text-center">
						<span class="label " style="word-wrap: break-word;">${l.product_Name}</span>
					</h4>
					<img src="${CR}/${l.product_id}.jpg" class="img-responsive">
					<div class="caption">
						<div class="row">
							<div class="col-md-6">
								<h4 class="text-center">&#8377 ${l.price} /-</h4>
							</div>
							<div class="col-md-6">
								<a href='${cr3}/OneProduct?pid=${l.product_id}' class="btn"><span
									class="glyphicon glyphicon-info-sign"></span> Info</a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</c:forEach>
	</div>
</div>
