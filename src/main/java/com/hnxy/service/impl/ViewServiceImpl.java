package com.hnxy.service.impl;

import com.hnxy.dao.AreaDao;
import com.hnxy.dao.ViewDao;
import com.hnxy.service.ViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author 陆辉
 * @create 2020-07-19 22:13
 */
@Service
public class ViewServiceImpl implements ViewService {
    @Autowired
    private ViewDao viewDao;

    @Override
    public Map<String, Object> findScoreLine() {
        return viewDao.findScoreLine ();
    }

    @Override
    public List<Object> findAreaStudents() {
        return viewDao.findAreaStudents ();
    }

    @Override
    public List<Object> findAreaStudentsByLine() {
        return viewDao.findAreaStudentsByLine ();
    }
}
