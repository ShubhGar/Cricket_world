<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Players</title>
</head>
<body style='background-image: url("../img/bg4.jpg");background-size: cover;'>
	<h3 align="center" style="color:white">Player List</h3>
	<center>
	<table border="5" style="color:white">
	<tr>
	<th>PlayerId</th>
	<th>Player Name</th>
	<th>Player Playing style</th>
	<th>Player Address</th>
	<th>Player Image</th>
	</tr>
	<c:forEach var="player" items="${requestScope.player_list}">
     <tr>
     <td>${player.playerid}</td>
     <td> ${player.playername} </td>
     <td>${player.playstyle}</td>
     <td> ${player.playeraddr}</td>
     <td> ${player.playerimage }</td>
	 </tr>
	</c:forEach>
	</table>
	</center>
</body>
</html>