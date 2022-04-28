<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

</head>
<body>
	<h3 align="center"> City Table </h3>
	<table border="1" width="70%" align="center">
	<tr>
		<th>City ID</th>
		<th>Country ID</th>
		<th>Country Name</th>
		<th>Population</th>
		<th>Density</th>
	</tr>
<c:forEach items="${CityList}" var="city">
	<tr>
		<td>${city.id}</td>
		<td>${city.country_id}</td>
		<td>${city.city_name}</td>
		<td>${city.city_population}</td>
		<td>${city.city_density}</td>
	</tr>
</c:forEach>
</table>
</body>
</html>
