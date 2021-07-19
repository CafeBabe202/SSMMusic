package cn.happyOnion801.SSMMusic.bean;

public class Musictype {
    private Integer musictypeid;

    private String musictypename;

    public Integer getMusictypeid() {
        return musictypeid;
    }

    public void setMusictypeid(Integer musictypeid) {
        this.musictypeid = musictypeid;
    }

    public String getMusictypename() {
        return musictypename;
    }

    public void setMusictypename(String musictypename) {
        this.musictypename = musictypename == null ? null : musictypename.trim();
    }
}