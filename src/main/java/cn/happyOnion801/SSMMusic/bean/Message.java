package cn.happyOnion801.SSMMusic.bean;

import java.util.Date;

public class Message {
    private Integer messageid;

    private String messagecomment;

    private Date messagetime;

    private Integer videoid;

    private Integer uid;

    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getMessageid() {
        return messageid;
    }

    public void setMessageid(Integer messageid) {
        this.messageid = messageid;
    }

    public String getMessagecomment() {
        return messagecomment;
    }

    public void setMessagecomment(String messagecomment) {
        this.messagecomment = messagecomment == null ? null : messagecomment.trim();
    }

    public Date getMessagetime() {
        return messagetime;
    }

    public void setMessagetime(Date messagetime) {
        this.messagetime = messagetime;
    }

    public Integer getVideoid() {
        return videoid;
    }

    public void setVideoid(Integer videoid) {
        this.videoid = videoid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }
}