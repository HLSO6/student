package com.hnxy.service.impl;

import com.hnxy.dao.AreaDao;
import com.hnxy.entity.Area;
import com.hnxy.entity.School;
import com.hnxy.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 陆辉
 * @create 2020-07-17 21:21
 */
@Service
public class AreaServiceImpl implements AreaService {
    @Autowired
    private AreaDao areaDao;
    @Override
    public List<Area> findAllAreas() {
        return areaDao.findAllAreas ();
    }

    @Override
    public List<School> findAllSchoolById(Integer id) {
        return areaDao.findAllSchoolById ( id );
    }
}
