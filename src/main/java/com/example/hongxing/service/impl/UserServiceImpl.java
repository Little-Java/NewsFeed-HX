package com.example.hongxing.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.hongxing.common.RedisClient;
import com.example.hongxing.common.Result;
import com.example.hongxing.entity.UserEntity;
import com.example.hongxing.mapper.UserMapper;
import com.example.hongxing.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, UserEntity> implements UserService {

    @Autowired
    private UserMapper userMapper;

//    @Autowired
//    private RedisClient redisClinet;

    @Override
    public Result userLogin(String usAccounts, String rawPassword, HttpServletRequest request, HttpServletResponse response) {
        UserEntity user = userMapper.selectUserByName(usAccounts);
        if(user != null) {
            if(user.getRawPassword().equals(rawPassword)){
                String sessionId = request.getRequestedSessionId();
//                try {
//                    redisClinet.set(user.getUsId().toString(), sessionId);
//                    redisClinet.expire(user.getUsId().toString(), 1800);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
                return new Result(200, "请求成功", sessionId);
            }
            return new Result(500, "密码不正确");
        }
        return new Result(500,"用户不存在");
    }

    @Override
    public List<UserEntity> queryUserList() {
        QueryWrapper<UserEntity> queryWrapper = new QueryWrapper<>();
        return userMapper.selectList(queryWrapper);
    }


}
