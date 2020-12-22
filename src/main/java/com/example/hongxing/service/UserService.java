package com.example.hongxing.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.hongxing.common.Result;
import com.example.hongxing.entity.UserEntity;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface UserService extends IService<UserEntity> {

    Result userLogin(String usAccounts, String rawPassword, HttpServletRequest request, HttpServletResponse response);

    List<UserEntity> queryUserList();
}
