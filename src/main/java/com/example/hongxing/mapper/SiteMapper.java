package com.example.hongxing.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.hongxing.dto.SiteDto;
import com.example.hongxing.entity.SiteEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface SiteMapper extends BaseMapper<SiteEntity> {

    List<SiteDto> querySiteList(@Param("siteId") Integer siteId, @Param("siteName")String siteName);
}
