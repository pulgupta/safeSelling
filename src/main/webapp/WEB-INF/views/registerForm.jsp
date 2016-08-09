<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@page session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register Now</title>
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" />
<link rel="stylesheet"
	href="/safeSelling/scripts/styleSheets/myStyles.css" />

<!-- load angular via CDN -->
<script src="//code.angularjs.org/1.3.0-rc.1/angular.js"></script>
<script src="//code.angularjs.org/1.3.0-rc.1/angular-route.js"></script>
<script src="/safeSelling/scripts/js/myApp.js" type='text/javascript'></script>
</head>
<body>
	<jsp:include page="header.jsp" />
	<div style="width: 80%"class="center">
		<sf:form method="POST" commandName="user">
			<table>
				<tr>
					<td>First Name :</td>
					<td><sf:input path="firstName" /> <sf:errors path="firstName" /></td>
				</tr>
				<tr>
					<td>Last Name :</td>
					<td><sf:input path="lastName" /> <sf:errors path="lastName" />
					</td>
				</tr>
				<tr>
					<td>User Name :</td>
					<td><sf:input path="userName" /> <sf:errors
							class="alert alert-danger" path="userName" /></td>
				</tr>
				<tr>
					<td>Password :</td>
					<td><sf:input path="password" /> <sf:errors path="password" />
					</td>
				</tr>
				<tr>
					<td>Address Line 1 :</td>
					<td><sf:input path="addressLine1" /> <sf:errors
							path="addressLine1" /></td>
				</tr>
				<tr>
					<td>Address Line 2 :</td>
					<td><sf:input path="addressLine2" /> <sf:errors
							path="addressLine2" /></td>
				</tr>
				<tr>
					<td>City :</td>
					<td><sf:input path="city" /> <sf:errors path="city" /></td>
				</tr>
				<tr>
					<td>State :</td>
					<td><sf:input path="stateName" /> <sf:errors path="stateName" />
					</td>
				</tr>
				<tr>
					<td>Country :</td>
					<td><sf:input path="country" /> <sf:errors path="country" />
					</td>
				</tr>
				<tr>
					<td>Company Name :</td>
					<td><sf:input path="organization" /> <sf:errors
							path="organization" /></td>
				</tr>
				<tr>
					<td>Phone Number :</td>
					<td><sf:input path="phoneNumber" /> <sf:errors
							path="phoneNumber" /></td>
				</tr>
				<tr>
					<td>Email Address :</td>
					<td><sf:input path="email" /> <sf:errors path="email" /></td>
				</tr>
				<tr>
					<td><input type="submit" value="Register" /></td>
				</tr>
			</table>
		</sf:form>
	</div>
</body>
</html>