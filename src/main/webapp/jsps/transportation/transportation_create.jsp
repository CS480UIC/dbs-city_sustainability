<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Create Transportation</title>
    
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
  <h1>Create Transporation:</h1>
<form action="<c:url value='/TransportationServletCreate'/>" method="post">
	idtransporation_id:<input type="text" name="idtransporation_id" value="${form.idtransporation_id }"/>
	<span style="color: red; font-weight: 900">${errors.idtransporation_id }</span>
	<br/>
	target_id       ：<input type="text" name="target_id" value="${form.target_id }"/>
	<span style="color: red; font-weight: 900">${errors.target_id }</span>
	<br/>
	car_population	：<input type="text" name="car_population" value="${form.car_population }"/>
	<span style="color: red; font-weight: 900">${errors.car_population }</span>
	<br/>
	car_emission	：<input type="text" name="car_emission" value="${form.car_emission }"/>
	<span style="color: red; font-weight: 900">${errors.car_emission }</span>
	<br/>
	public_usage	：<input type="text" name="public_usage" value="${form.public_usage }"/>
	<span style="color: red; font-weight: 900">${errors.public_usage }</span>
	<br/>
	public_emission	：<input type="text" name="public_emission" value="${form.public_emission }"/>
	<span style="color: red; font-weight: 900">${errors.public_emission }</span>
	<br/>
	<input type="submit" value="Create Transportation"/>
</form>
  </body>
</html>