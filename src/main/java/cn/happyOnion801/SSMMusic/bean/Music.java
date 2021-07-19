package cn.happyOnion801.SSMMusic.bean;

import java.util.Date;

public class Music {
    private Integer musicid;

    private String musicname;

    private String musicphotourl;

    private Integer singerid;

    private String singerName;

    private Integer musichot;

    private String lyricurl;

    private Integer musictypeid;

    private String musicTypeName;

    private String songurl;

    private Date time;

    private String musictime;

    public Integer getMusicid() {
        return musicid;
    }

    public void setMusicid(Integer musicid) {
        this.musicid = musicid;
    }

    public String getMusicname() {
        return musicname;
    }

    public void setMusicname(String musicname) {
        this.musicname = musicname;
    }

    public String getMusicphotourl() {
        return musicphotourl;
    }

    public void setMusicphotourl(String musicphotourl) {
        this.musicphotourl = musicphotourl;
    }

    public Integer getSingerid() {
        return singerid;
    }

    public void setSingerid(Integer singerid) {
        this.singerid = singerid;
    }

    public String getSingerName() {
        return singerName;
    }

    public void setSingerName(String singerName) {
        this.singerName = singerName;
    }

    public Integer getMusichot() {
        return musichot;
    }

    public void setMusichot(Integer musichot) {
        this.musichot = musichot;
    }

    public String getLyricurl() {
        return lyricurl;
    }

    public void setLyricurl(String lyricurl) {
        this.lyricurl = lyricurl;
    }

    public Integer getMusictypeid() {
        return musictypeid;
    }

    public void setMusictypeid(Integer musictypeid) {
        this.musictypeid = musictypeid;
    }

    public String getMusicTypeName() {
        return musicTypeName;
    }

    public void setMusicTypeName(String musicTypeName) {
        this.musicTypeName = musicTypeName;
    }

    public String getSongurl() {
        return songurl;
    }

    public void setSongurl(String songurl) {
        this.songurl = songurl;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getMusictime() {
        return musictime;
    }

    public void setMusictime(String musictime) {
        this.musictime = musictime;
    }

    @Override
    public String toString() {
        return "Music{" +
                "musicid=" + musicid +
                ", musicname='" + musicname + '\'' +
                ", musicphotourl='" + musicphotourl + '\'' +
                ", singerid=" + singerid +
                ", singerName='" + singerName + '\'' +
                ", musichot=" + musichot +
                ", lyricurl='" + lyricurl + '\'' +
                ", musictypeid=" + musictypeid +
                ", musicTypeName='" + musicTypeName + '\'' +
                ", songurl='" + songurl + '\'' +
                ", time=" + time +
                ", musictime='" + musictime + '\'' +
                '}';
    }
}