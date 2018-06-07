package org.demo.springbootmybatis.service;

import com.github.pagehelper.Page;
import org.demo.springbootmybatis.model.Province;

import java.util.List;

/**
 * Created by zhaol on 2017/12/24.
 */
public interface ProvinceService {
    Page<Province> findAllProvince(int pageNum, int pageSize);
}
