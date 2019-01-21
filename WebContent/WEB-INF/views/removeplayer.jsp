<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Remove Player</title>
</head>
<body style='background-image: url("../img/bg5.jpg");background-size: cover;'>
	<form:form method="post" modelAttribute="player">
		
		<div align="center" >
			<h2 align="center">Remove Player </h2></div>

			<div class="login-form">
			<div>
			<h5>Enter Player Id</h5>
				<form:input path="playerid" placeholder="Player Id" required="empty" />
				
			</div>
			<div>
				<input type="submit" value="Remove Player" />
			</div>
			</div>
			
	</form:form>
</body>
</html>