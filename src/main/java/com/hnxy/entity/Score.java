package com.hnxy.entity;

/**
 * 科目分数
 * @author 陆辉
 * @create 2020-07-17 14:11
 */
public class Score {
    private String suname;
    private Integer rscore;

    public String getSuname() {
        return suname;
    }

    public void setSuname(String suname) {
        this.suname = suname;
    }



    public Integer getRscore() {
        return rscore;
    }

    public void setRscore(Integer rscore) {
        this.rscore = rscore;
    }
    @Override
    public String toString() {
        return "Score{" +
                "suname='" + suname + '\'' +
                ", rscore=" + rscore +
                '}';
    }
}
