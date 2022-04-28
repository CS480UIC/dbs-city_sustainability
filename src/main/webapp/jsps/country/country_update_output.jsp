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
	ID    			  :<input type="text" name="id" value="${country.id }" disabled/>
	<br/>
	country_name	  ：<input type="text" name="country_name" value="${country.country_name }" disabled/>
	<br/>
	country_population：<input type="text" name="country_population" value="${country.country_population }" disabled/>
	<br/>
</form>

<h1>Update the values below</h1>
<form action="<c:url value='/CountryServletUpdate'/>" method="post">
	<input type="hidden" name="method" value="update"/>
	<input type="hidden" name="id" value="${country.id }"/>
	
	country_name：<input type="text" name="country_name" value="${form.country_name }"/>
	<span style="color: red; font-weight: 900">${errors.country_name }</span>
	<br/>
	country_population	：<input type="text" name="country_population" value="${form.country_population }"/>
	<span style="color: red; font-weight: 900">${errors.country_population }</span>
	<br/>
	<input type="submit" value="Update Country"/>
</form>

</body>
</html>
