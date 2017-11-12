/**
 * Created by 白风和 on 2017/11/11.
 */
$(function () {
    //加载首页时初始化音乐播放器
    $('#musicUI').attr('src','/music');

    //加载首页时初始化内容页
    $('#mainUI').attr('src','/main');


});

function changeMusic(url) {
    //http://www.runoob.com/
    $('#musicUI').attr('src',url);
}

function changeMainUI(url) {
    //http://www.runoob.com/
    $('#mainUI').attr('src',url);
}