package com.fastcampus.clip1;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.listener.AbstractConsumerSeekAware;
import org.springframework.stereotype.Component;

@Component
public class ClipConsumer extends AbstractConsumerSeekAware {

    @KafkaListener(id = "clip1-listner-id", topics = "clip1-listener")
    public void listen(String message) {
        System.out.println("message = " + message);
    }

    public void seek() {
        getSeekCallbacks().forEach(((topicPartition, consumerSeekCallback) -> consumerSeekCallback.seek(topicPartition.topic(), topicPartition.partition(), 0)));
    }

}
