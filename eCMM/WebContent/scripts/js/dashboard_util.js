/**
 * 
 */
function _load_dashboard_content() {
	var result;

	// $.blockUI();
	$('div._page_content')
			.block(
					{
						message : '<h1><img src="style/css/images/spinner.jpeg" />Loading dashboard...</h1>'
					});
//	$.ajax({
//		type : "POST",
//		url : "home",
//		timeout : 1800000,
//		error : function(error) {
//			$('div._page_content').unblock();
//			alert("Session timed out before fetching data through service"
//					+ error);
//		},
//		success : function(responseText) {
//			$('div._page_content').unblock();
//			// $.unblockUI();
//		}
//
//	});
	var fromPage= $('#fromPage').val();
	if(fromPage=='none'||fromPage=='expired'){
		//$('#bookmark').text("Please update your bookmark to http://localhost:8080/eCMM/home");
	}
	$('div._page_content').unblock();
	return result;
}