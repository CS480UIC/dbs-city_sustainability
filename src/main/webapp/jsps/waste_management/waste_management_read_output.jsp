<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Read Waste Management Output</title>
    
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
  <h1>Read Waste Management Output</h1>
<p style="color: red; font-weight: 900">${msg }</p>
<form>
	wm_id			:<input type="text" name="wm_id" value="${waste_management.wm_id }" disabled/>
	<br/>
	wm_city_id		:<input type="text" name="wm_city_id" value="${waste_management.city_id }" disabled/>
	<br/>
	pollution_rate	：<input type="text" name="pollution_rate" value="${waste_management.pollution_rate }" disabled/>
	<br/>
	recycle_rate	：<input type="text" name="recycle_rate" value="${waste_management.recycle_rate }" disabled/>
	<br/>

</form>

<button onclick="window.location.href='<c:url value='/jsps/main.jsp'/>'">Continue</button>
</body>
</html>
