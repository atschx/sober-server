/**
 * Created with IntelliJ IDEA.
 * User: gzy
 * Date: 13-12-4
 * Time: 下午4:01
 * To change this template use File | Settings | File Templates.
 */

/**
 * 判断是否为空
 * 空：返回true
 * @param input
 * @return {boolean}
 */
function isNull(input){
    var flag = false;
    if(input==undefined||input==null||input.length==0)
        flag = true;
    return flag;
}
/**
 * 判断是否为数字
 * 是数字或者空：返回true
 * @param input
 * @return {boolean}
 */
function isNumber(input){
    var flag = true;
    if(!isNull(input)){
        if(isNaN(input))
            flag = false;
    }
    return flag;
}
/**
 * 判断是否是整数
 * 空或者整数：true
 * @param input
 * @return {boolean}
 */
function isInteger(input){
    var flag = true;
    if(!isNull(input)){
        if(!/^-?\d+$/.test(input))
            flag = false;
    }
    return flag;
}
/**
 * 判断是否是浮点数
 * 是或者空：true
 * @param input
 * @return {boolean}
 */
function isFloat(input){
    var flag = true;
    if(!isNull(input)){
        if(!/^(-?\d+)(\.\d+)?$/.test(input))
            flag = false;
    }
    return flag;
}
/**
 * 判断是否是IP地址
 * 空或者是IP地址：true
 * @param input
 * @return {boolean}
 */
function isIP(input){
    var flag = true;
    if(!isNull(input)){
        if(!/^(25[0-5]|2[0-4][0-9]|[0-1]{1}[0-9]{2}|[1-9]{1}[0-9]{1}|[1-9])\.(25[0-5]|2[0-4][0-9]|[0-1]{1}[0-9]{2}|[1-9]{1}[0-9]{1}|[1-9]|0)\.(25[0-5]|2[0-4][0-9]|[0-1]{1}[0-9]{2}|[1-9]{1}[0-9]{1}|[1-9]|0)\.(25[0-5]|2[0-4][0-9]|[0-1]{1}[0-9]{2}|[1-9]{1}[0-9]{1}|[0-9])$/.test(input))
            flag = false;
    }
    return flag;
}
/**
 * 判断身份证号码
 * 空或者正确：true
 * @param idNumber
 * @return {boolean}
 */
function isIdCardNo(idNumber){
    var flag = true;
    if(!isNull(idNumber)){
        var factorArr = new Array(7,9,10,5,8,4,2,1,6,3,7,9,10,5,8,4,2,1);
        var varArray = new Array();
        var lngProduct = 0;
        var intCheckDigit;

        if ((idNumber.length != 15) && (idNumber.length != 18)){
            return false;
        }
        for(i=0;i<idNumber.length;i++){
            varArray[i] = idNumber.charAt(i);
            if ((varArray[i] < '0' || varArray[i] > '9') && (i != 17)){
                return false;
            }else if (i < 17){
                varArray[i] = varArray[i]*factorArr[i];
            }
        }
        if (idNumber.length == 18){
            var date8 = idNumber.substring(6,14);
            if (isDate2(date8) == false){
                return false;
            }
            for(i=0;i<17;i++){
                lngProduct = lngProduct + varArray[i];
            }
            intCheckDigit = 12 - lngProduct % 11;
            switch (intCheckDigit){
                case 10:
                    intCheckDigit = 'X';
                    break;
                case 11:
                    intCheckDigit = 0;
                    break;
                case 12:
                    intCheckDigit = 1;
                    break;
            }
            if (varArray[17].toUpperCase() != intCheckDigit){
                return false;
            }
        }else{
            var date6 = idNumber.substring(6,12);
            if (isDate2(date6) == false){
                flag = false;
            }
        }
    }
    return flag;
}
/**
 * 判断是否符合QQ号格式
 * 空或者QQ号：true
 * @param input
 * @return {boolean}
 */
function isQQ(input){
    var flag = true;
    if(!isNull(input)){
        if(!/^[1-9]\d{4,10}$/.test(input))
            flag = false;
    }
    return flag;
}
/**
 * 判断电话号码格式[101-****-*******]
 * 空或者符合格式：true
 * @param input
 * @return {boolean}
 */
function isPhone(input){
    var flag = true;
    if(!isNull(input)){
        if(!/^(0[1-9]\d{1,2}-)\d{7,8}(-\d{1,8})?/.test(input))
            flag = false;
    }
    return flag;
}
/**
 * 判断是否是手机号码
 * 空或者手机号码：true
 * @param input
 * @return {boolean}
 */
function isMobile(input){
    var flag = true;
    if(!isNull(input)){
        if(!/^(13\d{9})|(15\d{9})|(18\d{9})|(0\d{10,11})$/.test(input))
            flag = false;
    }
    return flag;
}
/**
 * 判断是否是邮编
 * 空或者邮编：true
 * @param input
 * @return {boolean}
 */
function isPost(input){
    var flag = true;
    if(!isNull(input)){
        if(!/^\d{1,6}$/.test(input))
            flag = false;
    }
    return flag;
}
/**
 * 判断字符串长度是否在length范围内
 * 是或者空：true
 * @param input
 * @param length
 * @return {boolean}
 */
function isInRange(input,length){
    var flag = true;
    if(!isNull(input)){
        if(input.length<=length)
        flag = false;
    }
    return flag;
}
/**
 * 根据type的形式判断日期
 * 空或者符合形式：true
 * @param input
 * @param type
 * @return {boolean}
 */
function isDate(input,type){
    var flag = true;
    if(!isNull(input)){
        var reg = /^((((1[6-9]|[2-9]\d)\d{2})-(0?[13578]|1[02])-(0?[1-9]|[12]\d|3[01]))|(((1[6-9]|[2-9]\d)\d{2})-(0?[13456789]|1[012])-(0?[1-9]|[12]\d|30))|(((1[6-9]|[2-9]\d)\d{2})-0?2-(0?[1-9]|1\d|2[0-8]))|(((1[6-9]|[2-9]\d)(0[48]|[2468][048]|[13579][26])|((16|[2468][048]|[3579][26])00))-0?2-29-))$/;
        if(!isNull(type)){
            if("YYYY/MM/DD"==type.toUpperCase())
                reg = /^((((1[6-9]|[2-9]\d)\d{2})\/(0?[13578]|1[02])\/(0?[1-9]|[12]\d|3[01]))|(((1[6-9]|[2-9]\d)\d{2})\/(0?[13456789]|1[012])-(0?[1-9]|[12]\d|30))|(((1[6-9]|[2-9]\d)\d{2})-0?2-(0?[1-9]|1\d|2[0-8]))|(((1[6-9]|[2-9]\d)(0[48]|[2468][048]|[13579][26])|((16|[2468][048]|[3579][26])00))-0?2-29-))$/;
            else if("YYYYMMDD"==type.toUpperCase())
                reg = /^((((1[6-9]|[2-9]\d)\d{2})(0?[13578]|1[02])(0?[1-9]|[12]\d|3[01]))|(((1[6-9]|[2-9]\d)\d{2})(0?[13456789]|1[012])-(0?[1-9]|[12]\d|30))|(((1[6-9]|[2-9]\d)\d{2})-0?2-(0?[1-9]|1\d|2[0-8]))|(((1[6-9]|[2-9]\d)(0[48]|[2468][048]|[13579][26])|((16|[2468][048]|[3579][26])00))-0?2-29-))$/;
        }
        if(!reg.test(input)){
            flag = false;
        }
    }
    return flag;
}

function isDate2(dateStr){
	var dateInfo = dateStr.match(/(\d{4})(\d{2})(\d{2})/);
	var tmpDate = new Date(dateInfo[1],dateInfo[2]-1,dateInfo[3]);
	return tmpDate.getFullYear()==dateInfo[1] && tmpDate.getMonth()+1==dateInfo[2] && tmpDate.getDate()==dateInfo[3];
}
/**
 * 判断是否是汉字
 * 空或者是汉字：true
 * @param input
 * @return {boolean}
 */
function isChinese(input){
    var flag = true;
    if(!isNull(input)){
        if (!(/^[\u4E00-\uFA29]*$/.test(input)&&(!/^[\uE7C7-\uE7F3]*$/.test(input))))
            flag = false;
    }
    return flag;
}
/**
 * 判断字符串含有 汉字和数字
 * @param input
 * @return {boolean}
 */
function isChineseOrNum(input){
    var flag = true;
    if(!isNull(input)){
        input = input.replace(/\d+/g,'');
        if (!(/^[\u4E00-\uFA29]*$/.test(input)&&(!/^[\uE7C7-\uE7F3]*$/.test(input))))
            flag = false;
    }
    return flag;
}
/**
 * 过滤掉字符串头和尾的空格,空了返回null
 * @param input
 * @return {*}
 */
function trimSpace(input){
    if(!isNull(input)){
        input.replace(/(^\s*)|(\s*$)/g, '');
    }
    return input;
}
/**
 * 过滤字符串左边空格
 * @param input
 * @return {*}
 */
function trimSpaceLeft(input){
    if(!isNull(input)){
        input.replace(/^\s*/g, '');
    }
    return input;
}
/**
 * 过滤字符串右边数据
 * @param input
 * @return {*}
 */
function trimSpaceRight(input){
    if(!isNull(input)){
        input.replace(/\s*$/, '');
    }
    return input;
}
/**
 * 判断是否是链接
 * 空或者链接，返回true
 * @param input
 * @return {boolean}
 */
function isUrl(input){
    var flag = true;
    if(!isNull(input)){
        var re = new RegExp("^((https|http|ftp|rtsp|mms)://)?[a-z0-9A-Z]{3}\.[a-z0-9A-Z][a-z0-9A-Z]{0,61}?[a-z0-9A-Z]\.com|net|cn|cc (:s[0-9]{1-4})?/$");
        if (!re.test(input))
            flag = false;
    }
    return flag;
}
/**
 * 判断是否是Email
 * 空或者是，返回true
 * @param input
 * @return {boolean}
 */
function isEmail(input) {
    var flag = true;
    if(!isNull(input)){
        input = input.substring(0,input.indexOf("@")).replace(".","").replace(".","")
            .replace(".","").replace(".","").replace(".","").replace(".","").replace(".","")
            +input.substring(input.indexOf("@"),input.length).replace("-","");

        var reg = /^\w{1,30}(?:@(?!-))(?:(?:[a-z0-9-]*(?:[a-z0-9](?!-))(?:\.(?!-))))+[a-z]{2,4}$/;
        if (!reg.test(input))
            flag = false;

    }
    return flag;
}

//这是有设定过期时间的使用示例：
//s20是代表20秒
//h是指小时，如12小时则是：h12
//d是天数，30天则：d30
//m是分钟
function setCookie(name,value,time){
    var strsec = getsec(time);
    var exp = new Date();
    exp.setTime(exp.getTime() + strsec*1);
    document.cookie = name + "="+ escape (value) + ";expires=" + exp.toGMTString();
}
function getsec(str){
    var str1=str.substring(1,str.length)*1;
    var str2=str.substring(0,1);
    if (str2=="s"){
        return str1*1000;
    }else if (str2=="m"){
        return str1*60*1000;
    }else if (str2=="h"){
        return str1*60*60*1000;
    }else if (str2=="d"){
        return str1*24*60*60*1000;
    }
}
function getCookie(name){
    var arr,reg=new RegExp("(^| )"+name+"=([^;]*)(;|$)");

    if(arr=document.cookie.match(reg))
        return (arr[2]);
    else
        return null;
}
function delCookie(name){
    var exp = new Date();
    exp.setTime(exp.getTime() - 1);
    var cval=getCookie(name);
    if(cval!=null)
        document.cookie= name + "="+cval+";expires="+exp.toGMTString();
}

function error_warming(info){
    if(isNull(info))
        info = "网络错误 请重新打开";
    var error_info = '<div class="web_loading cf"><p>'+info+'</p><p><img src="/weixin/app/images/xiaobing_loading.jpg" alt=""/></p></div>';
    $(' .wrap').html(error_info);
}