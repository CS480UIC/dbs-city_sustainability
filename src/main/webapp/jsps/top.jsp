<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>top</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="content-type" content="text/html;charset=utf-8">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
	body {
		background: #4682B4; 
	}
	a {
		text-transform:none;
		text-decoration:none;
	} 
	a:hover {
		text-decoration:underline;
	}
</style>
  </head>
  
  <body>
<h1 style="text-align: center;">City Sustainability Database</h1>
<div style="font-size: 10pt;">
	<c:choose>
		<c:when test="${empty sessionScope.session_user }">
			<a href="<c:url value='/jsps/user/login.jsp'/>" target="_parent">Login</a> |&nbsp; 
			<a href="<c:url value='/jsps/user/regist.jsp'/>" target="_parent">Register</a> |&nbsp;
			<a href="<c:url value='/jsps/initialize/init.jsp'/>" target="body">Initialize Database</a> |&nbsp;  
	
		</c:when>
		<c:otherwise>
			Hello：${sessionScope.session_user.username };
			<a href="<c:url value='/jsps/user/queries.jsp'/>" target="body">Query Result</a> |&nbsp;&nbsp;
			<a href="<c:url value='/UserServletLogout'/>" target="_parent">Logout</a> |&nbsp; 
			<a href="<c:url value='/jsps/country/country_menu.jsp'/>" target="_parent">CRUD for Country</a>	|&nbsp; 
			<a href="<c:url value='/jsps/city/citymenu.jsp'/>" target="_parent">CRUD for City</a>	|&nbsp; 
			<a href="<c:url value='/jsps/industry/industry_menu.jsp'/>" target="_parent">CRUD for Industry</a>	|&nbsp; 
			<a href="<c:url value='/jsps/company/company_menu.jsp'/>" target="_parent">CRUD for Company</a>	|&nbsp; 
			<a href="<c:url value='/jsps/energy_management/energy_management_menu.jsp'/>" target="_parent">CRUD for Energy</a>	|&nbsp;
			<a href="<c:url value='/jsps/waste_management/waste_management_menu.jsp'/>" target="_parent">CRUD for Waste</a>	|&nbsp; 
			<a href="<c:url value='/jsps/carbon_emission_target/carbon_emission_target_menu.jsp'/>" target="_parent">CRUD for Emission Target</a>	|&nbsp;
			<a href="<c:url value='/jsps/transportation/transportation_menu.jsp'/>" target="_parent">CRUD for Transportation</a>
		</c:otherwise>
	</c:choose>

</div>
  </body>
</html>

