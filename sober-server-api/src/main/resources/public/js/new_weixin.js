
var _hmt = _hmt || [];
(function() {
    var hm = document.createElement("script");
    hm.src = "//hm.baidu.com/hm.js?55a5855402d9f76f9739ffa75d37dfb2";
    var s = document.getElementsByTagName("script")[0];
    s.parentNode.insertBefore(hm, s);
})();

// JavaScript Document
function alert_msg(msg){
    var div =
        "<div class='fcbj' style='display:block;'>"+
            "</div>"+
            "<div class='ts_popup radius5'>"+
            "<div class='ts_info'>" +
            "<h4>温馨提示</h4>"+
            "<p>"+msg+"</p>" +
            "</div>" +
            "<div class='ts_button'>" +
            "<button class='close_alert'>确定</button>"+
            "</div>" +
            "</div>";

    $("#alert_div").html(div);
    close_alert();
}


function alert_ok(msg){
    var div =
        "<div class='fcbj' style='display:block;'>"+
            "</div>"+
            "<div class='ts_popup radius5'>"+
            "<div class='ts_info'>" +
            "<div class='success-tc-ico'>"+
            "<span></span>"+
            "</div>"+
            "<h4>"+msg+"</h4>" +
            "</div>" +
            "<div class='ts_button'>" +
            "<button class='close_alert'>确定</button>"+
            "</div>" +
            "</div>";

    $("#alert_div").html(div);
    close_alert();
}

function alert_sure(msg){
    var div =
        "<div class='fcbj' style='display:block;'></div>"+
            "<div class='ts_popup fc_none' style='width:380px; margin-left:-190px;'>"+
            "<div class='ts_info'>" +
            "<h4 style='font-size:160%'>温馨提示</h4>"+
            "<p style='margin-top:5%; margin-bottom:15%'>"+msg+"</p>"+
            "</div>" +
            "</div>";

    $("#alert_div").html(div);
}


function close_alert(){
    $(".close_alert").click(function(){
        $("#alert_div").html("");
    });
}

//提示信息  银行卡绑定和修改昵称调用
/*$(function(){
 $(".remind").click(function(){
 $(".kfh_ts .xs_info").toggle();
 $(this).toggleClass("alterbrname_nw2");
 $(this).parent().siblings().find(".remind").removeClass("alterbrname_nw2");
 });
 });*/


//绑定银行卡弹出提示信息


$(function(){
//弹出窗口
    $(".bt_click").click(function(event){
        $(".fc_none").show();
        $(".fcbj").css("display","block");
        event.stopPropagation();//阻止冒泡事件
//弹出窗口上下居中显示
        /*$(".fc_none").animate({
         "marginTop":($(window).height()-$(".fc_none").height())/2
         }, 0);*/
    });
//关闭弹出窗口	
    $(".pay_of").click(function(){
        $(".fc_none").hide();
        $(".fcbj").removeAttr("style");
    });

//点击其它区域关闭弹出窗口
//$(document).bind("click touchstart", function(e){
// e = window.event || e;
// obj = $(e.srcElement || e.target);
//    if ($(obj).is(".fc_none,.fc_none *")) {
//     //alert("内部区域");
//   } else {
// // alert("外部区域");
//$(".fc_none").hide();
//$(".fcbj").removeAttr("style");
// }
//});
})

//绑定选项卡   绑定信息选项卡
//$(function () {
//    $(".binding-Take-money-way a").each(function () {
//        $(this).click(function () {
//            var nowindex = $(this).index();
//            $(".card-way").hide();
//            $(this).addClass("way-selected").siblings("a").removeClass("way-selected")
//            $(".card-way").eq(nowindex).show();
//        });
//    });
//});

//去掉微信分享按钮
document.addEventListener('WeixinJSBridgeReady', function onBridgeReady() {
    WeixinJSBridge.call('hideOptionMenu');
});



