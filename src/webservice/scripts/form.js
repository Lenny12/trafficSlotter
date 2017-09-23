$.ajax({
	dataType: 'json',
    url: "http://localhost:8080/eventList",
    type: 'GET',
    success: function(resultData) {
    	var options = document.getElementById("eventDropdown");
    	resultData.forEach(function (event) {
        	var op = document.createElement("OPTION");
        	op.value = event.name;
        	op.text = event.name;
        	options.append(op);
        });
    },
    error : function(jqXHR, textStatus, errorThrown) {
    		console.log(textStatus + ' ' + errorThrown);
    },

    timeout: 120000,
});

$(function() {
	$("#getRoute").click(function() {
		var event = document.getElementById("eventDropdown");
		var xhr = new XMLHttpRequest();
	    xhr.open("POST", "http://localhost:8080/getRoute");
	    xhr.setRequestHeader('Content-Type', 'application/json; charset=UTF-8');
	    xhr.send(event.value);
	    xhr.onloadend = function (result) {
	    	console.log(result.currentTarget.response);
	    	showRoutes(JSON.parse(result.currentTarget.response));
	    };	
	})
});

function showRoutes(routes) {
	var html = '<div class=\"row\">';
	var routeNum = 1;
	var txt;
	var glyph;
	console.log(routes);
	routes.forEach(function (route) {
		if (route.color === 'red') {
			txt = 'nicht empfohlen';
			glyph = 'glyphicons/png/glyphicons-208-remove.png'; 
		} else {
			txt = 'empfohlen';
			gylph = 'glyphicons/png/glyphicons-207-ok.png';
		}
		html += '<div class=\"col-2 text-center\"><br><img src=\"'+glyph+'\"></img></span><br>'+txt+'<br>route '+routeNum+'<br>'+route.startTime+'<br>'+route.start+'<br>'+route.arrTime+'<br>'+route.dest+'</div>';
		routeNum++;
	});
	html += '</div>';
	document.getElementById("routeContainer").innerHTML=html;
}