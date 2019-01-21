<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Schedule</title>
</head>
<body style='background-image: url("../img/bg6.jpg");background-size: cover;'>
		<h3 align="center">Tournament Schedule</h3>
		<h4 align="center">${wildcard}</h4>
		<c:forEach var="schedule" items="${requestScope.teamarr}">
		<h4>${schedule}</h4>
		</c:forEach>
</body>
</html>