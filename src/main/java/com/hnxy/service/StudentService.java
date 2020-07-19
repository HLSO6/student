package com.hnxy.service;

import com.hnxy.entity.Student;

import java.util.List;

/**
 * @author 陆辉
 * @create 2020-07-16 22:16
 */
public interface StudentService {
    //分页查询
    List<Student> findStudentsByPage(Integer pageIndex, Integer pageSize);
    //获得数据总条数
    int findStudentsByPageCount();
    //根据学生ID删除学生信息包含学生成绩
    void deleteStudentById(Integer sid);
    //插入学生信息
    void insertStudent(Student student);
    //更新学生信息
    void updateStudent(Student student);
    //根据ID获取学生信息
    Student findStudentById(Integer id);
}

