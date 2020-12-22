package com.example.hongxing.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.hongxing.dto.SiteDto;
import com.example.hongxing.entity.SiteEntity;
import com.example.hongxing.mapper.SiteMapper;
import com.example.hongxing.service.SiteService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SiteServiceImpl extends ServiceImpl<SiteMapper, SiteEntity> implements SiteService {

    @Autowired
    private SiteMapper siteMapper;

    @Override
    public List<SiteDto> getSiteDtoAll(Integer siteId, String siteName){
        return siteMapper.querySiteList(siteId, siteName);
    }

    @Override
    public List<SiteEntity> getSiteAll(){
        QueryWrapper<SiteEntity> queryWrapper = new QueryWrapper<>();
        return siteMapper.selectList(queryWrapper);
    }
}
