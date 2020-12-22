package com.example.hongxing.kafka;

import com.alibaba.fastjson.JSON;

import com.example.hongxing.dto.KafkaDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaProducer {

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    /**
     * 启动发送消息方法
     * @param kafkaDto
     */
    public void addMessage(KafkaDto kafkaDto) {
        String jsonStrTraining = JSON.toJSONString(kafkaDto);
        System.out.println("发送消息："+jsonStrTraining);
        kafkaTemplate.send("start_kafka", jsonStrTraining);
    }

}