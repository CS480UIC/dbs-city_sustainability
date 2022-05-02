<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Read Carbon Emission Target Output</title>
    
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
  <h1>Read Carbon Emission Target Output</h1>
<p style="color: red; font-weight: 900">${msg }</p>
<form>
	cet_id			:<input type="text" name="cet_id" value="${carbon_emission_target.cet_id }" disabled/>
	<br/>
	cet_city_id		:<input type="text" name="cet_city_id" value="${carbon_emission_target.city_id }" disabled/>
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

<button onclick="window.location.href='<c:url value='/jsps/main.jsp'/>'">Continue</button>
</body>
</html>
