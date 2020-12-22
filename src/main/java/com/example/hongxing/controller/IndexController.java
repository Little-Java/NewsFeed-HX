package com.example.hongxing.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping("/")
    public String index() {
        logger.info("定向首页");
        return "login";
    }

    @RequestMapping("login")
    public String tologin() {
        logger.info("定向登陆页");
        return "login";
    }

}
