<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="x" uri="http://java.sun.com/jstl/xml"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jstl/sql"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Items</title>
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
	<!-- I will try to maintain a counter so that
	 I can know which is the next starting element for the request -->
	<%
		session.setAttribute("min", 0);
	%>
	<nav>
	<ul class="pager">
		<li><a href="/safeSelling/items/?min=">Previous</a></li>
		<li><a href="#">Next</a></li>
	</ul>
	</nav>
	<div class="center list">
		<table class="table table-striped list">
			<c:forEach items="${itemList}" var="item">
				<tr>
					<td>Item :</td>
					<td>${item.title}</td>
				</tr>
				<tr>
					<td>Expected Price :</td>
					<td>${item.expectedPrice}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<c:if test="${itemList==null}">
		<div class="itemMessage">
			<c:out value="${item.description}" />
		</div>
		<span class="itemTime"> <c:out value="${item.expectedPrice}"></c:out>
		</span>
		Tags attached with this product
			<c:out value="${item.tagList}"></c:out>
	</c:if>
</body>
</html>