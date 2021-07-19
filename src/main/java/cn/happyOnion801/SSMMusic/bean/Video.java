package cn.happyOnion801.SSMMusic.bean;

import java.util.Date;

public class Video {
    private Integer videoid;

    private String videoname;

    private String videoauthor;

    private String videophoto;

    private String videourl;

    private Date videotime;

    public Integer getVideoid() {
        return videoid;
    }

    public void setVideoid(Integer videoid) {
        this.videoid = videoid;
    }

    public String getVideoname() {
        return videoname;
    }

    public void setVideoname(String videoname) {
        this.videoname = videoname == null ? null : videoname.trim();
    }

    public String getVideoauthor() {
        return videoauthor;
    }

    public void setVideoauthor(String videoauthor) {
        this.videoauthor = videoauthor == null ? null : videoauthor.trim();
    }

    public String getVideophoto() {
        return videophoto;
    }

    public void setVideophoto(String videophoto) {
        this.videophoto = videophoto == null ? null : videophoto.trim();
    }

    public String getVideourl() {
        return videourl;
    }

    public void setVideourl(String videourl) {
        this.videourl = videourl == null ? null : videourl.trim();
    }

    public Date getVideotime() {
        return videotime;
    }

    public void setVideotime(Date videotime) {
        this.videotime = videotime;
    }
}