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
  <h1>Update</h1>
<form action="<c:url value='/Carbon_emission_targetServletUpdate'/>" method="post">
	<input type="hidden" name="method" value="search"/>
	Update cet_id:<input type="text" name="cet_id" value="${form.cet_id }"/>
	<span style="color: red; font-weight: 900">${errors.cet_id }</span>
	<br/>
	<input type="submit" value="Update ECarbon Emission Target"/>
</form>
  </body>
</html>
