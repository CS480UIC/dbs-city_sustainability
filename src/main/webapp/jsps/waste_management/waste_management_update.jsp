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
<form action="<c:url value='/Waste_managementServletUpdate'/>" method="post">
	<input type="hidden" name="method" value="search"/>
	Update wm_id:  <input type="text" name="wm_id" value="${form.wm_id }"/>
	<span style="color: red; font-weight: 900">${errors.wm_id }</span>
	<br/><br/>
	<input type="submit" value="Update Waste Management"/>
</form>
  </body>
</html>
