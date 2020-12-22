package com.example.hongxing.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.hongxing.dto.TopicDto;
import com.example.hongxing.dto.TopicEntityEx;
import com.example.hongxing.entity.TopicEntity;

import java.util.List;

public interface TopicService extends IService<TopicEntity> {

    List<TopicDto> getTopicDtoAll(Integer topicId, String topicName);

    List<TopicEntityEx> getTopicAll(Integer topicId, String topicName);

}
