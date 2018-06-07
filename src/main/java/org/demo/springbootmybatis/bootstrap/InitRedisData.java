package org.demo.springbootmybatis.bootstrap;

import org.demo.springbootmybatis.service.RedisExampleService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by zhaol on 2018/5/21.
 */
@Component
public class InitRedisData implements InitializingBean {

    @Autowired
    private RedisExampleService redisExampleService;

    @Override
    public void afterPropertiesSet() throws Exception {
        //redisExampleService.trim();
    }
}
