package com.example.hongxing.controller;

import com.example.hongxing.common.Result;
import com.example.hongxing.dto.TopicDto;
import com.example.hongxing.dto.TopicEntityEx;
import com.example.hongxing.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("topic")
public class TopicController {

    @Autowired
    private TopicService topicService;

    @PostMapping("/getTopicDtoAll")
    @ResponseBody
    public Result<List<TopicDto>> getTopicDtoAll(Integer topicId, String topicName){
        Result<List<TopicDto>> result = new Result<List<TopicDto>>();
        result.setMessage("请求成功");
        result.setStatusCode(200);
        result.setResult(topicService.getTopicDtoAll(topicId, topicName));
        return result;
    }

    @PostMapping("/getTopicAll")
    @ResponseBody
    public Result<List<TopicEntityEx>> getTopicAll(Integer topicId, String topicName){
        List<TopicEntityEx> list = topicService.getTopicAll(topicId, topicName);
        if(list == null || list.size()<=0){
            return new Result(500, "没有站点");
        }
        return new Result(0, "请求成功", list, list.size());
    }
}
