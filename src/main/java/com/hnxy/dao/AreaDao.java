package com.hnxy.dao;

import com.hnxy.entity.Area;
import com.hnxy.entity.School;
import com.hnxy.entity.Student;

import java.util.List;

/**
 * @author 陆辉
 * @create 2020-07-17 21:15
 */
public interface AreaDao {
    //查找所有地区
    List<Area> findAllAreas();
    //根据地区ID查找所有学校
    List<School> findAllSchoolById(Integer id);
}
