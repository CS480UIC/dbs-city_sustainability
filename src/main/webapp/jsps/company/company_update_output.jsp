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
	id    		   :<input type="text" name="id" value="${company.id }" disabled/>
	<br/>
	country_id     :<input type="text" name="country_id" value="${company.country_id }" disabled/>
	<br/>
	company_name	   ：<input type="text" name="company_name" value="${company.company_name }" disabled/>
	<br/>
	company_emission：<input type="text" name="company_emission" value="${company.company_emission }" disabled/>
	<br/>

</form>

<h1>Update the values below</h1>
<form action="<c:url value='/CompanyServletUpdate'/>" method="post">
	<input type="hidden" name="method" value="update"/>
	<input type="hidden" name="id" value="${company.id }"/>
	
	country_id		：<input type="text" name="country_id" value="${form.country_id }"/>
	<span style="color: red; font-weight: 900">${errors.country_id }</span>
	<br/>
	company_name	：<input type="text" name="company_name" value="${form.company_name }"/>
	<span style="color: red; font-weight: 900">${errors.company_name }</span>
	<br/>
	company_emission	：<input type="text" name="company_emission" value="${form.company_emission }"/>
	<span style="color: red; font-weight: 900">${errors.company_emission }</span>
	<br/>
	<input type="submit" value="Update Company"/>
</form>

</body>
</html>
