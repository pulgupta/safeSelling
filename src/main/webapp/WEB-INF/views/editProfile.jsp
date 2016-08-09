<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update your information</title>
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
	<sf:form method="POST" commandName="user">
		<table>
			<tr>
				<td>First Name :</td>
				<td><input type="text" name="firstName"
					value="<c:out value="${user.firstName}"></c:out>" /></td>
			</tr>

			<tr>
				<td>Last Name :</td>
				<td><input type="text" name="lastName"
					value="<c:out value="${user.lastName}"></c:out>" /></td>
			</tr>

			<tr>
				<td>User Name :</td>
				<td><input type="text" name="userName"
					value="<c:out value="${user.userName}"></c:out>" /></td>
			</tr>

			<tr>
				<td>Address Line 1 :</td>
				<td><input type="text" name="addressLine1"
					value="<c:out value="${user.addressLine1}"></c:out>" /></td>
			</tr>

			<tr>
				<td>Address Line 2 :</td>
				<td><input type="text" name="addressLine2"
					value="<c:out value="${user.addressLine2}"></c:out>" /></td>
			</tr>

			<tr>
				<td>City :</td>
				<td><input type="text" name="city"
					value="<c:out value="${user.city}"></c:out>" /></td>
			</tr>

			<tr>
				<td>State :</td>
				<td><input type="text" name="stateName"
					value="<c:out value="${user.stateName}"></c:out>" /></td>
			</tr>

			<tr>
				<td>Country :</td>
				<td><input type="text" name="country"
					value="<c:out value="${user.country}"></c:out>" /></td>
			</tr>

			<tr>
				<td>Company Name :</td>
				<td><input type="text" name="organization"
					value="<c:out value="${user.organization}"></c:out>" /></td>
			</tr>

			<tr>
				<td>Phone Number :</td>
				<td><input type="text" name="phoneNumber"
					value="<c:out value="${user.phoneNumber}"></c:out>" /></td>
			</tr>

			<tr>
				<td>Email Address :</td>
				<td><input type="text" name="email"
					value="<c:out value="${user.email}"></c:out>" /></td>
			</tr>

			<tr>
				<td><input type="submit" value="Update" /></td>
			</tr>
		</table>
	</sf:form>
</body>
</body>
</html>