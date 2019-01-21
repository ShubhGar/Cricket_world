<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Teams</title>
<style>
#bdd{
background-image: url("../img/bg3.jpg");
background-size: cover;
}
</style>
</head>
<body id="bdd">
	<h3 align="center">Team List</h3>
	<c:forEach var="team" items="${requestScope.team_list}">
   <h3 align="center"> ${team}</h3>  
		<br />
	</c:forEach>
</body>
</html>