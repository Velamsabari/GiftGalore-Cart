<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<style>
#top-block {
	padding-top: 4px;
}

#bottom-block {
	padding: 15px 20px;
	
	
}

#submitbtn, #resetbtn {
	width: 34.5%;
	margin-right: 4px;
	background-color: #9ccc65;
	color: #ffffff;
	background: linear-gradient(to bottom, #9ccc65 50%, #8bc34a 50%);
}

#paybutton {
	width: 100%;
	margin-right: 4px;
	color: #ffffff;
	background: linear-gradient(to bottom, #15cdc7 50%, #15cdc7 50%);
}

#submitbtn:hover, #resetbtn:hover, #paybutton:HOVER {
	background: linear-gradient(to bottom, #aed581 50%, #9ccc65 50%);
	color: #ffffff;
}

#editlink, #removelink {
	color: #6C3483;
	font-size: 15px;
}

#holder {
	display: inline-block;
	background-color: #ffffff;
	border-radius: 5px;
	box-shadow: 2px 2px 20px #6C3483;
	margin: 10px;
}

.fa fa-truck {
background-color: #ffffff;
}
</style>
<div class="container">
	<div class="row">
		<div class="col-sm-4">
			<c:if test="${edit}">
			<c:url value='/user/updateaddress' var="url"></c:url>
			</c:if>
			<c:if test="${!edit}">
				<c:url value='/user/setaddress' var="url"></c:url>
			</c:if>
			<div class="row col-md-6 col-md-offset-2 custyle">
				<form:form class="form-horizontal" method="post"
					modelAttribute="address" action="${url}">
					<form:hidden path="addressid" />
					<form:hidden path="cartid" />
					<div class="form-group">
						<label class="control-label">Enter Name</label>
						<div class="controls">
							<form:input class="form-control input-xlarge"
								placeholder="Enter Name" path="name" />
							<form:errors path="name" cssStyle="color:red"></form:errors>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label">Enter Address Line 1</label>
						<div class="controls">
							<form:input class="form-control input-xlarge"
								placeholder="Enter Address Line 1" path="addline1" />
							<form:errors path="addline1" cssStyle="color:red"></form:errors>
						</div>
					</div>
					<div class="form-group">
						<label>Enter Address Line 2</label>
						<div class="controls">
							<form:input class="form-control input-xlarge"
								placeholder="Enter Address Line 2" path="addline2" />
							<form:errors path="addline2" cssStyle="color:red"></form:errors>
						</div>
					</div>

					<div class="form-group">
						<label>Enter City</label>
						<div class="controls">
							<form:input class="form-control input-xlarge"
								placeholder="Enter City" path="city" />
							<form:errors path="city" cssStyle="color:red"></form:errors>
						</div>
					</div>

					<div class="form-group">
						<label>Enter State</label>
						<div class="controls">
							<form:input class="form-control input-xlarge"
								placeholder="Enter State" path="state" />
							<form:errors path="state" cssStyle="color:red"></form:errors>
						</div>
					</div>
					<div class="form-group">
						<label>Enter Pincode</label>
						<div class="controls">
							<form:input class="form-control input-xlarge"
								placeholder="Enter Pincode" path="pincode" />
							<form:errors path="pincode" cssStyle="color:red"></form:errors>
						</div>
					</div>

					<div class="form-group">
						<label>Enter Country</label>
						<div class="controls">
							<form:input class="form-control input-xlarge"
								placeholder="Enter Country" path="country" />
							<form:errors path="country" cssStyle="color:red"></form:errors>
						</div>
					</div>
					<div class="form-group">
						<input type="submit" class="btn button">
					</div>
				</form:form>
			</div>

		</div>
		<div class="col-sm-8">
			<div class="col-md-12">
				<c:forEach var="al" items="${addresslist}">
					<div id="holder" class="col-sm-6 col-md-4">
						<div id="bottom-block">
							<div>
								<a href="placeorder?addid=${al.addressid}"
									id="paybutton" class="btn" type="submit"> <i
									class="fa fa-truck" aria-hidden="true"></i> Deliver Here
								</a>
							</div>
							<div class="lead">${al.name}</div>
							<div>${al.addline1}</div>
							<div>${al.addline2}</div>
							<div>${al.city}</div>
							<div>${al.state}</div>
							<div>${al.country}-${al.pincode}</div>
						</div>
						<div id="top-block">
							<a href="editadd?addid=${al.addressid}" class="btn" id="editlink"><span
								class="glyphicon glyphicon-pencil"></span></a> <a
								href="deladd?addid=${al.addressid}" class="btn pull-right"
								id="removelink"><span class="glyphicon glyphicon-remove"></span></a>
						</div>
					</div>
				</c:forEach>
			</div>

		</div>

	</div>
</div>