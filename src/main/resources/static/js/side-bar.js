$(document).ready(function(){
	sideBarSizeControl();
	
	$(window).resize(function(){
		sideBarSizeControl();
	})
	function sideBarSizeControl(){
		$(".side-bar").css("height", $(window).innerHeight() - $(".admin-header-wrap").height());
	}
});