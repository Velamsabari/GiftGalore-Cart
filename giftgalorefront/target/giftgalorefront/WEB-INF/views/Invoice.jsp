<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />

<c:set var="CR"
	value="${pageContext.request.contextPath}/resources/pimages" />

<div class="row">
	<div class="col-lg-8 col-md-8 col-sm-8 col-lg-offset-2">
		<div class="panel panel-default main">
			<div class="panel-body">
				<div class="row">
					<h1 class="text-center">Invoice</h1>
				</div>
				<!--row-->
				<hr>
				<div class="row">
					<div class="col-lg-8 col-md-8 col-sm-8">
						<p class="offset-margin">${address.name}</p>
						<p class="offset-margin">${address.addline1 },${address.addline2 },</p>
						<p class="offset-margin">${address.city},</p>
						<p class="offset-margin">${address.state}-${address.pincode}</p>

					</div>
					<div class="col-lg-4 col-md-4 col-sm-4">
						<p>
							<label>Order#:</label> ${order.orderid}
						</p>
						<p>
							<label>Order Date:</label>${order.odate}</p>

					</div>
				</div>
				<!--row-->


				<div class="row">
					<div
						class="col-lg-10 col-md-10 col-sm-10 col-lg-offset-1 col-md-offset-1 col-sm-offset-1 content">
						<div class="panel panel-default">
							<!--<div class="panel-heading">-->
							<!--    <h1 class="panel-title">Invoice Details</h1>-->
							<!--</div>-->
							<div class="panel-body">
								<div class="row">
									<div class=" col-lg-12 col-md-12 col-sm-12 description">
										<table class="table">
											<thead>
												<tr>
													<th></th>
													<th>Product Name</th>
													<th>Qty</th>
													<th>Price</th>
												</tr>
											</thead>
											<tbody>
												<tr>

													<td><img src="${CR}/${order.pid}.jpg"
														class="img-responsive" width="50" height="50"></td>
													<td>${order.product_Name}</td>
													<td>${order.quantity}</td>
													<td>${order.price}</td>
												</tr>
											</tbody>
										</table>
									</div>

									<div class="col-lg-8 pull-left"
										style="border-top: solid #ddd 1px;"></div>

									<div class="col-lg-4 col-md-4 col-sm-4 pull-right blank">

										<table class="table table bordered">
											<tbody>
												<tr>
													<td><label>Total:</label><span class="pull-right">&#8377
															${order.price}</span></td>
												</tr>
											</tbody>
										</table>

									</div>
								</div>
								<!--row-->

							</div>

						</div>

						<a href="${contextRoot}/user/viewOrders" class="btn button"><i
							class="fa fa-angle-left"></i> Back to Orders Page</a>
					</div>
				</div>


			</div>

		</div>
	</div>
</div>