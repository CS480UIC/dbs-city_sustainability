<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

</head>
<body>
	<h3 align="center"> Carbon Emission Target Table </h3>
	<table border="1" width="70%" align="center">
	<tr>
		<th>CET ID</th>
		<th>City ID</th>
		<th>Base Year</th>
		<th>Base Emission</th>
		<th>Target Year</th>
		<th>Target Emission</th>
	</tr>
<c:forEach items="${Carbon_emission_target List}" var="carbon_emission_target">
	<tr>
		<td>${carbon_emission_target.cet_id}</td>
		<td>${carbon_emission_target.cet_city_id}</td>
		<td>${carbon_emission_target.base_year}</td>
		<td>${carbon_emission_target.base_emission}</td>
		<td>${carbon_emission_target.target_year}</td>
		<td>${carbon_emission_target.target_emission}</td>
	</tr>
</c:forEach>
</table>
</body>
</html>
