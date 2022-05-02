<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

</head>
<body>
	<h3 align="center"> Waste Management Table </h3>
	<table border="1" width="70%" align="center">
	<tr>
		<th>WM ID</th>
		<th>City ID</th>
		<th>Pollution Rate</th>
		<th>Recycle Rate</th>
	</tr>
<c:forEach items="${Waste_management List}" var="waste_management">
	<tr>
		<td>${waste_management.em_id}</td>
		<td>${waste_management.em_city_id}</td>
		<td>${waste_management.pollution_rate}</td>
		<td>${waste_management.recycle_rate}</td>
	</tr>
</c:forEach>
</table>
</body>
</html>
