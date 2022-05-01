<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Update Energy Management</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="content-type" content="text/html;charset=utf-8">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  <h1>Update Energy Management</h1>
<p style="color: red; font-weight: 900">${msg }</p>
<form>
	em_id    		   :<input type="text" name="em_id" value="${energy_management.em_id }" disabled/>
	<br/>
	em_city_id     	:<input type="text" name="em_city_id" value="${energy_management.city_id }" disabled/>
	<br/>
	energy_production	：<input type="text" name="energy_production" value="${energy_management.energy_production }" disabled/>
	<br/>
	energy_consumption	：<input type="text" name="energy_consumption" value="${energy_management.energy_consumption }" disabled/>
	<br/>
	energy_management	：<input type="text" name="energy_management" value="${energy_management.energy_management }" disabled/>
	<br/>
</form>

<h1>Update the values below</h1>
<form action="<c:url value='/Energy_managementServletUpdate'/>" method="post">
	<input type="hidden" name="method" value="update"/>
	<input type="hidden" name="em_id" value="${energy_management.em_id }"/>
	
	em_city_id		：<input type="text" name="em_city_id" value="${form.city_id }"/>
	<span style="color: red; font-weight: 900">${errors.city_id }</span>
	<br/>
	energy_production	：<input type="text" name="energy_production" value="${form.energy_production }"/>
	<span style="color: red; font-weight: 900">${errors.energy_production }</span>
	<br/>
	energy_consumption	：<input type="text" name="energy_consumption" value="${form.energy_consumption }"/>
	<span style="color: red; font-weight: 900">${errors.energy_consumption }</span>
	<br/>
	energy_management	：<input type="text" name="energy_management" value="${form.energy_management }"/>
	<span style="color: red; font-weight: 900">${errors.energy_management }</span>
	<br/>
	<input type="submit" value="Update Energy Management"/>
</form>

</body>
</html>
