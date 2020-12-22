package com.example.hongxing.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.hongxing.dto.TopicDto;
import com.example.hongxing.dto.TopicEntityEx;
import com.example.hongxing.entity.TopicEntity;
import com.example.hongxing.mapper.TopicMapper;
import com.example.hongxing.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicServiceImpl extends ServiceImpl<TopicMapper, TopicEntity> implements TopicService {

    @Autowired
    private TopicMapper topicMapper;

    @Override
    public List<TopicDto> getTopicDtoAll(Integer siteId, String siteName){
        return topicMapper.queryTopicList(siteId, siteName);
    }

    @Override
    public List<TopicEntityEx> getTopicAll(Integer siteId, String siteName){
        return topicMapper.getTopicAll(siteId, siteName);
    }
}
