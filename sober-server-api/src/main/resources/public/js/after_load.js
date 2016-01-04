/**
 * Created by Lucky on 2015/4/20.
 */
function load_touch(){

    //按下背景色
    $('.Click_bj').on('touchstart',function(){
        $(this).addClass('btn02');
        this.blur();
    });

    $('.Click_bj').on('touchend',function(){
        $(this).removeClass('btn02');
    });

    //按下客服小标更换图标
    $('.Click_icon li a').on('touchstart', function () {
        $(this).addClass('replace_icon');
        this.blur();
    });
    $('.Click_icon li a').on('touchend', function () {
        $(this).removeClass('replace_icon');
    });
}


/**
 * do after load
 */
try{
    load_touch();
}catch(e) {
    console.info(e);
}