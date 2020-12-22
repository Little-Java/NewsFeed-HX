package com.example.hongxing.controller;

import com.example.hongxing.common.Result;
import com.example.hongxing.entity.UserEntity;
import com.example.hongxing.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("user")
public class UserController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserService userService;

    @RequestMapping(value="/loginUser")
    @ResponseBody
    public Result login(String username, String password, HttpServletRequest request, HttpServletResponse response){
        if(username ==null || username == "" || password ==null || password ==""){
            return new Result(500, "登录失败,请核对账户密码");
        }
        try {
            Result result = new Result();
            result = userService.userLogin(username, password, request, response);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(500, "登录失败");
        }
    }

    @RequestMapping(value="/queryUserList")
    @ResponseBody
    public Result queryUserList(){
        List<UserEntity> list = userService.queryUserList();
        if(list == null || list.size()<=0){
            return new Result(500, "没有用户");
        }
        return new Result(0, "请求成功", list, list.size());
    }

    @RequestMapping(value="/test")
    @ResponseBody
    public Result test(HttpServletRequest request, HttpServletResponse response){
        return new Result(200, "请求成功");
    }

}
