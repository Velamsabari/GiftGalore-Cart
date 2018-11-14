<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<c:set var="cr1" value="${pageContext.request.contextPath}/admin"/>
<style>
body {
	font-family: Arial, Helvetica, sans-serif;
}

/* Full-width input fields */
input[type=text], input[type=password] {
	width: 100%;
	padding: 15px;
	margin: 5px 0 22px 0;
	display: inline-block;
	border: none;
	background: #f1f1f1;
}

/* Add a background color when the inputs get focus */
input[type=text]:focus, input[type=password]:focus {
	background-color: #ddd;
	outline: none;
}

#justpushtobottom {
	height: 5%;
}
/* Add padding to container elements */
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
	<c:url var="url" value="updatecategory"></c:url>
</c:if>
<c:if test="${!edit}">
	<c:url var="url" value="addcategory"></c:url>
</c:if>
<div class="container">
	<form:form modelAttribute="Category" method="post" action="${url}">
		<h1>CATEGORY</h1>
		<hr>
		<c:if test="${edit}">
			<div>
				<label for="email"><b>Category ID</b></label>
				<form:input type="text" path="category_id" readonly="true" />
			</div>


		</c:if>

		<div>
			<label for="email"><b>Category Name</b></label>
			<form:input type="text" placeholder="Enter Category Name"
				name="category name" path="category_Name" />
			<form:errors path="category_Name" cssStyle="color:Red" />
		</div>
		<div>
			<label for="psw"><b>Category Description</b></label>
			<form:input type="text" placeholder="Enter Category Description"
				name="desc" path="categoryDesc" />
			<form:errors path="categoryDesc" cssStyle="color:Red" />
		</div>
		<c:if test="${edit}">
			<div class="clearfix">
				<input type="submit" class="btn btn-info" value="Update Category">
			</div>
		</c:if>
		<c:if test="${!edit}">
			<div class="clearfix">
				<input type="submit" class="btn btn-info" value="Add Category">
			</div>
		</c:if>

	</form:form>
	<div class="table-responsive">
		<table id="table_id" name="table_id" class="display"
			style="padding-top: 20px">
			<thead>
				<tr>
					<th>CATEGORY ID</th>
					<th>CATEGORY NAME</th>
					<th>CATEGORY DESCRIPTION</th>
					<th>EDIT</th>
					<th>DELETE</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${catlist}" var="l">
					<tr>
						<td>${l.category_id}</td>
						<td>${l.category_Name}</td>
						<td>${l.categoryDesc}</td>
						<td><a class='btn btn-success btn-xs'
							href="${cr1}/editcategory?cid=${l.category_Name}"><span
								class="glyphicon glyphicon-edit"></span> Edit</a></td>
						<td><a class='btn btn-danger btn-xs'
							href="${cr1}/deletecategory?cid=${l.category_Name}"><span
								class="glyphicon glyphicon-trash"></span> Delete</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

	</div>
</div>

