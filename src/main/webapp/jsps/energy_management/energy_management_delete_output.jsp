<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Delete Energy Management</title>
    
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
  <h1>Delete Energy Management</h1>
<p style="color: red; font-weight: 900">${msg }</p>
<form action="<c:url value='/Energy_managementServletDelete'/>" method="post">
	<input type="hidden" name="method" value="delete"/>
		<input type="hidden" name="em_id" value="${energy_management.em_id }"/>
	em_city_id	   :<input type="text" name="em_city_id" value="${energy_management.city_id }" disabled/>
	<br/>
	energy_production	：<input type="text" name="energy_production" value="${energy_management.energy_production }" disabled/>
	<br/>
	energy_consumption	：<input type="text" name="energy_consumption" value="${energy_management.energy_consumption }" disabled/>
	<br/>
	energy_management	：<input type="text" name="energy_management" value="${energy_management.energy_management }" disabled/>
	<br/>
	<input type="submit" value="Delete Energy Management"/>
</form>

</body>
</html>
