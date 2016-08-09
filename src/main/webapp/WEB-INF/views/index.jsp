<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html ng-app="myApp">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Safe Seller | Be safe </title>
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" />
<link rel="stylesheet" href="//localhost:8080/safeSelling/scripts/styleSheets/myStyles.css" />

<!-- load angular via CDN -->
<script src="//code.angularjs.org/1.3.0-rc.1/angular.js"></script>
<script src="//code.angularjs.org/1.3.0-rc.1/angular-route.js"></script>
<script src="/safeSelling/scripts/js/myApp.js" type='text/javascript'></script>
</head>
<body>
	<jsp:include page="header.jsp" />
	<img src="/safeSelling/images/banner.jpg" alt="banner image" class="center" height="50%" width="80%" />
	<hr>
	<br/>
	<br/>
	TESTING LINKs

	<h1>We help you sell safely within people like you</h1>
	<div ng-controller="myController" class="container-fluid">
		<a href=/safeSelling/items>See your items</a> <br /> <a
			href=/safeSelling/items/add>add items</a> <br />
	</div>

	<!-- This token is always included so that we can leverage the default  
		spring checks for csrf-->

	<input type="hidden" name="${_csrf.parameterName}"
		value="${_csrf.token}" />
</body>
</html>