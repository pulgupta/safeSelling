<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Your Profile Picture</title>
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" />
<link rel="stylesheet" href="/safeSelling/scripts/styleSheets/myStyles.css" />

<!-- load angular via CDN -->
<script src="//code.angularjs.org/1.3.0-rc.1/angular.js"></script>
<script src="//code.angularjs.org/1.3.0-rc.1/angular-route.js"></script>
<script src="/safeSelling/scripts/js/myApp.js" type='text/javascript'></script>

</head>
<body>
	<jsp:include page="header.jsp" />
	<sf:form method="POST" commandName="filePicker" action="/safeSelling/user/register/picture"
		enctype="multipart/form-data">
		<c:out value="${userName}"></c:out>
		Please select a file to upload : <input type="file" name="file" /> <br />
		<input type="hidden" name="userName" value="<c:out value="${userName}"></c:out>" /> <input
			type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
		<input type="submit" value="upload" />
	</sf:form>
</body>
</html>