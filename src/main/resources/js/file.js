
$(document).ready(function() {
	$("[data-file-field]").change(function(evt) {
		// do stuff...
		var fileDetails = {};
		$("[data-file-field]").each(function(idx,itm){
			var item = $(itm);
			if( item.attr("type") == "checkbox" ) {
				fileDetails[item.data("file-field")] = item.is(":checked");
			} else {
				fileDetails[item.data("file-field")] = item.val();
			}
		});
		
		$.ajax({
			type: "PUT",
			url: fileUrl,
			data: JSON.stringify(fileDetails),
			dataType: "json",
			contentType: "application/json",
			success: function(response) {
				alert(response);
			}
		});
		
	});
});