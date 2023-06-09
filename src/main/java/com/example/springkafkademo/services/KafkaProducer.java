package com.example.springkafkademo.services;

import com.example.springkafkademo.models.User;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class KafkaProducer {

    KafkaTemplate<String, String> kafkaTemplate;

    public void sendStringToKafka(String message) {
        log.info("Message sent : " + message);
        kafkaTemplate.send("myTestTopic", message);
    }

    public void sendObjectToKafka(User user) {
        log.info("Message sent : " + user.toString());

        Message<User> message = MessageBuilder.withPayload(user)
                .setHeader(KafkaHeaders.TOPIC, "myTestObject")
                .build();

        kafkaTemplate.send(message);
    }

}
