<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Industry Create</title>
    
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
  <h1>Industry Create</h1>
<form action="<c:url value='/Entity1ServletCreate'/>" method="post">
	industry_id: <input type="text" name="industry_id" value="${form.industry_id}"/>
	<span style="color: red; font-weight: 900">${errors.username }</span>
	<br/>
	
	country_id： <input type="text" name="country_id" value="${form.country_id}"/>
	<span style="color: red; font-weight: 900">${errors.password }</span>
	<br/>
	
	industry_type： <input type="text" name="industry_type" value="${form.industry_type}"/>
	<span style="color: red; font-weight: 900">${errors.email }</span>
	<br/>
	
	industry_emission： <input type="text" name="industry_emission" value="${form.industry_emission}"/>
	<span style="color: red; font-weight: 900">${errors.email }</span>
	<br/>	
	<input type="submit" value="Create Industry"/>
</form>
  </body>
</html>
