package org.demo.springbootmybatis.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.demo.springbootmybatis.mapper.ProvinceMapper;
import org.demo.springbootmybatis.model.Province;
import org.demo.springbootmybatis.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by zhaol on 2017/12/24.
 */
@Service
public class ProvinceServiceImpl implements ProvinceService {
    @Autowired
    private ProvinceMapper provinceMapper;

    @Override
    public Page<Province> findAllProvince(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return provinceMapper.selectAllProvince();
    }

}
