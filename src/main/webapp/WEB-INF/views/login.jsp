
<html>
<head>
<title>SS | Please login to continue</title>
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" />
<link rel="stylesheet"
	href="/safeSelling/scripts/styleSheets/myStyles.css" />

<!-- load angular via CDN -->
<script src="//code.angularjs.org/1.3.0-rc.1/angular.js"></script>
<script src="//code.angularjs.org/1.3.0-rc.1/angular-route.js"></script>
<script src="/safeSelling/scripts/js/myApp.js" type='text/javascript'></script>
</head>
<body onload='document.f.username.focus();'>
	<jsp:include page="header.jsp" />
	<br/><br/>
	<div style =" width:40%" class="center">
		<form name='f' action='/safeSelling/login' method='POST'>
			<div class="form-group">
				<label for="exampleInputEmail1">User Name : </label> <input
					type="text" class="form-control" name="username"
					placeholder="user name">
			</div>
			<div class="form-group">
				<label for="exampleInputPassword1">Password</label> <input
					type="password" class="form-control" name="password"
					placeholder="Password">
			</div>

			<button type="submit" class="btn btn-default">Submit</button>
			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />
		</form>
	</div>
	<%
		if (request.getParameter("error") != null && request.getParameter("error").equals("true")) {
	%>
	<div class="alert alert-danger" role="alert" align="center">You
		have entered a wrong Username or Password.</div>
	<%
		}
	%>

</body>
</html>