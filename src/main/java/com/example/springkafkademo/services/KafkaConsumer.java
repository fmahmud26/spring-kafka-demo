package com.example.springkafkademo.services;


import com.example.springkafkademo.models.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class KafkaConsumer {

    @KafkaListener(topics = "myTestString", groupId = "myTestGroup")
    public void consumeString(String message) {
        log.info("Received string: " + message);
    }

    @KafkaListener(topics = "myTestObject", groupId = "myTestGroup")
    public void consumeObject(User user) {
        log.info("Received object: " + user.toString());
    }

}
