<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Remove Team Detail</title>
</head>
<body style='background-image: url("../img/bg5.jpg");background-size: cover;' >
<form:form method="post" modelAttribute="team">
		
		<div align="center" >
			<h2 align="center">Remove Player </h2></div>

			<div align="center">
			<div>
			<h5>Enter Team Name</h5>
				<form:input path="teamname" />
			</div>
			<div>
				<input type="submit" value="Remove Team" placeholder="Team Name" required="empty"/>
			
			</div>
			</div>
	</form:form>
</body>
</html>