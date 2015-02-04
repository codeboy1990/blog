$(function(){
	// 列表选中颜色
	$(".trHoverBg").mouseover(function(){  
        $(this).addClass("trBlueBg");  
    });
    $(".trHoverBg").mouseout(function(){  
        $(this).removeClass("trBlueBg");  
    });
});