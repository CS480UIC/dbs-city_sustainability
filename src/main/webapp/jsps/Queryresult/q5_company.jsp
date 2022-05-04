<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

</head>
<body>
	<h3 align="center"> Company Table </h3>
	<table border="1" width="70%" align="center">
	<tr>
		<th>Company ID</th>
		<th>Industry ID</th>
		<th>Company Name</th>
		<th>Industry Emission</th>
	</tr>
<c:forEach items="${CompanyList}" var="company">
	<tr>
		<td>${company.id}</td>
		<td>${company.industry_id}</td>
		<td>${company.company_name}</td>
		<td>${company.company_emission}</td>
	</tr>
</c:forEach>
</table>
</body>
</html>
