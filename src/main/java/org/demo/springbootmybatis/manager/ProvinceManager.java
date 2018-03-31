package org.demo.springbootmybatis.manager;

import org.demo.springbootmybatis.model.Province;

import java.util.List;

/**
 * Created by zhaol on 2017/12/24.
 */
public interface ProvinceManager {
    List<Province> findAllProvince();
}
