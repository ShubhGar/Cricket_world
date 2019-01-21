<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<script src="../js/validation.js">
</script>
<link rel="stylesheet" href="<spring:url value='/css/style.css'/>"
	type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Register</title>
</head>
<body>

	<h3 align="center">${mesg}</h3>
	<h3 align="center">
		<spring:message code="user.mesg" />
		</h3>
		<h3 align="center">${message}</h3>
	
	<form:form onsubmit="return formValidation();" method="post" modelAttribute="customer">
	<div class="login-header"><h1 align="center">Cricket Tournament</h1></div>
		
		<div class="login">
		<div >
			<h2 align="center">Register</h2></div>

			<div class="login-form">
			<div>
			<h5>Enter Email:</h5>
			
				<form:input path="email" placeholder="User Email" required="empty"/>

			</div>

			<div>
				<h5>Enter Password:</h5>
				<form:password path="password" placeholder="Password" required="empty"/>
				
			</div>
			<div>
				<h5>Enter Name</h5>
				<form:input path="name" placeholder="User Name" required="empty"/>
			</div>
			<div>
				<h5>Enter Registration Amount</h5>
				<form:input path="depositAmt" placeholder="Enter Amount" required="empty" />
			</div>
			<div>

				<input type="submit" value="Register"  class="login-button"/>
			</div>
			
			<div>	<a href="validate" class="sign-up">login</a>

			</div>
			</div>
   			</div>
	
	</form:form>

</body>
</html>