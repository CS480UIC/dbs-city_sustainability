<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Energy Management Create</title>
    
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
  <h1>Energy Management Create</h1>
<form action="<c:url value='/Energy_managementServletCreate'/>" method="post">
	em_id:<input type="text" name="em_id" value="${form.em_id }"/>
	<span style="color: red; font-weight: 900">${errors.em_id }</span>
	<br/>
	em_city_id：<input type="text" name="em_city_id" value="${form.em_city_id }"/>
	<span style="color: red; font-weight: 900">${errors.em_city_id }</span>
	<br/>
	energy_production：<input type="text" name="energy_production" value="${form.energy_production }"/>
	<span style="color: red; font-weight: 900">${errors.energy_production }</span>
	<br/>
	energy_consumption:<input type="text" name="energy_consumption" value="${form.energy_consumption }"/>
	<span style="color: red; font-weight: 900">${errors.energy_consumption }</span>
	<br/>
	energy_management:<input type="text" name="energy_management" value="${form.energy_management }"/>
	<span style="color: red; font-weight: 900">${errors.energy_management }</span>
	<br/>
	<input type="submit" value="Create Energy Management"/>
</form>
  </body>
</html>
