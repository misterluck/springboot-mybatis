package org.demo.springbootmybatis;

import com.github.tobato.fastdfs.FdfsClientConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

/**
 * Created by zhaol on 2017/12/19.
 */
@SpringBootApplication
@MapperScan(value = "org.demo.springbootmybatis.mapper")
@Import(FdfsClientConfig.class)
public class Application {

    public static void main(String[] args) {
        //SpringApplication.run(Application.class, args);
        SpringApplication application = new SpringApplication();
        application.run(Application.class, args);
    }

}
