package com.hnxy.entity;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 学员信息
 * @author 陆辉
 * @create 2020-07-16 21:36
 */
public class Student {

  private Integer aid; //地区ID
  private String aname;//地区名称
  private Integer scid;//学校ID
  private String scname;//学校名称
  private Integer sid;//学生ID
  private String sname;//学生名称
  private Integer sex;//性别0女1男
  private Date birthday;//生日
  private String examnum;//准考证号
  private Map<String,Integer> scoreMap=new HashMap<> ();//学科成绩

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


  public Integer getSid() {
    return sid;
  }

  public void setSid(Integer sid) {
    this.sid = sid;
  }


  public String getSname() {
    return sname;
  }

  public void setSname(String sname) {
    this.sname = sname;
  }


  public Integer getSex() {
    return sex;
  }

  public void setSex(Integer sex) {
    this.sex = sex;
  }


  public Date getBirthday() {
    return birthday;
  }

  public void setBirthday(Date birthday) {
    this.birthday = birthday;
  }


  public String getExamnum() {
    return examnum;
  }

  public void setExamnum(String examnum) {
    this.examnum = examnum;
  }

  public Map<String, Integer> getScoreMap() {
    return scoreMap;
  }

  public void setScoreMap(Map<String, Integer> scoreMap) {
    this.scoreMap = scoreMap;
  }

  @Override
  public String toString() {
    return "Student{" +
            "aid=" + aid +
            ", aname='" + aname + '\'' +
            ", scid=" + scid +
            ", scname='" + scname + '\'' +
            ", sid=" + sid +
            ", sname='" + sname + '\'' +
            ", sex=" + sex +
            ", birthday=" + birthday +
            ", examnum='" + examnum + '\'' +
            ", scoreMap=" + scoreMap +
            '}';
  }
}
