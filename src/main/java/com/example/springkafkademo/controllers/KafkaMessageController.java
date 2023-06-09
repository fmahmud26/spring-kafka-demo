package com.example.springkafkademo.controllers;


import com.example.springkafkademo.models.User;
import com.example.springkafkademo.services.KafkaProducer;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/v1/kafka")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class KafkaMessageController {

    KafkaProducer kafkaProducer;

    @GetMapping("/publish/string")
    public ResponseEntity<String> publish(@RequestParam("message") String message) {
        log.info("Hit controller to publish message: " + message);
        kafkaProducer.sendStringToKafka(message);
        return ResponseEntity.ok("Message sent to the topic.");
    }

    @PostMapping("/publish/object")
    public ResponseEntity<String> publish(@RequestBody User user) {
        kafkaProducer.sendObjectToKafka(user);
        return ResponseEntity.ok("Json message sent to kafka topic");
    }

}
