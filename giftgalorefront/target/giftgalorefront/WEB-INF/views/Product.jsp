<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<c:set var="CR" value="${pageContext.request.contextPath}/resources/pimages" />
<c:set var="cr2" value="${pageContext.request.contextPath}/admin"/>
<style>
body {
	font-family: Arial, Helvetica, sans-serif;
}

input[type=text], input[type=password], .mystyle {
	width: 100%;
	padding: 15px;
	margin: 5px 0 22px 0;
	display: inline-block;
	border: none;
	background: #f1f1f1;
	
}

/* Add a background color when the inputs get focus */
input[type=text]:focus, input[type=password]:focus, .mystyle:focus {
	background-color: #ddd;
	outline: none;
}

#justpushtobottom {
	height: 5%;
}
</style>
<script type="text/javascript">
	$(document).ready(function() {

		$('#table_id').dataTable({

			"pagingType" : "full_numbers",

			"lengthMenu" : [ [ 2, 5, 10, -1 ], [ 2, 5, 10, "All" ] ],

			"ordering" : true,

		});

	});
</script>

<c:if test="${edit}">
	<c:url var="url" value="updateproduct"></c:url>
</c:if>
<c:if test="${!edit}">
	<c:url var="url" value="addproduct"></c:url>
</c:if>

<div class="container">

	<form:form modelAttribute="Product" action="${url}"
		enctype="multipart/form-data">
		<div class="container">
			<h1>PRODUCT</h1>
			<hr>
			<c:if test="${edit}">

				<div>
					<label for="name"><b>Product ID</b></label>
					<form:input type="text" path="product_id" readonly="true" />
				</div>
			</c:if>
			<div>
				<label for="name"><b>Product Name</b></label>
				<form:input type="text" placeholder="Enter Product Name" name="name"
					path="product_Name" />
				<form:errors path="product_Name" cssStyle="color:Red" />
			</div>
			<div>
				<label for="number"><b>Product Description</b></label>
				<form:input type="text" placeholder="Enter Product Description"
					name="desc" path="productDesc" />
				<form:errors path="productDesc" cssStyle="color:Red" />
			</div>
			<div>
				<label for="email"><b>Category</b></label>
				<form:select path="category.category_id" class="mystyle">
					<c:forEach items="${catlist}" var="c">
						<form:option value="${c.category_id}">${c.category_Name}</form:option>
					</c:forEach>
				</form:select>
				<form:errors path="category" cssStyle="color:Red" />
			</div>
			<div>
				<label for="psw"><b>Quantity</b></label>
				<form:input type="text" placeholder="Enter Quantity" name="qty"
					path="quantity" />
				<form:errors path="quantity" cssStyle="color:Red" />
			</div>
			<div>
				<label for="psw"><b>Price</b></label>
				<form:input type="text" placeholder="Enter Price" name="price"
					path="price" />
				<form:errors path="price" cssStyle="color:Red" />

				<form:input type="file" path="pimage" class="mystyle" />
			</div>
			<c:if test="${!edit}">
				<div class="clearfix">
					<input type="submit" class="btn btn-info" value="Add Product">
				</div>
			</c:if>
			<c:if test="${edit}">
				<div class="clearfix">
					<input type="submit" class="btn btn-info" value="Update Product">
				</div>
			</c:if>
		</div>
	</form:form>

	<div class="table-responsive" style="padding-top: 20px">
		<table id="table_id" name="table_id" class="display"
			style="padding-top: 20px">
			<thead>
				<tr>
					<th>PRODUCT IMAGE</th>
					<th>PRODUCT ID</th>
					<th>PRODUCT NAME</th>
					<th>PRODUCT DESCRIPTION</th>
					<th>CATEGORY</th>
					<th>QUANTITY</th>
					<th>PRICE</th>
					<th>EDIT</th>
					<th>DELETE</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${prodlist}" var="l">
					<tr>
						<td><img src="${CR}/${l.product_id}.jpg" height="50px" width="50px"></td>
						<td>${l.product_id}</td>
						<td>${l.product_Name}</td>
						<td>${l.productDesc}</td>
						<td>${l.category.category_Name}</td>
						<td>${l.quantity}</td>
						<td>${l.price}</td>
						<td><a class='btn btn-success btn-xs'
							href="${cr2}/editproduct?pid=${l.product_id}"><span
								class="glyphicon glyphicon-edit"></span> Edit</a></td>						<td><a class='btn btn-danger btn-xs'
							href="${cr2}/deleteproduct?pid=${l.product_id}"><span
								class="glyphicon glyphicon-trash"></span> Delete</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

	</div>


</div>

