package com.example.hongxing.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.hongxing.entity.OrganEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


@Repository
@Mapper
public interface OrganMapper extends BaseMapper<OrganEntity> {

    OrganEntity getOrganByOgIndex(@Param("ogIndex") Integer ogIndex);

    OrganEntity getOrganByOgId(@Param("ogId") String ogId);
}
