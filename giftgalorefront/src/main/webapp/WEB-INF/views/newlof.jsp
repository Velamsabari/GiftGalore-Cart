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

</style>
<div class="container">
	<c:if test="${error}">
		<div class="alert alert-danger">
			<strong>UserName Or Password Incorrect</strong>
		</div>
	</c:if>
	<form method="post" action="perform_login">
		<h1>Login</h1>
		<hr>
		<div>
			<label for="name"><b>Email ID</b></label> <input type="text"
				placeholder="Enter Email ID" name="user_name" id="user_name" />

		</div>
		<div>
			<label for="psw"><b>Password</b></label> <input type="password"
				placeholder="Enter Password" name="user_password" id="user_password" />
		</div>
		<div class="clearfix">
			<input type="submit" class="btn btn-info" value="Login" />
		</div>
	</form>

</div>

