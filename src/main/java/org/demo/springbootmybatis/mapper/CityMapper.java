package org.demo.springbootmybatis.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.demo.springbootmybatis.model.City;

import java.util.List;

/**
 * Created by zhaol on 2018/5/2.
 */
@Mapper
public interface CityMapper {
    List<City> selectAllCity();

}
