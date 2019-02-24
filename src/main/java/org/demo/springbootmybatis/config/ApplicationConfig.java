package org.demo.springbootmybatis.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 自定义属性配置类
 * Created by zhaol on 2018/11/2.
 */
@Component
@ConfigurationProperties
public class ApplicationConfig {
    private SmsConfig sms = new SmsConfig();

    public SmsConfig getSms() {
        return sms;
    }
}
