package com.example.hongxing.kafka;

import org.springframework.boot.autoconfigure.kafka.ConcurrentKafkaListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;

@Configuration
public class batchFactoryBean {
    /**
     * kafka监听工厂
     * @param configurer
     * @return
     */
    @Bean("batchFactory")
    public ConcurrentKafkaListenerContainerFactory<?, ?> kafkaListenerContainerFactory(
            ConcurrentKafkaListenerContainerFactoryConfigurer configurer, ConsumerFactory consumerFactory) {
        ConcurrentKafkaListenerContainerFactory<Object, Object> factory = new ConcurrentKafkaListenerContainerFactory<>();
          // 开启批量消费功能
        factory.setBatchListener(true);
        // 不自动启动
        factory.setAutoStartup(false);
        configurer.configure(factory, consumerFactory);
        return factory;
    }
}
