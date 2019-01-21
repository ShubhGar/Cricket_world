<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register Player</title>
<link rel="stylesheet" href="<spring:url value='/css/style.css'/>"
	type="text/css" />
</head>
<body style='background-image: url("../img/bg5.jpg");background-size: cover;'>
<form:form method="post" modelAttribute="player">
	
	<!---->
	<div class="login">
		<div >
			<h2 align="center">Player Registration</h2></div>

			<div class="login-form">
			<div>
			<h5>Enter Player Name</h5>
				<form:input path="playername" placeholder="Player Name" required="empty"/>	
			</div>

			<div>
				<h5>Enter Address</h5>
				<form:input path="playeraddr" placeholder="Player Address" required="empty"/>
			</div>
			<div>
				<h5>Enter Playing Style</h5>
				<form:input path="playeraddr" placeholder="Player Address" required="empty"/>
				<form:input path="playstyle" placeholder="playstyle" required="empty"/>
				</div>
			<div>
				<h5>Enter Player Image</h5>
				<form:input type="file" path="playerimage" src="???" />
			</div>
			<div>
				<input type="submit" value="Register Player"  class="login-button"/>
			</div>
			<div>

			</div>
			</div>
   			</div>
	
	<!---->
</form:form>
</body>
</html>