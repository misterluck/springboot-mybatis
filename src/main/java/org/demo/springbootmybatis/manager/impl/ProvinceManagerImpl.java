package org.demo.springbootmybatis.manager.impl;

import org.demo.springbootmybatis.manager.ProvinceManager;
import org.demo.springbootmybatis.mapper.ProvinceMapper;
import org.demo.springbootmybatis.model.Province;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zhaol on 2017/12/24.
 */
@Service
public class ProvinceManagerImpl implements ProvinceManager {
    @Autowired
    private ProvinceMapper provinceMapper;

    @Override
    public List<Province> findAllProvince() {
        return provinceMapper.selectAllProvince();
    }
}
