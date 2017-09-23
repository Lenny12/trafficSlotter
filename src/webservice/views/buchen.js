function setHeader() {
	var url = window.location.href;
	console.log(url);
	var searchParams = new URLSearchParams(url);
	var c = searchParams.get("event");
	document.getElementById("title").innerHTML=c;
};
setHeader();