<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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


</style>
<div class="container">
<c:url var="url" value="${contextroot}/adduser"></c:url>
	<form:form modelAttribute="UserDetail" method="post" action="${url}">
		<div class="container">
			<h1>Register</h1>
			<hr>
			<div>
				<label for="name"><b>Name</b></label>
				<form:input type="text" placeholder="Enter Name" name="name" path="user_name" />
				<form:errors path="user_name" cssStyle="color:Red"></form:errors>
			</div>
			<div>
				<label for="number"><b>Mobile Number</b></label>
				<form:input type="text" placeholder="Enter Mobile Number" name="number" path="mobileno" />
				<form:errors path="mobileno" cssStyle="color:Red"></form:errors>
			</div>
			<div>
				<label for="email"><b>Email</b></label>
				<form:input type="text" placeholder="Enter Email" name="email" path="emailid" />
				<form:errors path="emailid" cssStyle="color:Red"></form:errors>
			</div>
			<div>
				<label for="psw"><b>Password</b></label>
				<form:input type="password" placeholder="Enter Password" name="psw" path="user_password" />
				<form:errors path="user_password" cssStyle="color:Red"></form:errors>
			</div>
			<p>
				By creating an account you agree to our <a href="#"
					style="color: dodgerblue">Terms & Privacy</a>.
			</p>

			<div class="clearfix">
				<input type="submit" class="btn btn-info" value="Register	">
			</div>
		</div>
	</form:form>

</div>

