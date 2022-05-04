<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

</head>
<body>
	<h3 align="center"> Energy Management Table </h3>
	<table border="1" width="70%" align="center">
	<tr>
		<th>EM ID</th>
		<th>City ID</th>
		<th>Energy Production</th>
		<th>Energy Consumption</th>
		<th>Energy Management</th>
	</tr>
<c:forEach items="${Energy_managementList}" var="energy_management">
	<tr>
		<td>${energy_management.em_id}</td>
		<td>${energy_management.city_id}</td>
		<td>${energy_management.energy_production}</td>
		<td>${energy_management.energy_consumption}</td>
		<td>${energy_management.energy_management}</td>
	</tr>
</c:forEach>
</table>
</body>
</html>
