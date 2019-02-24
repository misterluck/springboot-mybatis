package org.demo.springbootmybatis.service.impl;

import org.demo.springbootmybatis.mapper.ProvinceMapper;
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

}
