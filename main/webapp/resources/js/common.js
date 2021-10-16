let page = 1;
$(function() {
	getBlog();
	
	$("#button").click(function() {
		getBlog();
	});
});
function getBlog() {
	page = page || 1;
	$.ajax({
		url : "/Exblog/blog/view.jsp",
		type : "get",
		data : { page : page },
		dataType :  "html",
		success : function (res) {
			const st = $("#blog_post").height();
			if (res.trim() == "") {
				$("#button").remove();
				return;
			}
			$("#blog_post").append(res);
			page++;
			
			$("html, body").animate({scrollTop : st + "px"}, 1000);
		},
		error : function(err) {
			console.error(err);		
		}
	}); 
}