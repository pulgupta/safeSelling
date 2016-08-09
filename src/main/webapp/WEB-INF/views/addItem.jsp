<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@page session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css"
	href="/safeSelling/safeSellingStyles.css">
<title>Post a new Item</title>
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" />
<link rel="stylesheet" href="/safeSelling/scripts/styleSheets/myStyles.css" />

<!-- load angular via CDN -->
<script src="//code.angularjs.org/1.3.0-rc.1/angular.js"></script>
<script src="//code.angularjs.org/1.3.0-rc.1/angular-route.js"></script>
<script src="/safeSelling/scripts/js/myApp.js" type='text/javascript'></script>

</head>
<body>
	<jsp:include page="header.jsp" />
	<sf:form method="POST" commandName="item">
		<table class="list table-form">
			<tr>
				<td>Title :</td>
				<td><sf:input path="title" class="form-control"/> <sf:errors path="title" /></td>
			</tr>
			<tr>
				<td>Description :</td>
				<td><sf:input path="description" class="form-control" /> <sf:errors
						path="description" /></td>
			</tr>
			<tr>
				<td>Buying Price :</td>
				<td><sf:input path="buyingPrice" class="form-control"/> <sf:errors
						path="buyingPrice" /></td>
			</tr>
			<tr>
				<td>Expected Price :</td>
				<td><sf:input path="expectedPrice" class="form-control"/> <sf:errors
						path="expectedPrice" /></td>
			</tr>
			<tr>
				<td>Visibility Preference :</td>
				<td><sf:input path="visibilityLevel" class="form-control"/> <sf:errors
						path="visibilityLevel" /></td>
			</tr>
			<tr>
				<td>Contact Preference :</td>
				<td><sf:input path="contactPreference" class="form-control"/> <sf:errors
						path="contactPreference" /></td>
			</tr>
			<tr>
				<td>Enter Tags :</td>
				<td><sf:input path="tagList" class="form-control"/> <sf:errors path="tagList"/></td>
			</tr>
			<tr>
				<td><input type="submit" class="btn btn-default" value="add"/></td>
			</tr>
		</table>
	</sf:form>
</body>
</html>