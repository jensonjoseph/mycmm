/**
 * 
 */

$(document).ready(function() {
		var result = _load_query_content();
	});
function _load_query_content() {
	var result;

	// $.blockUI();
	$('div._page_content')
			.block(
					{
						message : '<h1><img src="style/css/images/spinner.jpeg" />Loading query...</h1>'
					});
//	$.ajax({
//		type : "POST",
//		url : "load_query_content",
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
		$('#bookmark').text($('#bookmarkurl').val());
	}
	
	
	//adding some content to page using JQuery
	$('#usr').val("Jenson");
	
	$('div._page_content').unblock();
	return result;
}