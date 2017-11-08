var songsList = null;
var playlistOptions = null;
var myPlaylist = null;
var json = null;

$(document).ready(function(){

  //用ajax从服务器获取songsList
  // songsList = [
  //   {
  //     title:"China-P",
  //     artist:"徐梦圆",
  //     mp3:"music/徐梦圆 - China-P.mp3",
  //     poster: "images/m0.jpg"
  //   }
  // ];


    //获取歌曲列表并初始化播放器
    $.get("/getSongs", function(data){

        if (data.length === 0) {//默认歌曲列表
            songsList = [
              {
                title:"China-P",
                artist:"徐梦圆",
                mp3:"music/徐梦圆 - China-P.mp3",
                poster: "images/m0.jpg"
              }
            ];
            playlistOptions = {
                enableRemoveControls: true,
                autoPlay: false//自动播放
            };
        } else {
            json = JSON.stringify(data);
            songsList = JSON.parse(json);
            playlistOptions = {
                enableRemoveControls: true,
                autoPlay: false//自动播放
            };
        }


        initJPlayer(songsList, playlistOptions);

    });


});



//初始化播放器
function initJPlayer(songsList, playlistOptions) {

    myPlaylist = new jPlayerPlaylist({
            jPlayer: "#jplayer_N",
            cssSelectorAncestor: "#jp_container_N"
        },
        songsList,
        {
            playlistOptions: playlistOptions,
            swfPath: "js/jPlayer",
            supplied: "webmv, ogv, m4v, oga, mp3",
            smoothPlayBar: true,
            keyEnabled: true,
            audioFullScreen: false
        });

    //初始化按钮时间按钮事件
    $(document).on($.jPlayer.event.pause, myPlaylist.cssSelector.jPlayer,  function(){
        $('.musicbar').removeClass('animate');
        $('.jp-play-me').removeClass('active');
        $('.jp-play-me').parent('li').removeClass('active');
    });

    $(document).on($.jPlayer.event.play, myPlaylist.cssSelector.jPlayer,  function(){
        $('.musicbar').addClass('animate');
    });

    $(document).on('click', '.jp-play-me', function(e){
        e && e.preventDefault();
        var $this = $(e.target);
        if (!$this.is('a')) $this = $this.closest('a');

        $('.jp-play-me').not($this).removeClass('active');
        $('.jp-play-me').parent('li').not($this.parent('li')).removeClass('active');

        $this.toggleClass('active');
        $this.parent('li').toggleClass('active');
        if( !$this.hasClass('active') ){
            myPlaylist.pause();
        }else{
            var i = Math.floor(Math.random() * (1 + 7 - 1));
            myPlaylist.play(i);
        }

    });
}