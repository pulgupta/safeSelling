<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app="myApp">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" />
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.8/angular.min.js"></script>
<script src="/safeSelling/scripts/js/myApp.js" type='text/javascript'></script>
</head>
<body>
	<nav class="navbar navbar-default">
	<div class="container-fluid">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
				aria-expanded="false">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="/safeSelling">Sell Safe</a>
		</div>

		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">

			<!-- Search for items on this site -->
			<form class="navbar-form navbar-left" role="search" action="/safeSelling/items/search">
				<div class="form-group">
					<input type="text" class="form-control" placeholder="Search" name="tags">
					<input type="hidden" name = "min" value="0"/>
					<input type="hidden" name = "count" value="10"/>
				</div>
				<button type="submit" class="btn btn-default">Submit</button>
			</form>
			<!-- calling the rest service to get the username of the logged in user -->
			<!-- Link section -->

			<div ng-controller="getUserName">
				<div ng-show="! showProfile">
					<ul class="nav navbar-nav">
						<li class="active"><a href="/safeSelling/login">Login<span
								class="sr-only">(current)</span></a></li>
						<li><a href="/safeSelling/user/register">Sign Up</a></li>
					</ul>
				</div>
				<div ng-show="showProfile">
					<ul class="nav navbar-nav">
						<li class="active"><a href="/safeSelling/user/profile">Hello
								{{user.userName}}<span class="sr-only">(current)</span>
						</a></li>
						<li><a href="/safeSelling/items">Review Items</a></li>
						<li><a href="/safeSelling/items/add">Add Items</a></li>
						<li><form class="navbar-form navbar-left" method="POST"
								action="/safeSelling/logout">
								<button type="submit" class="btn btn-default">Logout</button>
								<!-- This token is always included so that we can leverage the default  
									spring checks for csrf-->
								<input type="hidden" name="${_csrf.parameterName}"
									value="${_csrf.token}" />
							</form></li>
					</ul>
				</div>
			</div>
			<!-- 
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-haspopup="true"
						aria-expanded="false">Dropdown <span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="#">Action</a></li>
							<li><a href="#">Another action</a></li>
							<li><a href="#">Something else here</a></li>
							<li role="separator" class="divider"></li>
							<li><a href="#">Separated link</a></li>
							<li role="separator" class="divider"></li>
							<li><a href="#">One more separated link</a></li>
						</ul></li> -->

			<!-- Unused links
				<ul class="nav navbar-nav navbar-right">
					<li><a href="#">Link</a></li>
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-haspopup="true"
						aria-expanded="false">Dropdown <span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="#">Action</a></li>
							<li><a href="#">Another action</a></li>
							<li><a href="#">Something else here</a></li>
							<li role="separator" class="divider"></li>
							<li><a href="#">Separated link</a></li>
						</ul></li>
				</ul> -->
		</div>
		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container-fluid --> </nav>

</body>
</html>