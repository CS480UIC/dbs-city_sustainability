<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Update Country</title>
    
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
  <h1>Update Country</h1>
<p style="color: red; font-weight: 900">${msg }</p>
<form>
	id    		   :<input type="text" name="id" value="${city.id }" disabled/>
	<br/>
	country_id     :<input type="text" name="country_id" value="${city.country_id }" disabled/>
	<br/>
	city_name	   ：<input type="text" name="city_name" value="${city.city_name }" disabled/>
	<br/>
	city_population：<input type="text" name="city_population" value="${city.city_population }" disabled/>
	<br/>
	city_density   ：<input type="text" name="city_density" value="${city.city_density }" disabled/>
	<br/>
</form>

<h1>Update the values below</h1>
<form action="<c:url value='/CityServletUpdate'/>" method="post">
	<input type="hidden" name="method" value="update"/>
	<input type="hidden" name="id" value="${city.id }"/>
	
	city_name		：<input type="text" name="city_name" value="${form.city_name }"/>
	<span style="color: red; font-weight: 900">${errors.city_name }</span>
	<br/>
	city_population	：<input type="text" name="city_population" value="${form.city_population }"/>
	<span style="color: red; font-weight: 900">${errors.city_population }</span>
	<br/>
	city_density	：<input type="text" name="city_density" value="${form.city_density }"/>
	<span style="color: red; font-weight: 900">${errors.city_density }</span>
	<br/>
	<input type="submit" value="Update City"/>
</form>

</body>
</html>
