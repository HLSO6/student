package com.hnxy.service;

import java.util.List;
import java.util.Map;

/**
 * @author 陆辉
 * @create 2020-07-19 22:07
 */
public interface ViewService {
    /**
     * 各分数线人数
     */
    Map<String,Object> findScoreLine();
    /**
     * 统计各个区域参加考试人数
     */
    List<Object> findAreaStudents();
    /**
     * 统计各个区域各个分数线人数
     */
    List<Object> findAreaStudentsByLine();
}

