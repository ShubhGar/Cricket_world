<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Team Register</title>
<link rel="stylesheet" href="<spring:url value='/css/style.css'/>"
	type="text/css" />
</head>
<body style='background-image: url("../img/bg5.jpg");background-size: cover;'>
	<form:form method="post" modelAttribute="team">
		<div class="login">
		<div >
			<h2 align="center">Team Registration</h2></div>

			<div class="login-form">
			<div>
				<h5>Enter Team Name</h5>
				<form:input path="teamname" placeholder="Team Name" required="empty"/>
			</div>
			
			<div>
				<h5>Enter Team City</h5>
				<form:input path="homestate" placeholder="City" required="empty" />
			</div>
			<div>
				<h5>Enter Team Icon</h5>
				<form:input type="file" path="teamicon" src="???" />
			</div>
			<div>
				<input type="submit" value="Register Team" />
			</div>
			</div>
			</div>
	</form:form>

</body>
</html>