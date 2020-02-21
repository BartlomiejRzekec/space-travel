$(document).ready(function () {

    $("#flightForm").submit(function (event) {
        event.preventDefault();
        ajax_submit();
    });
});

function ajax_submit() {

    var formData = {
    		ticketPrice : $("#ticketPrice").val()
    }

    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "/saveFlight",
        data: JSON.stringify(formData),
        dataType: 'json',
        success: function (result) {
        	if(result.status == "success") {
        		$("#PostResultDiv").html(""
        			 + " added")
        	} else {
        		$("#PostResultDiv").html("error")
        	}
        	console.log(result);
        },
        error: function (e) {
            var json = "<h4>Ajax Response</h4>&lt;pre&gt;"
                + e.responseText + "&lt;/pre&gt;";
            $('#PostResultDiv').html(json);
            console.log("ERROR : ", e);
        }
    });
}