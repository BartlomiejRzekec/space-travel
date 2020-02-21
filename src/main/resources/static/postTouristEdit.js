$(document).ready(function () {
	
//	$('#date').datepicker({ dateFormat: 'dd-mm-yy' })
    $("#touristFormEdit").submit(function (event) {
        event.preventDefault();
        ajax_submit();
    });
});

function ajax_submit() {

    var formData = {
    		
    		id :	$("#id").val(),
    	firstName :	$("#firstName").val(),
    	lastName :	$("#lastName").val(),
    	gender :	$("#gender").val(),
    	country :	$("#country").val(),
    	notes :	$("#notes").val(),
    	birthDate :	$("#birthDate").val()
    }

    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "/saveTourist",
        data: JSON.stringify(formData),
        dataType: 'json',
        success: function (result) {
        	if(result.status == "success") {
        		$("#PostResultDiv").html(""
        			+ result.data.firstName + ", " + result.data.lastName + " added")
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