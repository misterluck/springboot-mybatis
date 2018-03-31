package org.demo.springbootmybatis.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.demo.springbootmybatis.model.Province;

import java.util.List;

/**
 * Created by zhaol on 2017/12/22.
 */
public interface ProvinceMapper {

    List<Province> selectAllProvince();

}
