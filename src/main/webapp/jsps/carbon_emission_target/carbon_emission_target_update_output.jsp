<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Update Carbon Emission Target</title>
    
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
  <h1>Update Carbon Emission Target</h1>
<p style="color: red; font-weight: 900">${msg }</p>
<form>
	cet_id    		:<input type="text" name="cet_id" value="${carbon_emission_target.cet_id }" disabled/>
	<br/>
	cet_city_id     :<input type="text" name="cet_city_id" value="${carbon_emission_target.city_id }" disabled/>
	<br/>
	base_year		：<input type="text" name="base_year" value="${carbon_emission_target.base_year }" disabled/>
	<br/>
	base_emission	：<input type="text" name="base_emission" value="${carbon_emission_target.base_emission }" disabled/>
	<br/>
	target_year		：<input type="text" name="target_year" value="${carbon_emission_target.target_year }" disabled/>
	<br/>
	target_emission	：<input type="text" name="target_emission" value="${carbon_emission_target.target_emission }" disabled/>
	<br/>
</form>

<h1>Update the values below</h1>
<form action="<c:url value='/Carbon_emission_targetServletUpdate'/>" method="post">
	<input type="hidden" name="method" value="update"/>
	<input type="hidden" name="cet_id" value="${carbon_emission_target.cet_id }"/>
	
	cet_city_id		：<input type="text" name="cet_city_id" value="${form.city_id }"/>
	<span style="color: red; font-weight: 900">${errors.city_id }</span>
	<br/>
	base_year	：<input type="text" name="base_year" value="${form.base_year }"/>
	<span style="color: red; font-weight: 900">${errors.base_year }</span>
	<br/>
	base_emission	：<input type="text" name="base_emission" value="${form.base_emission }"/>
	<span style="color: red; font-weight: 900">${errors.base_emission }</span>
	<br/>
	target_year	：<input type="text" name="target_year" value="${form.target_year }"/>
	<span style="color: red; font-weight: 900">${errors.target_year }</span>
	<br/>
	target_emission	：<input type="text" name="target_emission" value="${form.target_emission }"/>
	<span style="color: red; font-weight: 900">${errors.target_emission }</span>
	<br/>
	<input type="submit" value="Update Carbon Emission Target"/>
</form>

</body>
</html>
