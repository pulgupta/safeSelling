<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update details</title>
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" />
<link rel="stylesheet" href="/safeSelling/scripts/styleSheets/myStyles.css" />

<!-- load angular via CDN -->
<script src="//code.angularjs.org/1.3.0-rc.1/angular.js"></script>
<script src="//code.angularjs.org/1.3.0-rc.1/angular-route.js"></script>
<script src="/safeSelling/scripts/js/myApp.js" type='text/javascript'></script>

</head>
<body>
<body>
	<jsp:include page="header.jsp" />
	<sf:form method="POST" commandName="item">
		<table>
			<tr>
				<td>Title :</td>
				<td><input type="text" name="title"
					value="<c:out value="${item.title}"></c:out>" /></td>
			</tr>

			<tr>
				<td>Description :</td>
				<td><input type="text" name="description"
					value="<c:out value="${item.description}"></c:out>" /></td>
			</tr>

			<tr>
				<td>Buying Price :</td>
				<td><input type="text" name="buyingPrice"
					value="<c:out value="${item.buyingPrice}"></c:out>" /></td>
			</tr>

			<tr>
				<td>Expected Price :</td>
				<td><input type="text" name="expectedPrice"
					value="<c:out value="${item.expectedPrice}"></c:out>" /></td>
			</tr>

			<tr>
				<td>Visibility Level :</td>
				<td><input type="text" name="visibilityLevel"
					value="<c:out value="${item.visibilityLevel}"></c:out>" /></td>
			</tr>

			<tr>
				<td>Contact Preference :</td>
				<td><input type="text" name="contactPreference"
					value="<c:out value="${item.contactPreference}"></c:out>" /></td>
			</tr>

			<tr>
				<td><input type="hidden" name="id"
					value="<c:out value="${item.id}"></c:out>" /> <input type="hidden"
					name="userName" value="<c:out value="${item.userName}"></c:out>" />

					<input type="submit" value="Update" /></td>
			</tr>
		</table>
	</sf:form>
</body>
</body>
</html>