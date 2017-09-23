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

function tada(s,d) {
		var event = s
		var location = d;
		var xhr = new XMLHttpRequest();
	    xhr.open("POST", "http://localhost:8080/getRoute");
	    xhr.setRequestHeader('Content-Type', 'application/json; charset=UTF-8');
	    console.log(event.value+','+location.value);
	    xhr.send(event.value+','+location.value);
	    
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
			glyph = '#fa8258'; 
		} else {
			txt = 'empfohlen';
			glyph = '#58fa58';
		}
		html += '<div class="card" style="width: 10rem; opacity: 0.85; border-style: none; outline-offset: 15px; margin: 15px;"><br><div style="background-color:'+glyph+';"><p style="margin: 12px;">'+txt+'</p></div><div style="margin-left: 12px;margin-bottom: 8px;">route '+routeNum+'<br>'+route.startTime+'<br>'+route.start+'<br>'+route.arrTime+'<br>'+route.dest+'</div></div>';
		routeNum++;
	});
	html += '</div>';
	document.getElementById("routeContainer").innerHTML=html;
}