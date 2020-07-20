package com.hnxy.dao.impl;

import com.hnxy.dao.ViewDao;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ColumnListHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author 陆辉
 * @create 2020-07-19 22:09
 */
@Repository
public class ViewDaoImpl implements ViewDao {
    @Autowired
    private QueryRunner qr;

    @Override
    public Map<String, Object> findScoreLine() {
        Map<String, Object> map = null;
        String sql="select * from stu_v5";
        try {
            return qr.query ( sql,new MapHandler () );
        } catch (SQLException throwables) {
            throwables.printStackTrace ();
        }
        return null;
    }

    @Override
    public List<Object> findAreaStudents() {
        List<Object> lists = new ArrayList<> ();
        String sql ="select * from stu_v6";
        try {
            List<Object> query1 = qr.query ( sql, new ColumnListHandler<> ( 2 ) );
            List<Object> query2 = qr.query ( sql, new ColumnListHandler<> ( 3 ) );
            lists.add ( query1 );
            lists.add ( query2 );
            return  lists;
        } catch (SQLException throwables) {
            throwables.printStackTrace ();
        }
        return null;
    }

    @Override
    public List<Object> findAreaStudentsByLine() {
        List<Object> lists = new ArrayList<> ();
        String sql ="select * from stu_v7";
        try {
            List<Object> query1 = qr.query ( sql, new ColumnListHandler<> ( 1 ) );
            List<Object> query2 = qr.query ( sql, new ColumnListHandler<> ( 2 ) );
            List<Object> query3 = qr.query ( sql, new ColumnListHandler<> ( 3 ) );
            List<Object> query4 = qr.query ( sql, new ColumnListHandler<> ( 4 ) );
            List<Object> query5 = qr.query ( sql, new ColumnListHandler<> ( 5 ) );
            List<Object> query6 = qr.query ( sql, new ColumnListHandler<> ( 6 ) );
            lists.add ( query1 );
            lists.add ( query2 );
            lists.add ( query3 );
            lists.add ( query4 );
            lists.add ( query5 );
            lists.add ( query6 );
            return  lists;
        } catch (SQLException throwables) {
            throwables.printStackTrace ();
        }
        return null;
    }
}
