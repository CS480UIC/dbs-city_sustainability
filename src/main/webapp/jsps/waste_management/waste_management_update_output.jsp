<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Update Waste Management</title>
    
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
  <h1>Update Waste Management</h1>
<p style="color: red; font-weight: 900">${msg }</p>
<form>
	wm_id    		:<input type="text" name="wm_id" value="${waste_management.wm_id }" disabled/>
	<br/>
	wm_city_id     	:<input type="text" name="wm_city_id" value="${waste_management.city_id }" disabled/>
	<br/>
	pollution_rate	：<input type="text" name="pollution_rate" value="${waste_management.pollution_rate }" disabled/>
	<br/>
	recycle_rate	：<input type="text" name="recycle_rate" value="${waste_management.recycle_rate }" disabled/>
	<br/>
</form>

<h1>Update the values below</h1>
<form action="<c:url value='/Waste_managementServletUpdate'/>" method="post">
	<input type="hidden" name="method" value="update"/>
	<input type="hidden" name="wm_id" value="${waste_management.wm_id }"/>
	
	wm_city_id		：<input type="text" name="wm_city_id" value="${form.city_id }"/>
	<span style="color: red; font-weight: 900">${errors.city_id }</span>
	<br/>
	pollution_rate	：<input type="text" name="pollution_rate" value="${form.pollution_rate }"/>
	<span style="color: red; font-weight: 900">${errors.pollution_rate }</span>
	<br/>
	recycle_rate	：<input type="text" name="recycle_rate" value="${form.recycle_rate }"/>
	<span style="color: red; font-weight: 900">${errors.recycle_rate }</span>
	<br/>
	<input type="submit" value="Update Waste Management"/>
</form>

</body>
</html>
