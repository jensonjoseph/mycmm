/**
 * 
 */

Date.prototype.yyyymmdd = function() {
	var yyyy = this.getFullYear().toString();
	var mm = (this.getMonth() + 1).toString(); // getMonth() is zero-based
	var dd = this.getDate().toString();

	return yyyy + '-' + (mm[1] ? mm : "0" + mm[0]) + '-'
			+ (dd[1] ? dd : "0" + dd[0]);
};

function generate_navbar(current_tab) {
	var date = new Date();
	var today = date.yyyymmdd();
	var dashboard = "Dashboard";
	var query = "Query";
	var admin = "Admin";
	var contactus = "Contact us";
	document.writeln("<div class='_branding'>");
	document.writeln("<p><b>FCA</b></p></div>");

	document.writeln("<div>");
	document.writeln("<nav class='navbar navbar-default' role='navigation'>");
	document.writeln("<div class='navbar-header'>");
	document
			.writeln("<button type='button' class='navbar-toggle collapsed'	data-toggle='collapse' data-target='#_cmm_navbar-collapse' aria-expanded='false'>");
	document.writeln("<span class='icon-bar'></span>");
	document.writeln("<span class='icon-bar'></span>");
	document.writeln("<span class='icon-bar'></span>");
	document.writeln("</button>");
	document
			.writeln("<a class='navbar-brand' href='home'><b><i>eCMM 2.0</i></b></a>");
	document.writeln("</div>");
	document
			.writeln("<div class='collapse navbar-collapse' id='_cmm_navbar-collapse'>");
	document.writeln("<ul class='nav navbar-nav navbar-right'>");
	document
			.writeln("<li id='nav_dashboard' onclick=_block_content()><a href='home?fromPage="
					+ current_tab
					+ "&dt="
					+ today
					+ "'>"
					+ dashboard
					+ "</a></li>");
	document
			.writeln("<li id='nav_query' onclick=_block_content()><a href='query?fromPage="
					+ current_tab + "&dt=" + today + "'>" + query + "</a></li>");
	document
			.writeln("<li id='nav_admin' onclick=_block_content()><a href='admin?fromPage="
					+ current_tab + "&dt=" + today + "'>" + admin + "</a></li>");
	document
			.writeln("<li id='nav_contact' onclick=_block_content()><a href='contactus?fromPage="
					+ current_tab
					+ "&dt="
					+ today
					+ "'>"
					+ contactus
					+ "</a></li>");
	document.writeln("</ul>");
	document.writeln("</div>");
	document.writeln("</nav>");
	document.writeln("</div>");
	document.writeln("<div class='_cmm_hr_split'></div>");

	$('#_cmm_navbar-collapse li').removeClass('active');

	if (typeof current_tab === 'undefined') {
		$('#nav_dashboard').addClass('active');
	} else {
		$('#' + current_tab).addClass('active');
	}
}

function _block_content() {
	$('div._page_content')
			.block(
					{
						message : '<h1><img src="style/css/images/spinner.jpeg" />Loading ...</h1>'
					});
}