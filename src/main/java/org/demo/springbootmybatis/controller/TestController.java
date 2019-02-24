package org.demo.springbootmybatis.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * Created by zhaol on 2017/12/19.
 */
@Controller
public class TestController {

    @RequestMapping(value = "/index")
    public String index() {
        return "index";
    }

    /**
     * 验证Codis存储Session值
     * @param session
     * @return
     */
    @RequestMapping(value = "/saveCodisInfo")
    @ResponseBody
    public String saveCodisInfo(HttpSession session) {
        session.setAttribute("info", "{'code':'200', 'info':'success'}");
        return "{'code':'200', 'info':'success'}";
    }

    @RequestMapping(value = "/getCodisInfo")
    @ResponseBody
    public String getCodisInfo(HttpSession session) {
        String str = (String) session.getAttribute("info");
        System.out.println(str);
        return "{'code':'200', 'info':'success'}";
    }

}
