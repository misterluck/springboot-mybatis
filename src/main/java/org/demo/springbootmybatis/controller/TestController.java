package org.demo.springbootmybatis.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by zhaol on 2017/12/19.
 */
@Controller
public class TestController {

    @RequestMapping(value = "/index")
    public String index() {
        return "index";
    }

}
