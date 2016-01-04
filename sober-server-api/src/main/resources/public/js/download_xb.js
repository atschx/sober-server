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