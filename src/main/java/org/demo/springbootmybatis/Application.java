package org.demo.springbootmybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by zhaol on 2017/12/19.
 */
@SpringBootApplication
@MapperScan(value = "org.demo.springbootmybatis.mapper")
public class Application {

    public static void main(String[] args) {
        //SpringApplication.run(Application.class, args);
        SpringApplication application = new SpringApplication();
        application.run(Application.class, args);
    }

}
