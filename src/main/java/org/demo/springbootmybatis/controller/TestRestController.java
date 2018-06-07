package org.demo.springbootmybatis.controller;

import com.github.pagehelper.Page;
import org.demo.springbootmybatis.model.City;
import org.demo.springbootmybatis.service.CityService;
import org.demo.springbootmybatis.service.MongoExampleService;
import org.demo.springbootmybatis.service.ProvinceService;
import org.demo.springbootmybatis.model.Province;
import org.demo.springbootmybatis.service.RedisExampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by zhaol on 2017/12/19.
 */
@RestController
public class TestRestController {

    @Autowired
    private ProvinceService provinceService;

    @Autowired
    private CityService cityService;
    @Autowired
    private RedisExampleService redisExampleService;
    @Autowired
    private MongoExampleService mongoExampleService;


    @RequestMapping(value = "/findProvince")
    public List<Province> findProvince(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        Page<Province> list = provinceService.findAllProvince(pageNum, 10);
        return list;
    }

    @RequestMapping(value = "/findCity")
    public List<City> findCity() {
        return cityService.findAllCity();
    }

    @RequestMapping(value = "/info")
    public String info() {
        //Redis Example
        //redisExampleService.save();

        //MongoDB Example
        //mongoExampleService.save();
        //mongoExampleService.find();
        //mongoExampleService.modify();

        //MongoDB gridFs Example
        mongoExampleService.gridFsSave();

        return "{info: success}";
    }

}
