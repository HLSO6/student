package com.hnxy.entity;

/**
 * @author 陆辉
 * @create 2020-07-17 21:09
 */
public class Area {
    private Integer aid;
    private String aname;

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    @Override
    public String toString() {
        return "Area{" +
                "aid=" + aid +
                ", aname='" + aname + '\'' +
                '}';
    }
}
