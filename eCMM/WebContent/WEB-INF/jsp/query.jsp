<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="scripts/jquery/jquery.min.js" type="text/javascript"></script>
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="style/css/layout.css">
<script src="scripts/js/query_util.js" type="text/javascript"></script>
<script src="scripts/js/generate_navbar.js" type="text/javascript"></script>
<script src="scripts/jquery/jquery.blockUI.js" type="text/javascript"></script>
<script src="bootstrap/js/bootstrap.min.js" type="text/javascript"></script>

<link rel="stylesheet" type="text/css"
	href="//cdn.datatables.net/1.10.0/css/jquery.dataTables.css">
<script type="text/javascript"
	src="//cdn.datatables.net/1.10.0/js/jquery.dataTables.js"></script>

<script type="text/javascript">
	generate_navbar("nav_query");
	$(document).ready(function() {
		var result = _load_query_content();

		$(document).ready(function() {
			$('#example').dataTable({
				"bProcessing" : true,
				"bServerSide" : true,
				"sAjaxSource" : "server",
				"aoColumns" : [ {
					"mData" : "engine"
				}, {
					"mData" : "browser"
				}, {
					"mData" : "platform"
				}, {
					"mData" : "version"
				}, {
					"mData" : "grade"
				} ]
			});
		});

	});
</script>
<title>eCMM Query</title>
</head>
<body>
	<div class="container _dashboard_container">
		<div class="_page_content">
			Query <input type="hidden" id="fromPage" value="${pagebean.fromPage}">
			<input type="hidden" id="bookmarkurl" value="${bookmarkUrl}">
			<span id="bookmark"></span>
			<!-- Hidden form fields are used to hold value returned by server.
These values would be used by JavaScript functions.  -->


			<table id="example" class="display" cellspacing="0" width="100%">
				<thead>
					<tr>
						<th>Engine</th>
						<th>Browser</th>
						<th>Platform</th>
						<th>Version</th>
						<th>Grade</th>
					</tr>
				</thead>
			</table>
		</div>

		<div class="_sidebar">

			<ul id="sbnavlist" class="nav nav-pills nav-stacked">
				<li role="presentation"><a href="#">Q Link 1</a></li>
				<li role="presentation"><a href="#">Q Link 2</a></li>
				<li role="presentation"><a href="#">Q Link 3</a></li>
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