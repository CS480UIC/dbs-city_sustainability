<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="">
    
    <title>body</title>
    
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
    <h1>List of Queries</h1>
    <br>
    <a href="<c:url value='/findAll'/>" target="body">Please list all the user in the table</a>&nbsp;&nbsp; 
    <br/>
    <a href="<c:url value='/FindCountry'/>" target="body">Please list all the country in the table</a>&nbsp;&nbsp;
    <br/>
    <a href="<c:url value='/FindCity'/>" target="body">Please list all the city in the table</a>&nbsp;&nbsp;
    <br/>
    <a href="<c:url value='/FindIndustry'/>" target="body">Please list all the industry in the table</a>&nbsp;&nbsp;
    <br/>
    <a href="<c:url value='/FindCompany'/>" target="body">Please list all the company in the table</a>&nbsp;&nbsp;
    <br/>
    <a href="<c:url value='/FindEnergy_management'/>" target="body">Please list all the energy management in the table</a>&nbsp;&nbsp;
    <br/>
    <a href="<c:url value='/FindWaste_management'/>" target="body">Please list all the waste management in the table</a>&nbsp;&nbsp;
    <br/>
    <a href="<c:url value='/FindCarbon_emission_target'/>" target="body">Please list all the carbon emission target in the table</a>&nbsp;&nbsp;
    <br/>
    <a href="<c:url value='/FindTransportation'/>" target="body">Please list all the transportation in the table</a>&nbsp;&nbsp;
    <br/>
  </body>
</html>
