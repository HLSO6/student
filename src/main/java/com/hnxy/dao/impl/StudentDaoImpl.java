package com.hnxy.dao.impl;

import com.hnxy.dao.StudentDao;
import com.hnxy.entity.Score;
import com.hnxy.entity.Student;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

/**
 * @author 陆辉
 * @create 2020-07-16 21:46
 */
@Repository
public class StudentDaoImpl implements StudentDao {
    @Autowired
    private QueryRunner qr;

    @Override
    public List<Student> findStudentsByPage(Integer pageIndex, Integer pageSize) {
        String sql = "select * from stu_v1 limit ?,?";
        try {
            List<Student> students = qr.query ( sql, new BeanListHandler<> ( Student.class ), pageIndex * pageSize, pageSize );
            for (Student s : students) {
                String sql2 = "select suname,rscore from stu_v2 where sid=?";
                List<Score> scores = qr.query ( sql2, new BeanListHandler<> ( Score.class ), s.getSid () );
                for (Score sc : scores) {
                    s.getScoreMap ().put ( sc.getSuname (), sc.getRscore () );
                }
            }
            return students;
        } catch (SQLException throwables) {
            throwables.printStackTrace ();
        }
        return null;
    }

    @Override
    public int findStudentsByPageCount() {
        String sql = "select count(*) from stu_v1";
        try {
            return qr.query ( sql, new ScalarHandler<Number> () ).intValue ();
        } catch (SQLException throwables) {
            throwables.printStackTrace ();
        }
        return 0;
    }

    @Override
    public void deleteStudentById(Integer sid) {
        String sql = "delete from student where s_id=?";
        String sql2 = "delete from result where s_id=?";
        try {
            qr.update ( sql2, sid );
            qr.update ( sql, sid );
        } catch (SQLException throwables) {
            throwables.printStackTrace ();
        }
    }

    @Override
    public void insertStudent(Student student) {
        //需要事务，封装信息，同时插入两张表
        Connection conn = null;
        try {
            //获得连接
            conn=qr.getDataSource ().getConnection ();

            //更新学生表student
            String sql = "insert into student values(null,?,?,?,?,?)";
            Object[] params = {student.getSname (), student.getSex (),
                    student.getBirthday (),student.getExamnum (),student.getScid ()};
            qr.update ( conn,sql, params);

            //获得新增学生的主键
            String sql2="select last_insert_id()";
            Number num = qr.query(conn, sql2, new ScalarHandler<Number>());
            int id = num.intValue();

            //更新学科分数映射表result
            String sql1 = "insert into result values(null,?,?,?),(null,?,?,?),(null,?,?,?),(null,?,?,?)";
            Object[] params1 = {1,id,student.getScoreMap ().get ( "语文" ),
                    2,id,student.getScoreMap ().get ( "数学" ),
                    3,id,student.getScoreMap ().get ( "英语" ),
                    4,id,student.getScoreMap ().get ( "综合" )};
            qr.update (conn, sql1,params1 );

        } catch (SQLException throwables) {
            throwables.printStackTrace ();
        }
    }

    @Override
    public void updateStudent(Student student) {
        //需要事务，封装信息，同时插入两张表
        Connection conn = null;
        try {
            //获得连接
            conn=qr.getDataSource ().getConnection ();

            //更新学生表student
            String sql = "update student set s_name=?,s_sex=?,s_birthday=?,s_examnum=?,sc_id=? where s_id=?";
            Object[] params = {student.getSname (), student.getSex (),
                    student.getBirthday (),student.getExamnum (),student.getScid (),student.getSid ()};
            qr.update ( conn,sql, params);

            //更新学科分数映射表result
            String sql1 = "insert into result values(null,?,?,?),(null,?,?,?),(null,?,?,?),(null,?,?,?)";
            Object[] params1 = {1,student.getSid (),student.getScoreMap ().get ( "语文" ),
                    2,student.getSid (),student.getScoreMap ().get ( "数学" ),
                    3,student.getSid (),student.getScoreMap ().get ( "英语" ),
                    4,student.getSid (),student.getScoreMap ().get ( "综合" )};
            qr.update (conn, sql1,params1 );

        } catch (SQLException throwables) {
            throwables.printStackTrace ();
        }
    }

    @Override
    public Student findStudentById(Integer id) {
        String sql = "select * from stu_v1 where sid=?";
        try {
            Student student = qr.query ( sql, new BeanHandler<> ( Student.class ), id );
                String sql2 = "select suname,rscore from stu_v2 where sid=?";
                List<Score> scores = qr.query ( sql2, new BeanListHandler<> ( Score.class ), student.getSid () );
                for (Score sc : scores) {
                    student.getScoreMap ().put ( sc.getSuname (), sc.getRscore () );
                }
            return student;
        } catch (SQLException throwables) {
            throwables.printStackTrace ();
        }
        return null;
    }
}
