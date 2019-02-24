package org.demo.springbootmybatis.controller;

import org.demo.springbootmybatis.model.City;
import org.demo.springbootmybatis.service.*;
import org.demo.springbootmybatis.model.Province;
import org.demo.springbootmybatis.thread.MonitorManagerTask;
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
    private CityService cityService;
    @Autowired
    private RedisExampleService redisExampleService;
    @Autowired
    private MongoExampleService mongoExampleService;
    @Autowired
    private FastDFSExampleService fastDFSExampleService;
    @Autowired
    private MonitorManagerTask monitor;

    @RequestMapping(value = "/findCity")
    public List<City> findCity() {
        return cityService.findAllCity();
    }

    @RequestMapping(value = "/info")
    public String info() {

        //MongoDB Example
        //mongoExampleService.save();
        //mongoExampleService.find();
        //mongoExampleService.modify();

        //MongoDB gridFs Example
        //mongoExampleService.gridFsSave();

        return "{info: success}";
    }

    @RequestMapping(value = "/redis")
    public String redis() {
        //Redis Example
        //redisExampleService.save();
        //redisExampleService.saveList();
        //redisExampleService.removeList();
        redisExampleService.show();
        return "{info: success}";
    }

    @RequestMapping(value = "/fastDFS")
    public String fastDFS() {
        //fastDFSExampleService.contextLoads();
        //fastDFSExampleService.uploadFile();
        fastDFSExampleService.downloadFile();
        //fastDFSExampleService.deleteFile();
        return "{info: success}";
    }

    @RequestMapping(value = "/startUserThread")
    public String startUserThread() {
        monitor.startUserThread();
        return "{info: success}";
    }

    @RequestMapping(value = "/stopUserThread")
    public String stopUserThread(String uuid) {
        monitor.stopUserThread(uuid);
        return "{info: success}";
    }

}
