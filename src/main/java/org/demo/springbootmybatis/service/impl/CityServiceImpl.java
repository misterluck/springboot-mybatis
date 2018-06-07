package org.demo.springbootmybatis.service.impl;

import org.demo.springbootmybatis.mapper.CityMapper;
import org.demo.springbootmybatis.model.City;
import org.demo.springbootmybatis.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zhaol on 2018/5/2.
 */
@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityMapper cityMapper;

    @Override
    public List<City> findAllCity() {
        List<City> list = cityMapper.selectAllCity();
        return list;
    }
}
