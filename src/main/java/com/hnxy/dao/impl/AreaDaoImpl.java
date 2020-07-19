package com.hnxy.dao.impl;

import com.hnxy.dao.AreaDao;
import com.hnxy.entity.Area;
import com.hnxy.entity.School;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

/**
 * @author 陆辉
 * @create 2020-07-17 21:16
 */
@Repository
public class AreaDaoImpl implements AreaDao {
    @Autowired
    private  QueryRunner qr;
    @Override
    public List<Area> findAllAreas() {
        String sql = "select a_id aid,a_name aname from area";
        try {
            List<Area> areas = qr.query ( sql,new BeanListHandler<> ( Area.class ) );
            return  areas;
        } catch (SQLException throwables) {
            throwables.printStackTrace ();
        }
        return null;
    }

    @Override
    public List<School> findAllSchoolById(Integer id) {
        String sql = "select scid,scname from stu_v3 where aid=?";
        try {
            List<School> schools = qr.query ( sql,new BeanListHandler<> ( School.class ) ,id);

            return schools;
        } catch (SQLException throwables) {
            throwables.printStackTrace ();
        }
        return null;
    }
}
