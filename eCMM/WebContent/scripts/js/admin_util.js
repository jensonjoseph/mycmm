/**
 * 
 */
function _load_admin_content() {
	var result;

	// $.blockUI();
	$('div._page_content')
			.block(
					{
						message : '<h1><img src="style/css/images/spinner.jpeg" />Loading query...</h1>'
					});
	$.ajax({
		type : "POST",
		url : "admin_load_json",
		timeout : 1800000,
		error : function(error) {
			$('div._page_content').unblock();
			alert("Session timed out before fetching data through service"
					+ error);
		},
		success : function(responseText) {
			$('div._page_content').unblock();
			// $.unblockUI();
		}

	});
	var fromPage= $('#fromPage').val();
	if(fromPage=='none'||fromPage=='expired'){
		$('#bookmark').text($('#bookmarkurl').val());
	}
	$('div._page_content').unblock();
	return result;
}