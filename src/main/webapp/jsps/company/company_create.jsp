<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Company Create</title>
    
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
  <h1>Company Create</h1>
<form action="<c:url value='/CompanyServletCreate'/>" method="post">
	id			:<input type="text" name="id" value="${form.id }"/>
	<span style="color: red; font-weight: 900">${errors.id }</span>
	<br/>
	industry_id	：<input type="text" name="industry_id" value="${form.industry_id }"/>
	<span style="color: red; font-weight: 900">${errors.industry_id }</span>
	<br/>
	company_name	：<input type="text" name="company_name" value="${form.company_name }"/>
	<span style="color: red; font-weight: 900">${errors.company_name }</span>
	<br/>
	company_emission:<input type="text" name="company_emission" value="${form.company_emission }"/>
	<span style="color: red; font-weight: 900">${errors.company_emission }</span>
	<br/>
	<input type="submit" value="Create Company"/>
</form>
  </body>
</html>
