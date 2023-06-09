package com.example.springkafkademo.config;


import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    @Bean
    public NewTopic myTestTopic() {
        return TopicBuilder.name("myTestString").build();
    }

    @Bean
    public NewTopic objectSendTopic() {
        return TopicBuilder.name("myTestObject").build();
    }

}
