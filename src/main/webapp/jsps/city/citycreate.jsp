<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>City Create</title>
    
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
  <h1>City Create</h1>
<form action="<c:url value='/CityServletCreate'/>" method="post">
	id			:<input type="text" name="id" value="${form.id }"/>
	<span style="color: red; font-weight: 900">${errors.id }</span>
	<br/>
	country_id	：<input type="text" name="country_id" value="${form.country_id }"/>
	<span style="color: red; font-weight: 900">${errors.country_id }</span>
	<br/>
	city_name	：<input type="text" name="city_name" value="${form.city_name }"/>
	<span style="color: red; font-weight: 900">${errors.city_name }</span>
	<br/>
	city_population:<input type="text" name="city_population" value="${form.city_population }"/>
	<span style="color: red; font-weight: 900">${errors.city_population }</span>
	<br/>
	city_density:<input type="text" name="city_density" value="${form.city_density }"/>
	<span style="color: red; font-weight: 900">${errors.city_density }</span>
	<br/>
	<input type="submit" value="Create City"/>
</form>
  </body>
</html>
