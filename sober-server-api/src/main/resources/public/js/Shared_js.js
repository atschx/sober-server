// JavaScript Document

//判别设备
var agent_str = navigator.userAgent;
var base_wid = window.screen.availWidth;

if(agent_str.indexOf("iPhone") > -1 ){
	if(base_wid<375){
		  document.write('<meta content="width=device-width,initial-scale=1.0,maximum-scale=0.45,minimum-scale=0.45,user-scalable=no" name="viewport">');		
	}else{
		  document.write('<meta content="width=device-width,initial-scale=1.0,maximum-scale=0.5,minimum-scale=0.5,user-scalable=no" name="viewport">');
	}
}else if(agent_str.indexOf("iPad") >-1){
  document.write('<meta content="width=device-width,initial-scale=1.0,maximum-scale=1.0,minimum-scale=0.5,user-scalable=no" name="viewport">');
}else if(agent_str.indexOf("iPod") >-1){
  document.write('<meta content="width=device-width,initial-scale=1.0,maximum-scale=0.5,minimum-scale=0.5,user-scalable=no" name="viewport">');
}else if(agent_str.indexOf("Android") >-1){
  document.write('<meta content="width=device-width,initial-scale=1.0,maximum-scale=0.5,minimum-scale=0.5,user-scalable=no" name="viewport">');
}

//按下背景色
$(function(){
	$('.Click_bj').on('touchstart',function(){
		$(this).addClass('btn02');
		this.blur();
	});
	$('.Click_bj').on('touchend',function(){
		$(this).removeClass('btn02');
	});
})

//按下客服小标更换图标
$(function(){
	$('.Click_icon li a').on('touchstart',function(){
		$(this).addClass('replace_icon');
		this.blur();
	});
	$('.Click_icon li a').on('touchend',function(){
		$(this).removeClass('replace_icon');
	});
	//$('.fcbj').height($(window).height());
})
//返回主页面
 $(function(){
	$('.return_link').on('touchstart',function(){
		$(this).addClass('return_link2');
		this.blur();
	});
	$('.return_link').on('touchend',function(){
		$(this).removeClass('return_link2');
	});
})