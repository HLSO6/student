package com.hnxy.entity;

/**
 * @author 陆辉
 * @create 2020-07-17 22:02
 */
public class School {
    private Integer scid;
    private String scname;

    public Integer getScid() {
        return scid;
    }

    public void setScid(Integer scid) {
        this.scid = scid;
    }

    public String getScname() {
        return scname;
    }

    public void setScname(String scname) {
        this.scname = scname;
    }

    @Override
    public String toString() {
        return "School{" +
                "scid=" + scid +
                ", scname='" + scname + '\'' +
                '}';
    }
}
