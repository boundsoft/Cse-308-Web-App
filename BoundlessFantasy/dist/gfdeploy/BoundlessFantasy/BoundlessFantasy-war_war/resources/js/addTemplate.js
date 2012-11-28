$(document).ready(function(){
	var siteName = "Boundless Fantasy: Football";
	var headerName = "Boundless Fantasy &trade;: Football"; 
	document.title = siteName;
	$.get('templates/header.html',function(data){
		$("#site").prepend(data);
		$(".site-title").html(headerName);
	});
	$.get('templates/footer.html',function(data){
		$("#site").append(data);
		});
});