package org.demo.springbootmybatis.config;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zhaol on 2018/11/2.
 */
public class SmsConfig {
    private List<String> list = new ArrayList<>();

    private Map<String, String> map = new HashMap<>();

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public Map<String, String> getMap() {
        return map;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }
}
