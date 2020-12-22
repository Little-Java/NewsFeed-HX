package com.example.hongxing.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.hongxing.dto.SiteDto;
import com.example.hongxing.entity.SiteEntity;

import java.util.List;

public interface SiteService extends IService<SiteEntity> {

    List<SiteDto> getSiteDtoAll(Integer siteId, String siteName);

    List<SiteEntity> getSiteAll();
}
