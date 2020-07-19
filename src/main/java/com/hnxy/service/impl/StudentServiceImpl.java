package com.hnxy.service.impl;

import com.hnxy.dao.StudentDao;
import com.hnxy.entity.Student;
import com.hnxy.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 陆辉
 * @create 2020-07-16 22:16
 */
@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentDao studentDao;
    @Override
    public List<Student> findStudentsByPage(Integer pageIndex, Integer pageSize) {
        return studentDao.findStudentsByPage (pageIndex,  pageSize);
    }

    @Override
    public int findStudentsByPageCount() {
        return studentDao.findStudentsByPageCount (  );
    }

    @Override
    public void deleteStudentById(Integer sid) {
         studentDao.deleteStudentById ( sid );
    }

    @Override
    public void insertStudent(Student student) {
        studentDao.insertStudent ( student );
    }

    @Override
    public void updateStudent(Student student) {
        studentDao.updateStudent ( student );
    }

    @Override
    public Student findStudentById(Integer id) {
        return studentDao.findStudentById ( id );
    }
}
