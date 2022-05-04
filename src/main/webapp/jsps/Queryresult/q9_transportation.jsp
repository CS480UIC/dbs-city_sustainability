<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

</head>
<body>
	<h3 align="center"> Transportation Table </h3>
	<table border="1" width="70%" align="center">
	<tr>
		<th>Transportation ID</th>
		<th>Target ID</th>
		<th>Car Population</th>
		<th>Car Emission</th>
		<th>Public Usage</th>
		<th>Public Emission</th>
	</tr>
<c:forEach items="${TransportationList}" var="transportation">
	<tr>
		<td>${transportation.idtransportation_id}</td>
		<td>${transportation.target_id}</td>
		<td>${transportation.car_population}</td>
		<td>${transportation.car_emission}</td>
		<td>${transportation.public_usage}</td>
		<td>${transportation.public_emission}</td>
	</tr>
</c:forEach>
</table>
</body>
</html>
