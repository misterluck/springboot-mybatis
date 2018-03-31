package org.demo.springbootmybatis.controller;

import org.demo.springbootmybatis.manager.ProvinceManager;
import org.demo.springbootmybatis.mapper.ProvinceMapper;
import org.demo.springbootmybatis.model.Province;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by zhaol on 2017/12/19.
 */
@RestController
public class TestRestController {

    private ProvinceManager provinceManager;

    @RequestMapping(value = "/findProvince")
    public List<Province> findProvince() {
        List<Province> list = provinceManager.findAllProvince();
        return list;
    }

}
