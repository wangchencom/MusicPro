package com.bfh.vo;

/**
 * @Author wcc
 * @Time 2019/09/24
 */

public class Song {

    private String title;//歌曲名
    private String artist;//歌手
    private String mp3;//音乐路径
    private String poster;//封面

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getMp3() {
        return mp3;
    }

    public void setMp3(String mp3) {
        this.mp3 = mp3;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }
}
