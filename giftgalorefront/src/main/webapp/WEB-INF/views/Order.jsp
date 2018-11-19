<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<c:set var="CR"
	value="${pageContext.request.contextPath}/resources/pimages"/>
<div class="container">
	<div class="row">
		<ol class="breadcrumb">
			<li class="active">Orders</li>
		</ol>
		<c:if test="${empty(orderlist)}">
			<h2 class="jumbotron">No Orders</h2>
			<a href="${contextRoot}/AllProduct" class="btn button"><i
				class="fa fa-angle-left"></i> Get your first order</a>
		</c:if>
		<c:forEach var="o" items="${orderlist}">
			<div class="panel panel-default">
				<div class="panel-heading">
					<a href="${contextRoot}/user/viewbill?orderid=${o.orderid}"
						class="btn button">${o.orderid}</a>
				</div>
				<div class="panel-body">

					<div class="col-md-1">
						<img src="${CR}/${o.pid}.jpg" class="img-responsive" width="50"
							height="50">
					</div>
					<div class="col-md-5">${o.product_Name}</div>
					<div class="col-md-1">${o.quantity}</div>
					<div class="col-md-5">&#8377 ${o.price}</div>

				</div>
				<div class="panel-footer">Ordered on ${o.odate}</div>
			</div>
		</c:forEach>
	</div>
</div>