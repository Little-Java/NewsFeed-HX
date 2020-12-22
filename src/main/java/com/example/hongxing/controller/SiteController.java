package com.example.hongxing.controller;

import com.example.hongxing.common.Result;
import com.example.hongxing.dto.SiteDto;
import com.example.hongxing.entity.SiteEntity;
import com.example.hongxing.service.SiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("site")
public class SiteController {

    @Autowired
    private SiteService siteService;

    @PostMapping("/getSiteDtoAll")
    @ResponseBody
    public Result<List<SiteDto>> getSiteDtoAll(Integer siteId, String siteName){
        Result<List<SiteDto>> result = new Result<List<SiteDto>>();
        result.setMessage("请求成功");
        result.setStatusCode(200);
        result.setResult(siteService.getSiteDtoAll(siteId, siteName));
        return result;
    }

    @PostMapping("/getSiteAll")
    public Result<List<SiteEntity>> getSiteAll(){
        Result<List<SiteEntity>> result = new Result<List<SiteEntity>>();
        result.setMessage("请求成功");
        result.setStatusCode(200);
        result.setResult(siteService.getSiteAll());
        return result;
    }
}
