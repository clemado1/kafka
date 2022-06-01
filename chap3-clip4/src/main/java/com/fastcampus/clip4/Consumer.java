package com.fastcampus.clip4;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

    @KafkaListener(id = "clip4-to-listener", topics = "clip4-to")
    public void listen(String message) {
        System.out.println("listener. message = " + message);
    }
}
