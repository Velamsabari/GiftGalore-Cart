<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="CR"
	value="${pageContext.request.contextPath}/resources/pimages" />

<link
	href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css"
	rel="stylesheet">
<style>
.table>tbody>tr>td, .table>tfoot>tr>td {
	vertical-align: middle;
}

@media screen and (max-width: 600px) {
	table#cart tbody td .form-control {
		width: 20%;
		display: inline !important;
	}
	.actions .btn {
		width: 36%;
		margin: 1.5em 0;
	}
	.actions .btn-info {
		float: left;
	}
	.actions .btn-danger {
		float: right;
	}
	table#cart thead {
		display: none;
	}
	table#cart tbody td {
		display: block;
		padding: .6rem;
		min-width: 320px;
	}
	table#cart tbody tr td:first-child {
		background: #333;
		color: #fff;
	}
	table#cart tbody td:before {
		content: attr(data-th);
		font-weight: bold;
		display: inline-block;
		width: 8rem;
	}
	table#cart tfoot td {
		display: block;
	}
	table#cart tfoot td .btn {
		display: block;
	}
	.img-responsive {
		height: 100px;
		width: 100px;
	}
}
</style>

<div class="container">
	<c:if test="${empty(cartlist)}">
		<h2 class="jumbotron">Cart Is Empty</h2>
		<a href="${contextRoot}/products" class="btn button"><i
			class="fa fa-angle-left"></i> Continue Shopping</a>
	</c:if>
	<c:if test="${!empty(cartlist)}">
		<table id="cart" class="table table-hover table-condensed">
			<thead>
				<tr>
					<th style="width: 50%">Product</th>
					<th style="width: 10%">Price</th>
					<th style="width: 8%">Quantity</th>
					<th style="width: 22%" class="text-center">Subtotal</th>
					<th style="width: 10%"></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${cartlist}" var="l">
					<tr>
						<td data-th="Product">
							<div class="row">
								<div class="col-sm-2 hidden-xs">
									<img src="${CR}/${l.pid}.jpg" alt="..."
										class="img-responsive" />
								</div>
								<div class="col-sm-10">
									<h4 class="nomargin">${l.product_Name}</h4>
								</div>
							</div>
						</td>
						<td data-th="Price">${l.price}</td>
						<td data-th="Quantity"><input type="number"
							class="form-control text-center" value="${l.quantity}"></td>
						<td data-th="Subtotal" class="text-center">${l.total}</td>
						<td class="actions" data-th="">
							<button class="btn btn-info btn-sm">
								<i class="fa fa-refresh"></i>
							</button>
							<button class="btn btn-danger btn-sm">
								<i class="fa fa-trash-o"></i>
							</button>
						</td>
					</tr>
					</c:forEach>
			</tbody>
			<tfoot>
				<tr>
					<td><a href="#" class="btn btn-warning"><i
							class="fa fa-angle-left"></i> Continue Shopping</a></td>
					<td/>
					<td/>
					<td/>
					<td><a href="#" class="btn btn-success btn-block">Checkout
							<i class="fa fa-angle-right"></i>
					</a></td>
					
				</tr>
			</tfoot>
		</table>
	</c:if>
</div>