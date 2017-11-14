
function changeMusic(url) {
    $('#musicUI').attr('src',url);
}

//通过url改变内容页内容
function changeMainUI(url,title) {
    $('#mainUI').attr('src',url);
    document.title = title;
    window.history.pushState(null, null, '/#'+url);
}

//点击播放音乐
function playMusic(id) {
    $.ajax({
        type: "POST",
        url: "/music/playMusic",
        data: {'id':id},
        success: function(data){
            alert(data);
            document.title = data;
            window.history.pushState(null, null, '/#/music/playMusic'+data);
            $('#musicUI').attr('src','/music');
        }
    });
}

