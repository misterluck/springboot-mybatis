package org.demo.springbootmybatis.service;

import org.demo.springbootmybatis.model.City;

import java.util.List;

/**
 * Created by zhaol on 2018/5/2.
 */
public interface CityService {

    List<City> findAllCity();

}
