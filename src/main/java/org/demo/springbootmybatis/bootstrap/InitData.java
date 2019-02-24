package org.demo.springbootmybatis.bootstrap;

import org.demo.springbootmybatis.config.ApplicationConfig;
import org.demo.springbootmybatis.config.SmsConfig;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * Created by zhaol on 2018/11/2.
 */
@Component
public class InitData implements InitializingBean {

    @Autowired
    private ApplicationConfig applicationConfig;

    @Override
    public void afterPropertiesSet() throws Exception {
        SmsConfig sms = applicationConfig.getSms();
        List<String> list = sms.getList();
        for (String item:list) {
            System.out.println(item);
        }
        Map<String, String> map = sms.getMap();
        for (Map.Entry<String, String> entry: map.entrySet()) {
            System.out.println(entry.getKey()+"\t"+entry.getValue());
        }

    }
}
