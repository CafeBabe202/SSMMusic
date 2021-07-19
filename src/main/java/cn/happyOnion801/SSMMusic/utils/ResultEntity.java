package cn.happyOnion801.SSMMusic.utils;

/**
 * Project : SSMMusic
 * Author : HappyOnion801
 * Date : 2021-06-25
 * Blog : https://www.happyOnion801.cn
 */
public class ResultEntity {
    private int status;
    private String msg;
    private Object date;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getDate() {
        return date;
    }

    public void setDate(Object date) {
        this.date = date;
    }
}
