<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="scripts/jquery/jquery.min.js" type="text/javascript"></script>
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="style/css/layout.css">
<script src="scripts/js/dashboard_util.js" type="text/javascript"></script>
<script src="scripts/js/generate_navbar.js" type="text/javascript"></script>
<script src="scripts/jquery/jquery.blockUI.js" type="text/javascript"></script>
<script src="bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
<script type="text/javascript">
	generate_navbar("nav_dashboard");
	$(document).ready(function() {
		_load_dashboard_content();
	});
</script>
<title>eCMM Dashboard</title>
</head>


<body>
	<div class="container _dashboard_container">
		<div class="_page_content">
			My Home <input type="hidden" id="fromPage"
				value="${pagebean.fromPage}"> <input type="hidden"
				id="bookmarkurl" value="${bookmarkUrl}"> <span id="bookmark"></span>
			<!-- Hidden form fields are used to hold value returned by server.
These values would be used by JavaScript functions.  -->
		</div>











		<div class="_sidebar">

			<ul id="sbnavlist" class="nav nav-pills nav-stacked">
				<li role="presentation"><a href="#">Link 1</a></li>
				<li role="presentation"><a href="#">Link 2</a></li>
				<li role="presentation"><a href="#">Link 3</a></li>
			</ul>
			<br>
			<!-- Split button -->
			<div class="btn-group">
				<button type="button" class="btn btn-default">Action</button>
				<button type="button" class="btn btn-default dropdown-toggle"
					data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
					<span class="caret"></span> <span class="sr-only">Toggle
						Dropdown</span>
				</button>
				<ul class="dropdown-menu">
					<li><a href="#">Temp override</a></li>
					<li role="separator" class="divider"></li>
					<li><a href="#">Permanent Override</a></li>
				</ul>
			</div>
		</div>

	</div>
</body>
</html>