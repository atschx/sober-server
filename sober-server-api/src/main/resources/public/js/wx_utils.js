//下载小兵
var download_xb_by_safari =true;
var down_xb_url = "http://yysk-itry.58.com/s/ndown.html";
var down_xb_url_by_safari = "itms-services://?action=download-manifest&url=https://down.appshike.com/plist/";
//下载应用
var download_app_by_safari =true;
var down_app_url="http://yysk-itry.58.com/s/itunes.html?a=###";
var down_app_url_by_safari = "http://itunes.apple.com/WebObjects/MZStore.woa/wa/search?clientApplication=Software&e=true&media=software&term=";
//play
var play_app_by_safari =true;
var play_480079300_url = "http://yysk-itry.58.com/s/58.html";
var play_480079300_url_by_safari = "http://yysk-itry.58.com/s/58.html";

//拉起小兵
function open_xb(){
	if($('.offline_xiaobing').length>0){
		window.now=+new Date();
		location.href = 'itry://card/show';
		window.setTimeout(function(){
			getXBStatus();
		},500);
		if(!/micromessenger/i.test(navigator.userAgent)){
			setTimeout( function(){if(+new Date()-window.now<2100){download_xb("","true"); }} , 2000);
		}
	}
}

//微信的js sdk
var menu_type = 'showOptionMenu';
function bridgeCallShowMenu(){
    menu_type = 'showOptionMenu';
    if (typeof WeixinJSBridge == "undefined"){
        if( document.addEventListener ){
            document.addEventListener('WeixinJSBridgeReady', onBridgeReady, false);
        }else if (document.attachEvent){
            document.attachEvent('WeixinJSBridgeReady', onBridgeReady);
            document.attachEvent('onWeixinJSBridgeReady', onBridgeReady);
        }
    }else{
        onBridgeReady();
    }
}

function bridgeCallHideMenu(){
    menu_type = 'hideOptionMenu';
    if (typeof WeixinJSBridge == "undefined"){
        if( document.addEventListener ){
            document.addEventListener('WeixinJSBridgeReady', onBridgeReady, false);
        }else if (document.attachEvent){
            document.attachEvent('WeixinJSBridgeReady', onBridgeReady);
            document.attachEvent('onWeixinJSBridgeReady', onBridgeReady);
        }
    }else{
        onBridgeReady();
    }
}

function onBridgeReady(){
    WeixinJSBridge.call(menu_type);
}

var tryTimes=0;
var token;
var getXBStatus = function() {
	if($('.offline_xiaobing').length>0 && tryTimes++<5){
		window.setTimeout(function(){
    		$.getJSON('/itry/xbStatus',{token:token,t:Math.random()},function(isOnline){
				if(isOnline){
					$('.msg_xiaobing').hide();
					$('.offline_xiaobing').removeClass('offline_xiaobing').addClass('online_xiaobing');
				}else{
					window.setTimeout(getXBStatus,tryTimes*1000);
				}
			});
    	},tryTimes*1000);
	}
};
function download_xb(oid_md5,is_safari){
    var data = {
    	oid_md5:oid_md5
    };
    //记录下载时IP版本号及MD5
    $.getJSON("/itry/log_download_xb",data,function(back){
        if(back.rtn>0){
        	var d_url = "";
        	if(is_safari=='true'){
        		d_url = down_xb_url_by_safari+back.binding+".plist";
        		//下载小兵
        		window.location.href= d_url;
        	}else{
        		d_url = down_xb_url;
                var link = document.createElement('a');
                link.rel='noreferrer';
                if(d_url.indexOf("?")>-1){
                	d_url += '&_='+new Date().getTime()+"&binding="+back.binding;
                }else{
                	d_url += '?_='+new Date().getTime()+"&binding="+back.binding;
                }
                link.href = d_url;
                document.body.appendChild(link);
                link.click();

        	}
        }else{
            alert("请重新打开");
        }
    },"json");
}

window.appClassCache = {'旅游':'tourism_type','游戏':'game_m','财务':'financial_m','摄影与录像':'video_m','音乐':'music_m','天气':'weather_m','效率':'efficiency_m',
		'工具':'tool_m','社交':'social_m','导航':'navigation_m','教育':'education_m','商品指南':'Commodities_guide_m','美食':'food_m','医疗':'medical_m','图书':'book_m',
		'儿童':'children_m','生活':'life_m','健康':'health_m','新闻':'news_m','参考':'reference_m','体育':'sports_m','商务':'business_m','娱乐':'entertainment_m','其他':'other_m'};

