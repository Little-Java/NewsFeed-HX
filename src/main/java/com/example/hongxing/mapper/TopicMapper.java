package com.example.hongxing.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.hongxing.dto.TopicDto;
import com.example.hongxing.dto.TopicEntityEx;
import com.example.hongxing.entity.TopicEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface TopicMapper extends BaseMapper<TopicEntity> {

    List<TopicDto> queryTopicList(@Param("topicId") Integer topicId, @Param("topicName")String topicName);

    List<TopicEntityEx> getTopicAll(@Param("topicId") Integer topicId, @Param("topicName")String topicName);
}
