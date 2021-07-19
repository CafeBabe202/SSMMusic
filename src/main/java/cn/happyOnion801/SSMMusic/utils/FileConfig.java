package cn.happyOnion801.SSMMusic.utils;

/**
 * Project : SSMMusic
 * Author : HappyOnion801
 * Date : 2021-06-29
 * Blog : https://www.happyOnion801.cn
 */
public class FileConfig {
    private String bathPath;
    private String musicPath;
    private String picturePath;
    private String lyricPath;
    private String videoPath;

    public String getBathPath() {
        return bathPath;
    }

    public void setBathPath(String bathPath) {
        this.bathPath = bathPath;
    }

    public String getMusicPath() {
        return musicPath;
    }

    public void setMusicPath(String musicPath) {
        this.musicPath = musicPath;
    }

    public String getPicturePath() {
        return picturePath;
    }

    public void setPicturePath(String picturePath) {
        this.picturePath = picturePath;
    }

    public String getLyricPath() {
        return lyricPath;
    }

    public void setLyricPath(String lyricPath) {
        this.lyricPath = lyricPath;
    }

    public String getVideoPath() {
        return videoPath;
    }

    public void setVideoPath(String videoPath) {
        this.videoPath = videoPath;
    }

    @Override
    public String toString() {
        return "FileConfig{" +
                "bathPath='" + bathPath + '\'' +
                ", musicPath='" + musicPath + '\'' +
                ", picturePath='" + picturePath + '\'' +
                ", lyricPath='" + lyricPath + '\'' +
                ", videoPath='" + videoPath + '\'' +
                '}';
    }
}
