package com.fastcampus.chap1clip1;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

    @KafkaListener(id = "fast-campus-id", topics = "quickstart-events") // consumer, group id, topics
    public void listen(String message) {
        System.out.println("=====");
        System.out.println(message);
        System.out.println("=====");
    }
}
