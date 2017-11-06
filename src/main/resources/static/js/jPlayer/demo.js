$(document).ready(function(){


  //用ajax从服务器获取songsList
  //springmvc返回的要是json格式，而不是String格式

  var songsList = [
    {
      title:"China-P",
      artist:"徐梦圆",
      mp3:"music/徐梦圆 - China-P.mp3",
      poster: "images/m0.jpg"
    }
  ];

  var playlistOptions = {
      enableRemoveControls: true,
      autoPlay: false//自动播放
    };


  //初始化播放器
  var myPlaylist = new jPlayerPlaylist({
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



  // video

  // $("#jplayer_1").jPlayer({
  //   ready: function () {
  //     $(this).jPlayer("setMedia", {
  //       title: "这是什么",
  //       m4v: "E:/浏览器下载/web/五月天-好好.mp3",
  //       ogv: "E:/浏览器下载/web/五月天-好好.mp3",
  //       webmv: "E:/浏览器下载/web/五月天-好好.mp3",
  //       poster: "images/m41.jpg"
  //     });
  //   },
  //   swfPath: "js",
  //   supplied: "webmv, ogv, m4v",
  //   size: {
  //     width: "100%",
  //     height: "auto",
  //     cssClass: "jp-video-360p"
  //   },
  //   globalVolume: true,
  //   smoothPlayBar: true,
  //   keyEnabled: true
  // });

});