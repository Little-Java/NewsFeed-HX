package com.example.hongxing.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.hongxing.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface UserMapper extends BaseMapper<UserEntity> {

    UserEntity selectUserByName(@Param("usAccounts") String usAccounts);

    UserEntity selectUserById(@Param("usId") Integer usId);

    List<UserEntity> queryUserList();
}
