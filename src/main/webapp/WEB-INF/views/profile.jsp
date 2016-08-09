<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>your profile</title>
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" />
<link rel="stylesheet" href="/safeSelling/scripts/styleSheets/myStyles.css" />

<!-- load angular via CDN -->
<script src="//code.angularjs.org/1.3.0-rc.1/angular.js"></script>
<script src="//code.angularjs.org/1.3.0-rc.1/angular-route.js"></script>
<script src="/safeSelling/scripts/js/myApp.js" type='text/javascript'></script>

</head>
<body>
	<jsp:include page="header.jsp" />
	Welcome Back :
	<c:out value="${user.firstName}"></c:out>
	<c:out value="${user.lastName}"></c:out>
	<br />
	<br />
	<img src="/safeSelling/resources/<c:out value="${user.userName}" />.png" />
	<br /> Please review your items and add more to sell more to people as
	genuine as you:

	<c:forEach items="${itemList}" var="item">
		<li id="item_<c:out value="item.id"/>" />
		<a href="/safeSelling/items/edit/<c:out value="${item.id}"/>">Edit</a>
		<div class="itemMessage">
			<c:out value="${item.title}" />
		</div>
		<div class="itemMessage">
			<c:out value="${item.description}" />
		</div>
		<span class="itemTime"> <c:out value="${item.expectedPrice}"></c:out><br />
		</span>
		<span class="itemTime"> <c:out value="${item.buyingPrice}"></c:out><br /></span>
		<span class="itemTime"> <c:out
				value="${item.contactPreference}"></c:out><br /></span>
		<span class="itemTime"> <c:out value="${item.visibilityLevel}"></c:out><br /></span>
	</c:forEach>
</body>
</html>