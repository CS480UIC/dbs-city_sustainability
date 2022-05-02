<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Carbon Emission Target Create</title>
    
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
  <h1>Carbon Emission Target Create</h1>
<form action="<c:url value='/Carbon_emission_targetServletCreate'/>" method="post">
	cet_id:<input type="text" name="cet_id" value="${form.cet_id }"/>
	<span style="color: red; font-weight: 900">${errors.cet_id }</span>
	<br/>
	cet_city_id：<input type="text" name="cet_city_id" value="${form.city_id }"/>
	<span style="color: red; font-weight: 900">${errors.city_id }</span>
	<br/>
	base_year：<input type="text" name="base_year" value="${form.base_year }"/>
	<span style="color: red; font-weight: 900">${errors.base_year }</span>
	<br/>
	base_emission:<input type="text" name="base_emission" value="${form.base_emission }"/>
	<span style="color: red; font-weight: 900">${errors.base_emission }</span>
	<br/>
	target_year:<input type="text" name="target_year" value="${form.target_year }"/>
	<span style="color: red; font-weight: 900">${errors.target_year }</span>
	<br/>
	target_emission:<input type="text" name="target_emission" value="${form.target_emission }"/>
	<span style="color: red; font-weight: 900">${errors.target_emission }</span>
	<br/>
	<input type="submit" value="Create Carbon Emission Target"/>
</form>
  </body>
</html>
